public class House implements HasArea{
    private double totalArea;

    public House(double totalArea) {
        this.totalArea = totalArea;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    @Override
    public double getArea() {
        return totalArea;
    }
}
