package UserInterface;

import GameCore.Entity;
import GameCore.Position;
import UserInterface.EntityDrawer;
import UserInterface.Screen;

public class EnemyDrawer extends EntityDrawer {
    private final String enemyString = "E";

    EnemyDrawer(Entity enemy, Position centerPos, int maxDrawCoord) {
        super(enemy,centerPos,maxDrawCoord);
    }

    @Override
    public void draw(Screen screen, Position playerPosition) {
        Position drawPos = super.calcDrawPos(playerPosition);

        if (drawPos != null) {
            screen.putString(drawPos.getX(),drawPos.getY(),enemyString);
        }
    }
}
