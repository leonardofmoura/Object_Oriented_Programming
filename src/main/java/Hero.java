import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position;

    public Hero(Position position) {
        this.position = position;
    }

    public Hero() {
        this.position = new Position(10,10);
    }

    public Position moveUp() {
        return new Position(position.getX(),position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(position.getX(),position.getY() + 1);
    }

    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }

    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }

    public void draw(Screen screen) {
        screen.setCharacter(position.getX(),position.getY(), new TextCharacter('X'));
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
