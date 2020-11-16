package GameCore;

import GameCore.Item.Body_Part_Equip;
import GameCore.Item.EquipInventory;
import GameCore.Item.Food;
import GameCore.Item.Item;
import GameCore.Stats.Buff;
import GameCore.Stats.EStat;
import GameCore.Stats.EmptyBuff;
import GameCore.Stats.SurvStats;

import java.util.List;

public final class Player extends LiveEntity implements Drawable {
    private EquipInventory inv;

    private SurvStats survStats;

    public Player(int x, int y) {
        super(x, y);
        this.stats = new EStat();
        this.inv = new EquipInventory(stats.getCarryW());
        this.survStats = new SurvStats();
    }

    public Player(int x, int y, EStat stats){
        this(x,y);
        this.stats = stats;
        this.inv = new EquipInventory(stats.getCarryW());
    }

    public boolean canMove(){
        return this.inv.canMove();
    }

    public Item dropItem(Item item){
        return inv.removeItem(item);
    }

    public void pickItem(Item item){
        this.inv.addItem(item);
    }

    public boolean equipItem(Item item, Body_Part_Equip body){
        Buff buff = this.inv.equip(item,body);
        if (buff instanceof EmptyBuff){
            return false;
        }
        this.stats.addBuff(buff);
        return true;
    }

    public List<Item> getInventory(){
        return this.inv.getInventory();
    }

    public List<Item> getEquiped(){
        return this.inv.getEquipped();
    }


    public void endTurn(){

        if (this.survStats.getThirst() == 0){
            this.gethit(this.getHp());
            return;
        }
        if(this.survStats.getHunger() == 0){
            this.gethit(this.survStats.getHunger_pen());
        }

        this.heal(this.calcHeal());


    }

    public Player(int x, int y, int speed) {
        super(x, y, speed);
    }

    private int calcHeal() {
        int tmp = this.survStats.getHunger();
        if (this.survStats.getThirst() >= 50){
            if (tmp >= 65 && tmp <= 70) {
                return tmp - 65;
            } else if (tmp > 70) {
                return 5;
            }
        }
        return 0;

    }

    private boolean consume(Food food){
        if (this.inv.findItem(food)){
            this.survStats.combine(food.comsume());
            if(food.getUses() < 0){
                this.inv.removeItem(food);
            }
            return true;
        }
        return false;
    }

    public int getHunger() {
        return survStats.getHunger();
    }

    public int getThirst() {
        return survStats.getThirst();
    }



    public void passTurn() {
        this.survStats.tick();
        if(this.getThirst() == 0){
            this.gethit(this.getHp());
        }
        this.gethit(this.survStats.getHunger_pen() - 1);

    }

    public void unequip(Body_Part_Equip body) {
        Item i = this.inv.unequip(body);
        if(!i.isNull()){
            this.stats.removeBuff(i.getBuff());
        }

    }
}
