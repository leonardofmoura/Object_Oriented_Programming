import java.util.List;
import java.util.ListIterator;

public class StringTransformerGroup implements StringTransformer {
    private List<StringTransformer> transformers;

    public StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    @Override
    public void execute() {
        ListIterator<StringTransformer> it = transformers.listIterator();

        while (it.hasNext()) {
            it.next().execute();
        }
    }
}
