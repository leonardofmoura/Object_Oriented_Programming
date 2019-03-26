public class Artist extends Person implements User{

    public Artist(String s, int age) {
        super(s,age);
    }

    public Artist(String s) {
        super(s);
    }

    @Override
    public String getUsername() {
        return super.getName()+super.getAge();
    }
}
