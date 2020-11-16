package UserInterface;

import Game.GameMap;
import GameCore.Enemy;
import GameCore.Entity;
import GameCore.MapElements.Door;
import GameCore.MapElements.Wall;
import GameCore.Position;

import java.io.IOException;
import java.util.ArrayList;

public class MapDrawer {
    private GameMap map;
    private Screen screen;
    private Position centerCoords;
    private int maxDrawCoord;

    public MapDrawer(GameMap map, Screen screen, int maxDrawCoord) throws IOException {
        this.map = map;
        this.screen = screen;
        this.centerCoords = screen.getCenterCoords();
        this.maxDrawCoord = maxDrawCoord;
    }

    public void setCoords(Position centerCoords,int maxDrawCoord) {
        this.centerCoords = centerCoords;
        this.maxDrawCoord = maxDrawCoord;
    }

    public void drawMap() {
        //draw the player
        PlayerDrawer playerDrawer = new PlayerDrawer(map.getPlayer(),centerCoords,maxDrawCoord);


        ArrayList<Entity> entities = map.getEnteties();
        DrawerComposite drawers = new DrawerComposite();

        for (Entity i : entities
             ) {
            if (i instanceof Door) {
                drawers.add(new DoorDrawer(i,centerCoords,maxDrawCoord,((Door) i).isOpen()));
            }
            else if (i instanceof Wall) {
                drawers.add(new WallDrawer(i,centerCoords,maxDrawCoord));
            }
            else if (i instanceof Enemy) {
                drawers.add(new EnemyDrawer(i,centerCoords,maxDrawCoord));
            }
        }

        drawers.draw(screen,map.getPlayer().getPosition());

        playerDrawer.draw(screen,map.getPlayer().getPosition());
    }
}
