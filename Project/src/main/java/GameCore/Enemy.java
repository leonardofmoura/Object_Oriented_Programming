package GameCore;

public abstract class Enemy extends LiveEntity implements Drawable {
    private int dmg;
    private String name;

    public Enemy(int x,int y, int speed, int dmg, String name) {
        super(x, y,speed);
        this.dmg = dmg;
    }

    public int attack() {
        return dmg;
    }
}
