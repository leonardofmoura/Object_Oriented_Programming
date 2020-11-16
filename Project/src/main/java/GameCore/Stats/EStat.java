package GameCore.Stats;

import GameCore.Item.Inventory;

import java.util.ArrayList;

public class  EStat {
    private Stat Str, Dex, Int, Per;
    private final Stat STR,DEX,INT,PER;
    private int hp;
    //Strength dependent stats
    private final static int BASE_HP = 84;
    private final static int BASE_CARRYW = 45;
    private final static int BASE_MELEEDMG = 4;
    //Dexterity dependent stats
    private final static int BASE_MELEETOHIT = 84;
    private final static int BASE_THROWINGBONUS = 0;
    private final static int BASE_RANGEDPEN = -60;
    //Intelligence dependent stats
    private final static int BASE_READINGTIME = 100;
    private final static double BASE_SKILLRUST = 50;
    private ArrayList<Buff> buffs;


    public EStat() {
        STR = new Stat(8);
        DEX = new Stat(8);
        INT = new Stat(8);
        PER = new Stat(8);
        resetstats();
        buffs = new ArrayList<>();
        this.hp = this.getMaxHP();
    }

    public EStat(int str, int dex, int intl, int per) {
        STR = new Stat(str);
        DEX = new Stat(dex);
        INT = new Stat(intl);
        PER = new Stat(per);
        resetstats();
        buffs = new ArrayList<>();
        this.hp = this.getMaxHP();
    }

    private int everyTwo(int v) {
        return ((v % 2 == 0) ? v : v - 1) / 2;
    }


    private Stat checkStat(int stat, int newstat) {//TODO  make test
        return new Stat((stat >= 4 && stat <= 25) ? newstat : stat);
    }

    public int getPer() {
        return Per.getValue();
    }

    public void setPer(int per) {
        Per = this.checkStat(this.Per.getValue(), per);
    }

    public int getInt() {
        return Int.getValue();
    }

    public void setInt(int anInt) {
        Int = this.checkStat(this.Int.getValue(), anInt);
    }

    public int getDex() {
        return Dex.getValue();
    }

    public void setDex(int dex) {
        Dex = this.checkStat(this.Dex.getValue(), dex);
    }

    public int getStr() {
        return Str.getValue();
    }

    public void setStr(int str) {
        Str = this.checkStat(this.Str.getValue(), str);
    }

    public int getMaxHP() {
        return BASE_HP + (Str.getValue() - 8) * 3;
    }

    public int getHp() {
        return hp;
    }

    public int getCarryW() {
        return BASE_CARRYW + (Str.getValue() - 8) * 4;
    }

    public int getMeleeDMG() {
        return BASE_MELEEDMG + everyTwo((Str.getValue() - 8)) * 4;
    } //TODO  make test

    public int getMeleetohit() {
        return BASE_MELEETOHIT + everyTwo(Dex.getValue() - 8);
    }//TODO  make test

    public int getThrowbonus() {//TODO  make test
        int tmp = Dex.getValue() - 8;
        return BASE_THROWINGBONUS + ((tmp > 9) ? tmp - 9 : 0);
    }

    public int getReadtime() {//TODO  make test
        return BASE_READINGTIME - Int.getValue() - 8 * 5;
    }

    public double getSkillrus() {//TODO  make test
        return BASE_SKILLRUST - Int.getValue() - 8 * 3.5;
    }

    public int getRangedpen() {//TODO  make test
        int tmp = BASE_RANGEDPEN + 15 * (Dex.getValue() - 8 + Per.getValue() - 8);
        return (tmp > 0) ? 0 : tmp;
    }

    private void resetstats(){
        Str = STR;
        Dex = DEX;
        Int = INT;
        Per = PER;
    }

    public ArrayList<Buff> getBuffs() { //TODO  make test
        return buffs;
    }

    public void addBuff(Buff buff) { //TODO  make test
        this.buffs.add(buff);
        this.updateStatsbuff(buff);
    }

    public void removeBuff(Buff buff) { //TODO  make test
        this.Str.clear_buffs();
        this.Dex.clear_buffs();
        this.Int.clear_buffs();
        this.Per.clear_buffs();
        this.buffs.remove(buff);
        if(this.hp >= this.getMaxHP())
            this.hp -=  buff.getBonusHp();
        resetstats();
        for (Buff b : this.buffs) {
            updateStatsbuff(b);
        }

    }

    public int getDamaged(int dmg){
        this.hp = (hp >= dmg) ? hp-dmg : 0;
        return this.hp;
    }


    private void updateStatsbuff(Buff buff) { //TODO  make test
        if (buff.getStr() != 0) {
            this.Str.add_buff(buff.getStr());
            this.hp += buff.getBonusHp();
        }
        if (buff.getDex() != 0) {
            this.Dex.add_buff(buff.getDex());
        }
        if (buff.getInt() != 0) {
            this.Int.add_buff(buff.getInt());
        }
        if (buff.getPer() != 0) {
            this.Per.add_buff(buff.getPer());
        }
    }

    public void heal(int health) {
        this.hp += (health > 0) ? health : 0;
    }
}
