package GameCore.Item;

import GameCore.Item.ItemFactory.Sword;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void canPutIn() {
        Inventory test = new Inventory(0);
        Item i = new Sword("teste","this is a test",1);

        assertFalse(test.canPutIn(i));
        assertFalse(test.canPutIn(new NullItem()));
        assertFalse(test.canPutIn(new NullWeapon()));

        Inventory test1 = new Inventory(i.getVol().getVolume());

        assertTrue(test1.addItem(i));
        assertEquals(1, test1.getInventory().size());
        assertFalse(test1.canPutIn(i));
    }

    @Test
    public void addItem() {
        Item i = new Sword("teste","this is a test",1);
        Inventory test1 = new Inventory(i.getVol().getVolume()*4);

        assertTrue(test1.addItem(i));
        assertEquals(test1.getInventory().get(0), i);
    }

    @Test
    public void removeItem() {
        Item i = new Sword("teste","this is a test",1);
        Inventory test1 = new Inventory(i.getVol().getVolume()*4);

        assertTrue(test1.addItem(i));
        assertEquals(test1.getInventory().get(0), i);
        assertEquals(test1.removeItem(i),i);
        assertEquals(0,test1.getInventory().size());
        assertEquals(test1.removeItem(i),new NullItem());

        assertTrue(test1.addItem(i));
        assertEquals(test1.getInventory().get(0), i);
        assertEquals(test1.removeItem(0),i);
        assertEquals(0,test1.getInventory().size());
        assertEquals(test1.removeItem(i),new NullItem());
    }


    @Test
    public void updateMaxCapacity() {
        Item i = new Sword("teste","this is a test",1);
        Inventory test1 = new Inventory(i.getVol().getVolume()*4);

        assertEquals(i.getVol().getVolume() * 4,test1.getMax_capacity().getVolume());
        assertTrue(test1.canPutIn(i));
        test1.updateMaxCapacity(0);
        assertEquals(0,test1.getMax_capacity().getVolume());
        assertFalse(test1.canPutIn(i));

    }

    @Test
    public void getInventory() {
        Item i = new Sword("teste","this is a test",1);
        Inventory test1 = new Inventory(i.getVol().getVolume()*4);
        List<Item> items =  new ArrayList<>();

        assertTrue(test1.addItem(i));
        items.add(i);
        assertEquals(test1.getInventory(),items);
    }

    @Test
    public void findItem() {
        Item i = new Sword("teste","this is a test",1);
        Inventory test1 = new Inventory(10000);

        for (int j = 0; j < 4; j++) {
            Item tmp = new Sword("testenot", "not what i'm looking for",0);
            test1.addItem(tmp);
        }

        assertFalse(test1.findItem(i));
        test1.addItem(i);

        assertTrue(test1.findItem(i));
    }
}