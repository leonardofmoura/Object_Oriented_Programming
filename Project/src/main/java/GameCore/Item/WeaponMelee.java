package GameCore.Item;


import GameCore.Stats.Buff;



public class  WeaponMelee extends Weapon {

    public WeaponMelee(String name, String description, int max_durability, Buff buff, int vol, boolean two_hand, int base_dmg, int accuracy, double distance){
        super(name, description, max_durability, buff, vol, two_hand, base_dmg, accuracy,distance);
    }


}
