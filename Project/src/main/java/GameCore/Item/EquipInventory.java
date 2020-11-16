package GameCore.Item;

import GameCore.Stats.Buff;
import GameCore.Stats.EmptyBuff;


import java.util.ArrayList;
import java.util.List;

public class EquipInventory extends Inventory {
    private List<Item> equips;
    public EquipInventory(int capacity) {
        super(capacity);
        this.equips = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            this.equips.add(new NullItem());
        }
    }

    public Buff equip(Item item, Body_Part_Equip body){
        Item itemEquiped = this.equips.get(body.val);
        if(!(itemEquiped instanceof NullItem) || item instanceof NullItem)  {
            return new EmptyBuff();
        }
        if (item instanceof Weapon){
            return _equipWeapon((Weapon)item,body);
        }
        if (item instanceof Armor){
            return _equipArmor((Armor)item,body);
        }
        return new EmptyBuff();
    }

    public Item unequip(Body_Part_Equip body){

        Item i = this.equips.get(body.val);
        if(i instanceof NullItem){
            return new NullItem();
        }
        if(i instanceof Weapon){
            Weapon weapon = (Weapon) i;
            if(weapon.isTwoHanded()){
                this.equips.set(Body_Part_Equip.LFT_HAND.val,new NullItem());
                this.equips.set(Body_Part_Equip.RGT_HAND.val,new NullItem());
            }else{
                this.equips.set(body.val,new NullItem());
            }
            return i;
        }
        this.equips.set(body.val,new NullItem());
        return i;
    }

    private Buff _equipArmor(Armor armor, Body_Part_Equip body) {
        if(_canEquipArmor(armor,body)){
            this.equips.set(body.val,armor);
            return armor.getBuff();
        }else{
            return new EmptyBuff();
        }
    }

    private boolean _canEquipArmor(Armor armor,Body_Part_Equip body) {
        if(body == Body_Part_Equip.RGT_HAND || body == Body_Part_Equip.LFT_HAND || armor.getEquipLocation() !=  body ){
            return false;
        }
        return isBodyPartFree(body);
    }

    private Buff _equipWeapon(Weapon weapon, Body_Part_Equip body){
        if(_canEquipWeapon(weapon,body)){
            if(weapon.isTwoHanded()){
                this.equips.set(Body_Part_Equip.LFT_HAND.val,weapon);
                this.equips.set(Body_Part_Equip.RGT_HAND.val,weapon);
            }else{
                this.equips.set(body.val,weapon);
            }
            return weapon.getBuff();
        }else{
            return new EmptyBuff();
        }
    }

    private boolean _canEquipWeapon(Weapon weapon, Body_Part_Equip body) {
        if(body != Body_Part_Equip.RGT_HAND &&  body !=  Body_Part_Equip.LFT_HAND){
            return false;
        }
        if(weapon.isTwoHanded()){
            return this.isBodyPartFree(Body_Part_Equip.RGT_HAND) &&  this.isBodyPartFree(Body_Part_Equip.LFT_HAND);
        } else{
            return this.isBodyPartFree(body);
        }
    }

    private boolean isBodyPartFree(Body_Part_Equip body) {
        return this.equips.get(body.val) instanceof NullItem;
    }


    public List<Item> getEquipped(){
        return this.equips;
    }

    public Item getEquiped(Body_Part_Equip body){
        return this.equips.get(body.val);
    }

    @Override
    public boolean findItem(Item item) {
        for (Item i: this.equips) {
            if(i.equals(item))
                return true;
        }

        return super.findItem(item);
    }
}
