package GameCore.Item;

import GameCore.Stats.Buff;
import GameCore.Stats.SurvStats;

public abstract class Food extends Item implements Consumable{
    private int uses;

    private SurvStats stats;
    Food(String name, String desc, Buff buff,Volume vol, int thirst, int hunger){
        this.name = name;
        this.description = desc;
        this.vol = vol;
        this.buff = buff;
        this.stats = new SurvStats(hunger,thirst);
        this.uses = 1;
    }

    Food(String name, String desc, Buff buff,Volume vol, int thirst, int hunger,int uses){
        this(name,desc,buff, vol,thirst,hunger);
        this.uses = (uses > 0) ? uses : 1;
    }

    @Override
    public SurvStats comsume() {
        return (this.uses <= 0) ? new SurvStats(0,0) : this.stats;
    }


    public int getUses() {
        return uses;
    }

}
