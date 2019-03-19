public class Square implements AreaShape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side,2);
    }

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
