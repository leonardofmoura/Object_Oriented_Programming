package GameCore;

import GameCore.Stats.EStat;

public abstract  class LiveEntity extends Entity {
    protected int speed;
    protected EStat stats;

    LiveEntity(int x, int y) {
        super(x, y);
        speed = 1;
    }

    LiveEntity(int x, int y, int speed) {
        super(x, y);
        this.speed = speed;
    }

    public Position move(Direction d) throws InvalidPosition {
        switch (d){
            case N:
                return super.getPosition().move(0, -speed);
            case NE:
                return super.getPosition().move(speed, speed);
            case E:
                return super.getPosition().move(speed,0);
            case SE:
                return super.getPosition().move(speed,-speed);
            case S:
                return super.getPosition().move(0, speed);
            case SW:
                return super.getPosition().move(-speed,-speed);
            case W:
                return super.getPosition().move(-speed,0);
            case NW:
                return super.getPosition().move(-speed, speed);
        }
        throw new InvalidPosition();
    }

    public EStat getEstats(){
        return this.stats;
    }

    public void heal(int health) {
        this.stats.heal(health);
    }

    public boolean isAlive(){
        return this.getHp() > 0;
    }

    public int gethit(int dmg){
        if (dmg < 0){
            return this.getHp();
        } else{
            return this.stats.getDamaged(dmg);
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp(){
        return this.stats.getHp();
    }

    public int attack(LiveEntity entity) {
        if (this.position.getdistance(entity.getPosition()) == 1){
            int dmg = this.stats.getMeleeDMG() + this.stats.getMeleetohit();
            entity.gethit(dmg);
            return dmg;
        }
        return 0;
    }
}
