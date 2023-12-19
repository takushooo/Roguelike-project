// 課題要件を形式的に満たすためのコード例。課題要件が満たされていれば加点こそすれど、動くのであれば減点はしません。
// 要件的にはもっと楽できると思いますが、これくらい書いてあるとレポートが書きやすいかなと思いました。

import java.util.Scanner;
import java.util.Random;

interface Character {
    int getHp();
    void setHp(int hp);
    int attack();
}

class Player implements Character {
    private String name;
    private int hp;
    private int mp;
    private Equipment equipment;

    public Player(String name) {
        this.name = name;
        this.hp = (int)(Math.random() * 100) + 1; // ランダムなHP
        this.mp = (int)(Math.random() * 50) + 1;  // ランダムなMP
        this.equipment = new Equipment(); // デフォルト装備
    }

    // GetterとSetter
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public int attack() {
        return (int)(Math.random() * 10) + 1 + this.getEquipment().getAttackBoost();
    }
}

class Monster implements Character {
    private String type;
    private int hp;
    private int attack;

    public Monster() {
        this.type = "ゴブリン";
        this.hp = (int)(Math.random() * 50) + 1;
        this.attack = (int)(Math.random() * 10) + 1;
    }

    // GetterとSetter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public int attack() {
        return (int)(Math.random() * 10) + 1;
    }
}

// 具体的なモンスタークラス（例: ゴブリン）
class Goblin extends Monster {
    public Goblin() {
        super();
        this.setType("ゴブリン");
    }
}

class Equipment {
    private String name;
    private int attackBoost;

    public Equipment() {
        this.name = "木の剣";
        this.attackBoost = 5;
    }

    // GetterとSetter
    public String getName() {
        return name;
    }

    public int getAttackBoost() {
        return attackBoost;
    }
}

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

    private boolean fight() {
        int playerAttack = random.nextInt(10) + 1 + player.getEquipment().getAttackBoost();
        int monsterAttack = monster.getAttack();

        return playerAttack > monsterAttack; // プレイヤーの攻撃力が高ければ勝利
    }

    public void start() {
        System.out.println(player.getName() + "が冒険を始める！");

        while (winStreak < MAX_WINS) {
            System.out.println(monster.getType() + "が現れた！戦闘開始！");
            boolean won = fight();

            if (won) {
                winStreak++;
                System.out.println("勝利！現在の連勝数: " + winStreak);
                // 魔物の強化
                monster = new Monster();
            } else {
                System.out.println("敗北...");
                // 一定のアイテムを引き継ぐ処理
                // ここでは例としてHPを引き継ぐ
                int retainedHp = player.getHp();
                player = new Player(player.getName());
                player.setHp(retainedHp);
                winStreak = 0;
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
