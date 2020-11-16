package GameCore.Item;

import GameCore.Stats.Buff;

public class WeaponRanged extends Weapon   {
    private int ammo;

    WeaponRanged(String name, String description, int max_durability, Buff buff, int vol, boolean two_hand, int base_dmg, int accuracy, int ammo, double range) throws InvalidDurability {
        super(name, description, max_durability, buff, vol, two_hand, base_dmg, accuracy,range);
        this.ammo = (ammo > 0 ) ? ammo : 1;
    }

    @Override
    public int hit(double distance) {
        ammo--;
        return super.hit(distance);
    }

    public int getAmmo() {
        return ammo;
    }


}
