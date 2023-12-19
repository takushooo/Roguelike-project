// monster/Orc.java
package game.monsters;

public class Orc extends Monster {
    public Orc() {
        super("オーク", (int)(Math.random() * 100) + 100, (int)(Math.random() * 15) + 10);
    }
}