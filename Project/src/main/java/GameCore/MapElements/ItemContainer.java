package GameCore.MapElements;

import GameCore.Drawable;
import GameCore.Entity;
import GameCore.Item.Inventory;
import GameCore.Item.Item;

import java.util.List;

public abstract class ItemContainer extends Entity implements Drawable {
    private Inventory inventory;

    public ItemContainer(int x, int y, int capacity) {
        super(x, y);
        this.inventory = new Inventory(capacity);
    }

    public boolean insertItems(Item item){
        return this.inventory.addItem(item);
    }

    public List<Item> getItems(){
        return this.inventory.getInventory();
    }

    public Item retrieveItem(Item item){
        return this.inventory.removeItem(item);
    }

    public boolean findItem(Item item){
        return this.inventory.findItem(item);
    }


}
