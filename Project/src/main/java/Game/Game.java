package Game;

import GameCore.Direction;
import GameCore.InvalidPosition;
import GameCore.Item.Body_Part_Equip;
import GameCore.Item.InvalidDurability;
import GameCore.Item.ItemFactory.SwordFactory;
import GameCore.Item.ItemFactory.WeaponFactory;
import GameCore.Player;
import GameCore.Position;
import GameCore.Stats.EStat;
import UserInterface.MapDrawer;
import UserInterface.Screen;


import java.io.IOException;

public class Game {
    private Screen mainScreen;
    private boolean screenClosedFlag = false;
    private GameMap gameMap;
    private MapDrawer mapDrawer; //TODO TEMPORARY
    private Player player;

    public Game(Screen mainScreen) {

        try {
            this.mainScreen = mainScreen;
            EStat playerstat = new EStat(25,8,3,2);
            this.player = new Player(3,4);
            this.gameMap = new GameMap(player);
            this.mapDrawer = new MapDrawer(gameMap,mainScreen,mainScreen.getMaxDrawCoord());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Returns true if the game is to continue; returns false to stop the game
    private boolean processKey(String key) throws InvalidPosition {
        if (key == null) {
            return true;
        }


        switch (key) {
            case "Escape": //will return false;

            case "EOF":
                return false;

            case "Up":
                gameMap.movePlayer(Direction.N);
                break;

            case "Down":
                gameMap.movePlayer(Direction.S);
                break;

            case "Left":
                gameMap.movePlayer(Direction.W);
                break;

            case "Right":
                gameMap.movePlayer(Direction.E);
                break;

            case "F1": {
                WeaponFactory wp = new SwordFactory();
                this.player.equipItem(((SwordFactory) wp).makeSword(), Body_Part_Equip.LFT_HAND);
                break;
            }
            case "F2":{
                WeaponFactory wp = new SwordFactory();
                this.player.equipItem(((SwordFactory) wp).makeTHSword(), Body_Part_Equip.LFT_HAND);
                break;
            }
            case "F3": {
                this.player.unequip(Body_Part_Equip.LFT_HAND);
                break;
            }
            case "F4": {
                try {
                    key = mainScreen.readInput();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                this.interact(key);
            }
            default:
                return true;
        }

        return true;
    }




    private void interact(String type) {
        Position p = new Position(this.player.getPosition().getX(),this.player.getPosition().getY());
        switch (type) {
            case "Left":
                this.gameMap.interact(p.move(Direction.W,1));
                break;
            case "Right":
                this.gameMap.interact(p.move(Direction.E,1));
                break;
            case "Up":
                this.gameMap.interact(p.move(Direction.N,1));
                break;
            case "Down":
                this.gameMap.interact(p.move(Direction.S,1));
                break;
            default:
                break;
        }
    }



    private void drawEntities() {
        mapDrawer.drawMap();
    }

    private void drawGame() {
        try {
            mapDrawer.setCoords(mainScreen.getCenterCoords(),mainScreen.getMaxDrawCoord());
            mainScreen.clear();
            mainScreen.drawSideLine();
            mainScreen.drawTitle();
            mainScreen.drawHealth(player.getHp(),player.getEstats().getMaxHP());
            mainScreen.drawHunger(player.getHunger()); //TODO USE REAL HUNGER
            mainScreen.drawThirst(player.getThirst());  //TODO USE REAL HUNGER
            mainScreen.drawStats(player.getEstats());
            mainScreen.drawEquips(player.getEquiped());
            drawEntities();
            mainScreen.drawPlayerCoords(player.getPosition().getX(),player.getPosition().getY());
            mainScreen.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {

        while (true) {
            String key = null;

            drawGame();

            //This pauses the game until a key is pressed
            try {
                key = mainScreen.readInput();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (!processKey(key)) {
                    break;
                }
                gameMap.passTurn();
            } catch (InvalidPosition invalidPosition) {
                invalidPosition.printStackTrace();
            }

        }
    }

    public void end() {

        if (screenClosedFlag) {
            return;
        }

        try {
            mainScreen.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
