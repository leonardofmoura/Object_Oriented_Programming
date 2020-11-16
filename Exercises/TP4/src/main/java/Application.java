import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(2);
        Square square = new Square(10);
        Ellipse ellipse = new Ellipse(2,3);
        Rectangle rectangle = new Rectangle(10,5);
        Triangle triangle = new Triangle(10,2);
        House house = new House(100);

        aggregator.addShape(circle1);
        aggregator.addShape(circle2);
        aggregator.addShape(square);
        aggregator.addShape(ellipse);
        aggregator.addShape(triangle);
        aggregator.addShape(house);
        aggregator.addShape(rectangle);

        AreaStringOutputter strOut = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOut = new AreaXMLOutputter(aggregator);

        System.out.println(strOut.output());
        System.out.println(xmlOut.output());

        List<House> houses = new ArrayList<>();
        houses.add(new House(50));
        houses.add(new House(150));

        City city = new City(houses);

        AreaStringOutputter cityStringOut = new AreaStringOutputter(city);
        AreaXMLOutputter cityXMLout = new AreaXMLOutputter(city);

        System.out.println(cityStringOut.output());
        System.out.println(cityXMLout.output());
    }
}
