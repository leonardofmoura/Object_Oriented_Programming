import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Position initalPos;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;

    public Arena(int width, int height, Position initalPos) {
        this.width = width;
        this.height = height;
        this.initalPos = initalPos;
        this.hero = new Hero();
        walls = createWalls();
        coins = createCoins();
    }

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.initalPos = new Position(0,0);
        this.hero = new Hero();
        walls = createWalls();
        coins = createCoins();
    }

    public Arena() {
        this.width = 20;
        this.height = 20;
        this.initalPos = new Position(0,0);
        this.hero = new Hero();
        walls = createWalls();
        coins = createCoins();
    }

    private boolean canMoveHero(Position position) {
        if (position.getX() < initalPos.getX()+1 || position.getX() > initalPos.getX() + width-1 || position.getY() < initalPos.getY()+1 || position.getY() > initalPos.getY() + height-1) {
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

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c,0));
            walls.add(new Wall(c,height));
        }

        for (int r = 0; r <= height; r++) {
            walls.add(new Wall(0,r));
            walls.add(new Wall(width,r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            coins.add(new Coin(random.nextInt(width-3),random.nextInt(height-3)));
        }

        return coins;
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

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width+1,height+1),' ');
        hero.draw(graphics);
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        for (Coin coin : coins) {
            coin.draw(graphics);
        }
    }
}
