package UserInterface;

import GameCore.Drawable;
import GameCore.Entity;
import GameCore.InvalidPosition;
import GameCore.Position;
import UserInterface.Screen;

//Responsable for drawing a DRAWABLE object on the screen
public abstract class EntityDrawer {
    private Entity toDraw;
    private Position centerCoords;
    private int maxDrawCoord;

    EntityDrawer()  {

    }

    EntityDrawer(Entity toDraw, Position centerCoords, int maxDrawCoord) {
        this.toDraw = toDraw;
        this.centerCoords = centerCoords;
        this.maxDrawCoord = maxDrawCoord;
    }

    protected Entity getToDraw() {
        return this.toDraw;
    }

    protected Position getCenterCoords() {
        return centerCoords;
    }

    protected Position calcDrawPos(Position playerPosition) {
        Position pos = toDraw.getPosition();

        int drawX = pos.getX() - playerPosition.getX() + centerCoords.getX();
        int drawY = pos.getY() - playerPosition.getY() + centerCoords.getY();

        if (drawX < maxDrawCoord) {
            return new Position(drawX,drawY);
        }
        else {
            return null;
        }
    }

    public abstract void draw(Screen screen, Position playerPosition);
}
