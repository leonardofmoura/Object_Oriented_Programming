package GameCore.Item;


public class NullItem extends Item {
    public NullItem(){
        super();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof NullItem;
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
