public class StringReplacer implements StringTransformer {
    private StringDrink sd;
    private char oldChar;
    private char newChar;

    public StringReplacer(StringDrink sd, char oldChar, char newChar) {
        this.sd = sd;
        this.oldChar = oldChar;
        this.newChar = newChar;
    }

    @Override
    public void execute() {
        String text = sd.getText();

        sd.setText(text.replace(oldChar,newChar));
    }
}
