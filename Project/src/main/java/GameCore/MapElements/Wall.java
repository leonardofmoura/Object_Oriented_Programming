package GameCore.MapElements;

import GameCore.Drawable;
import GameCore.Entity;
import GameCore.Position;

public class Wall extends Entity implements Drawable {
    public Wall(int x, int y) {
        super(x ,y);
    }

    public Position getPosition() {
        return super.getPosition();
    }
}
