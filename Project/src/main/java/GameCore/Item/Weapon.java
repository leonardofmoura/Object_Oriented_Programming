package GameCore.Item;

import GameCore.Position;
import GameCore.Stats.Buff;
import GameCore.Stats.EStat;

import java.util.Random;

public abstract class  Weapon extends Item{
    protected final boolean TWO_HANDED;
    protected final int BASE_DMG;
    protected final int ACCURACY;
    protected final double RANGE;

    Weapon(String name, String description, int max_durability, Buff buff, int vol, boolean two_hand, int base_dmg, int accuracy,double distance){
        super(name,description,max_durability,buff,vol);
        BASE_DMG = (checkDmg(base_dmg)) ? base_dmg : 1;
        ACCURACY = (checkAcc(accuracy))? accuracy : 50;
        TWO_HANDED = two_hand;
        RANGE = distance;
    }


    private boolean checkDmg(int dmg){
        return dmg > 0;
    }

    private boolean checkAcc(int acc){
        return acc > 0 &&  acc <= 100;
    }

    public boolean isTwoHanded() {
        return TWO_HANDED;
    }

    public int getAccuracy() {
        return ACCURACY;
    }

    public int getBaseDmg() {
        return BASE_DMG;
    }

    public  int calcDmg(){
        return BASE_DMG;
    }

    int getAccuracy(EStat stats){
        return ACCURACY;
    }

    public int hit(double distance){
        if(_hit(distance)){
            return this.calcDmg();
        } else{
            return 0;
        }
    }


    private boolean _hit(double distance){
        if(!canHit(distance)){
            return false;
        }
        Random r = new Random();
        return r.nextInt(100) <= ACCURACY;
    }

    public double getRange() {
        return RANGE;
    }

    public boolean canHit(double distance){
        return distance <= this.RANGE;
    }
}
