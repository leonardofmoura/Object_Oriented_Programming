package GameCore.Stats;

import javax.management.BadAttributeValueExpException;
import java.util.Objects;

public class Buff {
    private int Str,Dex,Int,Per;
    private int no_turns; // -1 is a permanent buff, 0 means it is no longer applicable.
    private final static int BASE_HP = 84;

    public Buff(int str, int dex, int intl, int per){
        this.Str = str;
        this.Dex = dex;
        this.Int = intl;
        this.Per = per;
        this.no_turns = -1;
    }

    Buff(int str, int dex, int intl, int per, int no_turns){
        this(str,dex,intl,per);
        this.no_turns = (no_turns >= -1) ? no_turns : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buff buff = (Buff) o;
        return getStr() == buff.getStr() &&
                getDex() == buff.getDex() &&
                getInt() == buff.getInt() &&
                getPer() == buff.getPer();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStr(), getDex(), getInt(), getPer());
    }

    Buff(){
        Str = 0;
        Dex = 0;
        Int = 0;
        Per = 0;
    }

    public int getStr() {
        return Str;
    }

    public int getBonusHp(){
        if(Str < 0){
            return 0;
        }
        return (Str) * 3;
    }

    public void setStr(int str) {
        Str = str;
    }

    public int getDex() {
        return Dex;
    }

    public void setDex(int dex) {
        Dex = dex;
    }

    public int getInt() {
        return Int;
    }

    public void setInt(int anInt) {
        Int = anInt;
    }

    public int getPer() {
        return Per;
    }

    public void setPer(int per) {
        Per = per;
    }

    public int getNo_turns() {
        return no_turns;
    }

    public void pass_turns(int i){
        if (this.no_turns <= 0){
            return;
        }
        this.no_turns -= (i> 0) ? i : 1;
    }
}
