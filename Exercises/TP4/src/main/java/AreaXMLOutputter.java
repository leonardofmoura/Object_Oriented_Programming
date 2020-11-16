public class AreaXMLOutputter {
    private SumProvider provider;


    public AreaXMLOutputter(SumProvider provider) {
        this.provider = provider;
    }

    public SumProvider getProvider() {
        return provider;
    }

    public void setProvider(SumProvider provider) {
        this.provider = provider;
    }

    public String output() {
        return "<area>" + provider.sum() + "</area>";
    }
}
