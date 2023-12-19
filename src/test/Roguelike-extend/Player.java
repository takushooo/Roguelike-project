import java.util.Random;

public class Player implements Character{
    private String name;
    private int hp;
    private int maxHp;
    private int mp;
    private Equipment equipment;

    // 最大HPが指定されない場合に使用するコンストラクタ
    public Player(String name) {
        this(name, (int)(Math.random() * 100) + 1, new Random().nextInt(50) + 1, new Random().nextInt(50) + 1);
    }

    // 最大HP、攻撃力、防御力を指定してプレイヤーを作成するコンストラクタ
    public Player(String name, int maxHp, int attackPower, int defensePower) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.mp = (int)(Math.random() * 50) + 1;
        this.equipment = new Equipment();
        this.equipment.setAttackBoost(attackPower);
        this.equipment.setDefenseBoost(defensePower);
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

    public String getHpStatus() {
        return hp + "/" + maxHp; // HPの状態を文字列で返す
    }

    // getMaxHp メソッドを追加します
    public int getMaxHp() {
        return maxHp;
    }

    // 攻撃力を取得するメソッド
    public int getAttackPower() {
        return this.equipment.getAttackBoost();
    }

    // 防御力を取得するメソッド
    public int getDefensePower() {
        return this.equipment.getDefenseBoost();
    }

    // 攻撃力を設定するメソッド
    public void setAttackPower(int attackPower) {
        this.equipment.setAttackBoost(attackPower);
    }

    // 防御力を設定するメソッド
    public void setDefensePower(int defensePower) {
        this.equipment.setDefenseBoost(defensePower);
    }

    // 最大HPをランダムに再設定するメソッド
    public void randomizeMaxHp() {
        this.maxHp = new Random().nextInt(100) + 1;
        this.hp = this.maxHp;
    }

    // 攻撃力をランダムに再設定するメソッド
    public void randomizeAttackPower() {
        this.equipment.setAttackBoost(new Random().nextInt(50) + 1);
    }

    // 防御力をランダムに再設定するメソッド
    public void randomizeDefensePower() {
        this.equipment.setDefenseBoost(new Random().nextInt(50) + 1);
    }

    @Override
    public int attack() {
        return getAttackPower(); // 攻撃力を返す
    }
}


