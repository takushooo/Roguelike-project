// monsters/Goblin.java
package game.monsters;

public class Goblin extends Monster {
    public Goblin() {
        super("ゴブリン", (int)(Math.random() * 50) + 50, (int)(Math.random() * 10) + 5);
    }
}
