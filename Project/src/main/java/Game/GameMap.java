package Game;

import GameCore.*;
import GameCore.Enemies.EnemyFactory;
import GameCore.MapElements.Door;
import GameCore.MapElements.Interactable;
import GameCore.MapElements.Wall;

import java.util.ArrayList;
import java.util.Random;

/*
TODO
    this class is still work in progress
 */


// this a fixed game map with an array of entities
public class GameMap {
    private ArrayList<Entity> entities = new ArrayList<>();
    private Player player;


    //for now this just adds a wall
    public GameMap(Player player) {

        this.player = player;
        Random rand = new Random();

        createHouse(rand.nextInt(50),rand.nextInt(50));
        createHouse(rand.nextInt(50),rand.nextInt(50));
        createHouse(rand.nextInt(50),rand.nextInt(50));
        createHorizontalWall(rand.nextInt(45),rand.nextInt(30),rand.nextInt(10));
        createVerticalWall(rand.nextInt(50),rand.nextInt(30),rand.nextInt(5));
        createEnemies(3);
    }

    public ArrayList<Entity> getEnteties() {
        return this.entities;
    }

    public Player getPlayer() {
        return player;
    }

    public Position movePlayer(Direction d) throws InvalidPosition {
        if(canMovePlayer(d))
            player.move(d);
        return player.getPosition();
    }
    
    public boolean canMovePlayer(Direction d){
        Position p = new Position(player.getPosition().getX(),player.getPosition().getY());
        
        return _canMovePlayer(p.move(d,player.getSpeed()));
    }
    
    private boolean _canMovePlayer(Position p){
        for (Entity i: this.entities) {
            if(i.getPosition().equals(p)){
                return i.canMoveThrough();
            }
        }

        return true;
    }
    
    //(x,y) are the top left coordinates
    private void createHouse(int x , int y) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i == 0 || i == 6 || j == 0 || j == 6) && !(i == 6 && j == 3)) {
                    entities.add(new Wall(i+x,j+y));
                }
            }
        }

        entities.add(new Door(6+x,3+y));
    }

    private void createVerticalWall(int x,int y, int width) {
        for (int i = 0; i < width; i++) {
            entities.add(new Wall(x,y+i));
        }
    }

    private void createHorizontalWall(int x, int y, int width) {
        for (int i = 0; i < width; i++) {
            entities.add(new Wall(x+i,y));
        }
    }

    private void createEnemies(int num) {
        EnemyFactory fac = new EnemyFactory();
        Random rand = new Random();

        for (int i = 0; i < num; i++) {
            ArrayList<Enemy> temEn = new ArrayList<>();
            temEn.add(fac.makeGoblin());
            temEn.add(fac.makeNinja());
            temEn.add(fac.makeOrc());
            temEn.add(fac.makeThug());

            entities.add(temEn.get(rand.nextInt(4)));
        }
    }

    public void passTurn() {
        this.player.passTurn();
    }

    public void interact(Position move) {
        for(Entity i : this.entities){
            if(i instanceof Interactable &&  i.getPosition().equals(move)){
                ((Interactable)i).toggle();
            }
        }
    }
}
