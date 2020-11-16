package GameCore.Item;

public enum Body_Part_Equip {
    HEAD(0),
    TORSO(1),
    LEGS(2) ,
    FEET(3) ,
    LFT_HAND(4),
    RGT_HAND(5);

    public final int val;

    Body_Part_Equip(final int value){
        this.val = value;
    }

    public static String getPart(int i){
        switch (i){
            case 0: return "Head";
            case 1: return "Torso";
            case 2: return "Legs";
            case 3: return "Feet";
            case 4: return "Left Hand";
            case 5: return "Right Hand";
            default: return "";
        }
    }
}
