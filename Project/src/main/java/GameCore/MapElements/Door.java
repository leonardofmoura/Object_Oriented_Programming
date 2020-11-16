package GameCore.MapElements;

import GameCore.Drawable;
import GameCore.Entity;

public class Door extends Entity implements Drawable,Interactable {
    private boolean open;

    public Door(int x, int y) {
        super(x, y);
        this.open = false;
    }

    @Override
    public boolean canMoveThrough() {
        return open;
    }

    public boolean isOpen() {
        return open;
    }

    public void toogleOpen() {
        this.open = !this.open;
    }

    @Override
    public boolean toggle() {
        toogleOpen();
        return open;
    }
}
