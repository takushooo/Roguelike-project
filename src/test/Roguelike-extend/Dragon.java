// Dragon.java
public class Dragon extends Monster {
    public Dragon() {
        super("ドラゴン", (int)(Math.random() * 200) + 200, (int)(Math.random() * 25) + 20);
    }
}