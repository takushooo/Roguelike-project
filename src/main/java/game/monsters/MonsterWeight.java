// monsters/MonsterWeight.java
package game.monsters;

public class MonsterWeight {
    private Monster monster;
    private int weight;

    public MonsterWeight(Monster monster, int weight) {
        this.monster = monster;
        this.weight = weight;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getWeight() {
        return weight;
    }
}
