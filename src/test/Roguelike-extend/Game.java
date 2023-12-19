import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player player;
    private Monster monster;
    private int winStreak;
    private static final int MAX_WINS = 10;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public Game() {
        System.out.print("プレイヤーの名前を入力してください: ");
        String playerName = scanner.nextLine();
        this.player = new Player(playerName);
        this.monster = new Monster();
        this.winStreak = 0;
    }

    private Monster createRandomMonster() {
        int monsterType = random.nextInt(3);
        switch (monsterType) {
            case 0:
                return new Goblin();
            case 1:
                return new Orc();
            case 2:
                return new Dragon();
            default:
                return new Goblin(); // デフォルトのケース
        }
    }


    private boolean playerTurn() {
        System.out.println("行動を選択してください: 1. 攻撃する 2. 防御する");
        int choice = scanner.nextInt();
        return choice == 1;
    }

    private boolean monsterTurn() {
        int attackChance = 50; // 攻撃する確率を50%に設定
        return random.nextInt(100) < attackChance; // 0から99の整数で、30未満の場合に攻撃
    }

    private boolean fight() {
        boolean playerAttacks = playerTurn();
        boolean monsterAttacks = monsterTurn();

        // プレイヤーの攻撃処理
        if (playerAttacks) {
            int damageDealt = player.getAttackPower();
            monster.setHp(monster.getHp() - damageDealt);
            System.out.println("モンスターに " + damageDealt + " のダメージを与えた！");
            if (monster.getHp() <= 0) {
                System.out.println("モンスターを倒した！");
                return true; // プレイヤーの勝利
            }
        }

        // モンスターの攻撃処理
        if (monsterAttacks && monster.getHp() > 0) {
            int damage = playerAttacks ? monster.getAttack() : Math.max(monster.getAttack() - player.getDefensePower(), 0);
            player.setHp(player.getHp() - damage);
            System.out.println(monster.getType() + "が攻撃！ 受けたダメージ: " + damage);
            if (player.getHp() <= 0) {
                System.out.println("プレイヤーが倒れた... ゲームオーバー");
                return false; // プレイヤーの敗北
            }
        } else if (monsterAttacks) {
            System.out.println(monster.getType() + "は攻撃を仕掛けてきたが、ミス！");
        } else {
            System.out.println(monster.getType() + "は何もしなかった。");
        }

        return false; // 戦いが続く
    }

    private int selectAttributeToRetain() {
        System.out.println("どの属性を引き継ぎますか？");
        System.out.println("1. 最大HP");
        System.out.println("2. 攻撃力");
        System.out.println("3. 防御力");
        System.out.print("選択してください（1, 2, 3）: ");
        return scanner.nextInt(); // 選択された属性の種類を返す
    }

    public void start() {
        System.out.println(player.getName() + "が冒険を始める！");
        monster = createRandomMonster(); // ゲーム開始時に最初のモンスターを生成

        while (winStreak < MAX_WINS) {
            System.out.println("現在のHP: " + player.getHpStatus() + " (攻撃力: " + player.getAttackPower() + ", 防御力: " + player.getDefensePower() + ")");
            System.out.println(monster.getType() + "が現れた！戦闘開始！"); // モンスターの種類を表示
            System.out.println("モンスターのHP: " + monster.getHp() + ", 攻撃力: " + monster.getAttack());

            boolean won = fight();
            if (won) {
                winStreak++;
                System.out.println("勝利！現在の連勝数: " + winStreak);
                monster = createRandomMonster(); // 新しいモンスターの生成
            } else if (player.getHp() <= 0) {
                System.out.println("敗北...");
                int choice = selectAttributeToRetain();

                // 属性の再設定
                if (choice != 1) player.randomizeMaxHp(); // 最大HPをランダムに再設定
                if (choice != 2) player.randomizeAttackPower(); // 攻撃力をランダムに再設定
                if (choice != 3) player.randomizeDefensePower(); // 防御力をランダムに再設定

                winStreak = 0;
            }

            if (player.getHp() <= 0) {
                System.out.println("プレイヤーが倒れた... ゲームオーバー");
                break;
            }

            if (winStreak >= MAX_WINS) {
                System.out.println("ゲームクリア！おめでとう！");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
