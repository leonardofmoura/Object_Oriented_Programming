package GameCore.Item.ItemFactory;

import GameCore.Item.InvalidDurability;
import GameCore.Item.WeaponMelee;
import GameCore.Stats.Buff;

public final class Sword extends WeaponMelee {

    public Sword(String name, String description, int tier){
        super(name, description, 50 +tier*15, new Buff(tier*3, tier,tier%3, tier),5+(10-tier)*5, false, tier*3 + 10, 75, 1);
    }

}
