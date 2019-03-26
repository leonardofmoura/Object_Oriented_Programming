import java.util.Objects;

public class Speaker extends Person implements User{
    private int fee;

    public Speaker(String name) {
        super(name);
        this.fee = 0;
    }

    public Speaker(String name, int age) {
        super(name, age);
        this.fee = 0;
    }

    public int getFee() {
        return this.fee;
    }

    @Override
    public String toString() {
        return "Speaker "+ super.getName() +" as a fee value of "+ fee +".";
    }

    @Override
    public String getUsername() {
        return super.getName()+super.getAge();
    }
}
