import java.util.List;

public class City implements SumProvider{
    private List<House> houses;

    public City(List<House> houses) {
        this.houses = houses;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    @Override
    public double sum() {
        double sum = 0;

        for (House house : houses) {
            sum += house.getArea();
        }

        return sum;
    }
}
