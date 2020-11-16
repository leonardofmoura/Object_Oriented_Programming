package UserInterface.Swing;

public class GridString {
    private int x;
    private int y;
    private String string;


    public GridString(int x, int y, String string) {
        this.x = x;
        this.y = y;
        this.string = string;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getString() {
        return string;
    }
}
