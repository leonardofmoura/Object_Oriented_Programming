package GameCore.Item;

import GameCore.Stats.EmptyBuff;

public class NullWeapon extends Weapon{
    public NullWeapon(){
        super("NullWeapon","It's a null weapon.", 1, new EmptyBuff(), 1, false, 1, 1, 0);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof NullWeapon;
    }
}
