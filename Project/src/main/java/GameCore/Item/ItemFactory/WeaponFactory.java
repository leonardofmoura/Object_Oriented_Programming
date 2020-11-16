package GameCore.Item.ItemFactory;

import GameCore.Item.NullWeapon;
import GameCore.Item.Weapon;

public abstract class WeaponFactory implements ItemFactory {
    protected final int NO_WEAPONS_MAX;
    WeaponFactory(int i){
        NO_WEAPONS_MAX = i;
    }
    public Weapon make(int i){
        return new NullWeapon();
    }
}
