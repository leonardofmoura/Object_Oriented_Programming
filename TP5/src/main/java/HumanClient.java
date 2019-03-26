public class HumanClient implements Client {
    private OrderingStrategy strategy;

    HumanClient(OrderingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        strategy.wants(recipe,bar);
    }

    @Override
    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted((StringBar) bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {

    }
}
