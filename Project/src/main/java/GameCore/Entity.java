package GameCore;


public abstract class Entity {
    protected Position position;

    public Entity(int x,int y){
        this.position = new Position(x,y);
    }

    public boolean canMoveThrough(){
        return false;
    }

    public Position getPosition() {
        return this.position;
    }

}
