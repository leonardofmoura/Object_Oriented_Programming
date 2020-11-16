public class StringCaseChanger implements StringTransformer {
    private StringDrink sd;

    public StringCaseChanger(StringDrink sd) {
        this.sd = sd;
    }

    @Override
    public void execute() {
        String text = sd.getText();
        char[] charArray = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLowerCase(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
            else {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
        }

        String changed = new String(charArray);
        sd.setText(changed);
    }
}
