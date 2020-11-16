public class AreaStringOutputter {
    private SumProvider provider;

    public AreaStringOutputter(SumProvider provider) {
        this.provider = provider;
    }

    public SumProvider getProvider() {
        return provider;
    }

    public void setProvider(SumProvider provider) {
        this.provider = provider;
    }

    public String output() {
        return "Sum of Areas: " + provider.sum();
    }
}
