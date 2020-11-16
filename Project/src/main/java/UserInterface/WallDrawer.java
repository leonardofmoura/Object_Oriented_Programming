package UserInterface;

import GameCore.Entity;
import GameCore.Position;

public class WallDrawer extends EntityDrawer {
    private final String wallString = "W";

    WallDrawer(Entity toDraw, Position centerCoords, int maxDrawCoord) {
        super(toDraw,centerCoords,maxDrawCoord);
    }

    @Override
    public void draw(Screen screen, Position playerPosition) {
        Position drawPos = super.calcDrawPos(playerPosition);

        if (drawPos != null) {
            screen.putString(drawPos.getX(),drawPos.getY(),wallString);
        }
    }
}
