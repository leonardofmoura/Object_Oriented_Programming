import java.util.List;
import java.util.ListIterator;

public class StringRecipe {
    private List<StringTransformer> transformers;

    public StringRecipe(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    void mix() {
        ListIterator<StringTransformer> it = transformers.listIterator();

        while (it.hasNext()) {
            it.next().execute();
        }
    }
}
