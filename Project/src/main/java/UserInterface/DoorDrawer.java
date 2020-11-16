package UserInterface;

import GameCore.Entity;
import GameCore.Position;
import UserInterface.EntityDrawer;
import UserInterface.Screen;

public class DoorDrawer extends EntityDrawer {
    private final String doorclosed = "D";
    private final String dooropen = "O";
    private boolean open = false;

    DoorDrawer(Entity toDraw, Position centerCoords, int maxDrawCoord, boolean open) {
        super(toDraw, centerCoords,maxDrawCoord);
        this.open = open;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public void draw(Screen screen, Position playerPosition) {
        Position drawPos = super.calcDrawPos(playerPosition);


        if (drawPos != null) {
            screen.putString(drawPos.getX(),drawPos.getY(),(open) ? dooropen : doorclosed);
        }
    }
}
