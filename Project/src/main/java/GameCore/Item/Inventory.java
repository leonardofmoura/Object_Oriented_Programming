package GameCore.Item;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.abs;

public class Inventory {
    private List<Item> inventory;


    private Volume max_capacity;
    private Volume current_capacity;



    public Inventory(int capacity){
        if(capacity > 0)
            this.max_capacity = new Volume(capacity);
        else
            this.max_capacity = new Volume(0);
        this.current_capacity = new Volume(0);
        this.inventory = new ArrayList<>();


    }

    public boolean canPutIn(Item item){
        if(item instanceof NullItem || item instanceof NullWeapon || max_capacity.getVolume() == 0){
            return false;
        }
        return item.getVol().getVolume() + current_capacity.getVolume()<= max_capacity.getVolume() ;
    }

    public boolean addItem(Item item){
        if (canPutIn(item)){
            inventory.add(item);
            this.current_capacity.increase(item.getVol().getVolume());
            return true;
        }
            return false;
    }

    public Item removeItem(Item item){
        for (Item i: this.inventory) {
            if (i.equals(item)){
                this.inventory.remove(i);
                this.current_capacity.increase(i.getVol().getVolume());
                return i;
            }
        }
        return new NullItem();
    }

    public Item removeItem(int index){
        Item i;
        try{
            i = this.inventory.get(index);
        } catch (Exception e) {
            return new NullItem();
        }

        this.inventory.remove(i);
        this.current_capacity.increase(i.getVol().getVolume());
        return i;
    }

    public boolean canMove(){
        return this.max_capacity.getVolume() > this.current_capacity.getVolume();
    }

    public void updateMaxCapacity(int capacity){

        this.max_capacity.setVolume(capacity);
    }

    public List<Item> getInventory(){
        return this.inventory;
    }


    public boolean findItem(Item item){
        for (Item i: this.inventory) {
            if(i.equals(item)){
                return true;
            }
        }
        return false;
    }

    public Volume getMax_capacity() {
        return max_capacity;
    }

    public Volume getCurrent_capacity() {
        return current_capacity;
    }

}
