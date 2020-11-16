package GameCore.Item.ItemFactory;

import GameCore.Item.NullWeapon;
import GameCore.Item.Weapon;
import GameCore.Item.WeaponMelee;
import java.lang.String;



import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class SwordFactory extends WeaponFactory {

    public SwordFactory() {
        super(2);
    }

    public Weapon make(int i){
        switch(i % this.NO_WEAPONS_MAX){
            case 0:
                return makeSword();
            case 1 :
                return makeTHSword();
        }
        return new NullWeapon();
    }

    public WeaponMelee makeSword() {
        List<String> sword_names = Arrays.asList("Baguette","Pencil","Butter Knife","Paper Roll");
        List<String> sword_namesDesc = Arrays.asList("A piece of french bread that has been hardened for almost 200 years.", "A simple sword in the shape of a pencil forged by the Legendary Blacksmith know as Dona Bea.","A simple piece of rusted cutlery.", "A roll of paper");
        Random r = new Random();
        int i = r.nextInt(sword_names.size());
        return new Sword(sword_names.get(i),sword_namesDesc.get(i),i);
    }

    public WeaponMelee makeTHSword(){
        List<String> sword_names = Arrays.asList("Stick","Basketball 40 bat","Wooden Spoon","Solar Powered Chainsaw");
        List<String> sword_namesDesc = Arrays.asList("A branch that fell 40 years ago when a meteor hit a bee, mutating it and giving it super strength. The bee went into a frenzy and broke 12 sticks from a tree nearby. This is one of them.","A glitch has appeared in the Matrix. Its first 40 victims being 40 40 year old men that were beaten 40 times to death in 40 different places.", "To some a giant wooden spoon, to others a magical and important piece of tradition and culture. It has engineering colored silk strips around the handle near the head. It has a strange but recognizable symbol in the middle of the head","The name says it all: a solar powered chainsaw. It never runs out of energy. That's the power of the sun.");
        Random r = new Random();
        int i = r.nextInt(sword_names.size());
        return new SwordTH(sword_names.get(i),sword_namesDesc.get(i),i);
    }


}
