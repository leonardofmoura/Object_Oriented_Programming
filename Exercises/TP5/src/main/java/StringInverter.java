public class StringInverter implements StringTransformer{
    private StringDrink str;

    StringInverter(StringDrink sd) {
        this.str = sd;
    }

    @Override
    public void execute() {
        String text = str.getText();
        int start = 0;
        int end = text.length() - 1;
        char[] temp = text.toCharArray();
        char sub;

        while (start < end) {
            sub = temp[start];

            temp[start] = temp[end];
            temp[end] = sub;

            start++;
            end--;
        }

        String inverted = new String(temp);
        str.setText(inverted);
    }
}
