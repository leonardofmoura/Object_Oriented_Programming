package UserInterface;

import GameCore.Position;
import UserInterface.EntityDrawer;
import UserInterface.Screen;

import java.util.ArrayList;

public class DrawerComposite extends EntityDrawer {
    private ArrayList<EntityDrawer> drawers = new ArrayList<>();

    DrawerComposite() {

    }

    @Override
    public void draw(Screen screen, Position playerPosition) {
        for (EntityDrawer d: drawers
             ) {
            d.draw(screen,playerPosition);
        }
    }

    public void add(EntityDrawer drawer) {
        drawers.add(drawer);
    }
}
