package GameCore.Item;

public class Durability  {
    private int duraMax;
    private int currentDurability;
    private boolean usable;
    Durability(int duraMax){
        if (validDurab(duraMax)) this.duraMax = duraMax;
        else this.duraMax = 0;
        this.currentDurability = duraMax;
        this.usable = true;
    }
    Durability(int duraMax,int currentDurability) throws InvalidDurability{
        if(!validDurab(duraMax) || !validDurab(currentDurability)) throw new InvalidDurability();
        this.duraMax = duraMax;
        this.currentDurability = currentDurability;
        this.usable = true;
    }
    Durability(int duraMax, int currentDurability,boolean usable) throws InvalidDurability{
        this(duraMax,currentDurability);
        this.usable = usable;
    }
    private static boolean validDurab(int durability){
        return durability >= 0;
    }
    public int repair(int dura) throws InvalidDurability{
        if(!validDurab(dura)) throw new InvalidDurability();

        currentDurability += dura;
        return currentDurability;
    }
    public int upgrade(int dura) throws InvalidDurability{
        if(!validDurab(dura)) throw new InvalidDurability();

        duraMax += dura;
        return duraMax;
    }
    public int damage(int dura) throws InvalidDurability{
        if (!validDurab(dura)) throw new InvalidDurability();
        currentDurability -= (dura >= currentDurability) ? currentDurability : dura;
        return currentDurability;
    }
    public int permadamage(int dura) throws  InvalidDurability{
        if(!validDurab(dura)) throw new InvalidDurability();
        duraMax -= (dura >= duraMax) ? duraMax : dura;
        return duraMax;
    }
    public boolean usable(){
        return (currentDurability!=  0) &&  (duraMax!=  0) &&  this.usable;
    }

    public int getDuraMax() {
        return duraMax;
    }

    public int getCurrentDurability() {
        return currentDurability;
    }
}
