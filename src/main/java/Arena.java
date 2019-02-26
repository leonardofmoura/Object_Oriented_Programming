import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Position initalPos;
    private Hero hero;

    public Arena(int width, int height, Position initalPos) {
        this.width = width;
        this.height = height;
        this.initalPos = initalPos;
        this.hero = new Hero();
    }

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.initalPos = new Position(0,0);
        this.hero = new Hero();
    }

    public Arena() {
        this.width = 20;
        this.height = 20;
        this.initalPos = new Position(0,0);
        this.hero = new Hero();
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
        }
    }

    private boolean canMoveHero(Position position) {
        if (position.getX() < initalPos.getX() || position.getX() > initalPos.getX() + width || position.getY() < initalPos.getY() || position.getY() > initalPos.getY() + height) {
            return false;
        }
        else {
            return true;
        }
    }

    private void moveHero(Position position) {
        if (canMoveHero(position)) {
            hero.setPosition(position);
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw(Screen screen) {
        hero.draw(screen);
    }
}
