package GameCore.Stats;

public class SurvStats {
    private final int MAX_HUNGER_THIRST = 100;
    private int turn;
    private int hunger,thirst,hunger_pen;


    public SurvStats(){
        this.hunger = MAX_HUNGER_THIRST;
        this.thirst = MAX_HUNGER_THIRST;
        this.hunger_pen = 1;
        this.turn = 0;
    }

    public SurvStats(int hunger, int thirst){
        this();
        this.hunger = normalize(hunger);
        this.thirst = normalize(thirst);
    }

    private int normalize(int ht){
        return (ht <= MAX_HUNGER_THIRST &&  ht>= -MAX_HUNGER_THIRST) ? ht : MAX_HUNGER_THIRST;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getHunger_pen(){
        if(this.getHunger() == 0)
            this.hunger_pen *= (this.hunger_pen < 8) ? 2 : 1;
        else
            this.hunger_pen = 1;
        return this.hunger_pen;
    }

    public SurvStats combine(SurvStats to_combine){
        this.hunger += normalize(to_combine.getHunger());
        this.thirst += normalize(to_combine.getThirst());
        return this;
    }

    public void tick() {
        this.hunger += (this.turn == 8) ? -10 : 0;
        this.thirst += (this.turn == 4) ? 1 : 0;

        this.hunger = (this.hunger >= 0) ? this.hunger : 0;
        this.hunger = (this.hunger >= 100) ? 100 : this.hunger;
        this.thirst = (this.thirst >= 0) ? this.thirst : 0;
        this.thirst = (this.thirst >= 100) ? 100 : this.thirst ;

        this.turn++;
        this.turn %= 10;
    }
}
