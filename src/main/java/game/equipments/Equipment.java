// equipments/Equipment.java

package game.equipments;

import java.util.Random;

public class Equipment {
    private String name;
    private int attackBoost;
    private int defenseBoost;
    private static final Random random = new Random();

    public Equipment() {
        this.name = "基本装備";
        this.attackBoost = (int)(Math.random() * 100) + 1;
        this.defenseBoost = (int)(Math.random() * 100) + 1;
    }


    // GetterとSetterを追加
    // 攻撃力増加量を取得するメソッド
    public int getAttackBoost() {
        return this.attackBoost;
    }

    // 防御力増加量を取得するメソッド
    public int getDefenseBoost() {
        return this.defenseBoost;
    }

    // 攻撃力増加量を設定するメソッド
    public void setAttackBoost(int attackBoost) {
        this.attackBoost = attackBoost;
    }

    // 防御力増加量を設定するメソッド
    public void setDefenseBoost(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }
}
