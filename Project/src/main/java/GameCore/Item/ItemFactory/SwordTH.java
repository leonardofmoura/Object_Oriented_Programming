package GameCore.Item.ItemFactory;

import GameCore.Item.InvalidDurability;
import GameCore.Item.WeaponMelee;
import GameCore.Stats.Buff;

public class SwordTH extends WeaponMelee {
    public SwordTH(String name, String desc, int tier){
        super(name, desc, 50 +tier*15, new Buff(tier*5+2, 0,0, 3),5+tier*10, true, tier*6 + 10, 80 + tier*3, 1);
    }
}
