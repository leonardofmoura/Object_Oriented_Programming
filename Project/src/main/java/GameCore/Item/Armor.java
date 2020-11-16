package GameCore.Item;

import GameCore.Stats.Buff;

public class Armor extends Item {
    private final Body_Part_Equip equipLocation;

    Armor(String name, String description, int max_durability, Buff buff, int vol, Body_Part_Equip equipLocation) throws InvalidDurability {
        super(name, description, max_durability, buff, vol);
        this.equipLocation = equipLocation;
    }

    public Body_Part_Equip getEquipLocation() {
        return equipLocation;
    }

}
