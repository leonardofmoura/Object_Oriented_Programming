import java.util.ArrayList;
import java.util.List;

public class SmartStrategy  implements OrderingStrategy{
    List<StringRecipe> wantedDrinks = new ArrayList<>();

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()) {
            bar.order(recipe);
        }
        else {
            wantedDrinks.add(recipe);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        bar.order(wantedDrinks.get(0));
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
