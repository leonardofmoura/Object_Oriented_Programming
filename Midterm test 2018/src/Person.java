import java.util.Objects;

public abstract class Person {
    private String name;
    private int age;

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Person person = (Person) o;
        return person.getAge() == this.age && person.getName() == this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
