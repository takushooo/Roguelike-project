public class Monster implements Character{
    private String type;
    private int hp;
    private int attack;

    
    // 引数なしのコンストラクタ
    public Monster() {
        this.type = "ゴブリン";
        this.hp = (int)(Math.random() * 50) + 1;
        this.attack = (int)(Math.random() * 10) + 1;
    }

    // 引数ありのコンストラクタ
    public Monster(String type, int hp, int attack) {
        this.type = type;
        this.hp = hp;
        this.attack = attack;
    }

    // GetterとSetter
    public String getType() {
        return type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public int attack() {
        return getAttack(); // モンスターの攻撃力を返す
    }
}
