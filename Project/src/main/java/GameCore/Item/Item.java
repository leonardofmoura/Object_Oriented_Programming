package GameCore.Item;
import GameCore.Stats.Buff;

import java.util.Objects;
import java.util.Random;

public abstract class Item {
    protected String name;
    protected String description;
    protected Durability dura;
    protected Buff buff;
    protected Volume vol;

    protected Item(){

    }

    Item(String name, String description, int max_durability, Buff buff,int vol){
        this.name = name;
        this.description = description;
        this.dura = new Durability(max_durability);
        this.buff = buff;
        this.vol = new Volume(vol);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getName().equals(item.getName()) &&
                getDura().equals(item.getDura()) &&
                getBuff().equals(item.getBuff()) &&
                getVol().equals(item.getVol());
    }

    @Override
    public int hashCode() {
        Random r = new Random();
        return Objects.hash(getName(), getDura(), getBuff(), getVol());
    }

    public void setDura(Durability dura) {
        this.dura = dura;
    }

    public Buff getBuff() {
        return buff;
    }

    public Volume getVol() {
        return vol;
    }

    public void setVol(Volume vol) {
        this.vol = vol;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Durability getDura() {
        return dura;
    }

    public int upgrade(int up) throws InvalidDurability{
        return this.dura.upgrade(up);
    }

    public int damage(int dmg) throws InvalidDurability{
        return this.dura.damage(dmg);
    }

    public int permdamage(int dmg) throws InvalidDurability{
        return this.dura.permadamage(dmg);
    }

    public boolean usable(){
        return this.dura.usable();
    }

    public int getDuraMax() {
        return this.dura.getDuraMax();
    }

    public int getCurrentDurability() {
        return this.dura.getCurrentDurability();
    }

    public void setBuff(Buff buff) {
        this.buff = buff;
    }

    public boolean isNull() {
        return false;
    }
}
