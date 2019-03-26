import java.util.ArrayList;
import java.util.List;

public class Bar {
    private boolean happyHour;
    private List<BarObserver> observers = new ArrayList<>();

    Bar() {
        this.happyHour = false;
    }

    public boolean isHappyHour() {
        return happyHour;
    }

    public void startHappyHour() {
        this.happyHour = true;
        notifyObservers();
    }

    public void endHappyHour() {
        this.happyHour = false;
        notifyObservers();
    }

    void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (BarObserver observer : observers) {
            if (isHappyHour()) {
                observer.happyHourStarted(this);
            }
            else {
                observer.happyHourEnded(this);
            }
        }
    }
}
