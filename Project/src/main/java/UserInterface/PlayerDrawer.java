package UserInterface;

import GameCore.Entity;
import GameCore.Position;

import java.awt.*;

public class PlayerDrawer extends EntityDrawer {
    private final String playerString = "X";

    public PlayerDrawer(Entity player, Position centerPos, int maxDrawCoord) {
        super(player, centerPos,maxDrawCoord);
    }


    @Override
    public void draw(Screen screen, Position playerCoords) {
        Position pos = super.getToDraw().getPosition();

        screen.putString(super.getCenterCoords().getX(),super.getCenterCoords().getY(),playerString, Color.BLACK,Color.cyan);
    }
}
