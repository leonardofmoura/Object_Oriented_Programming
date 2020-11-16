package UserInterface.Swing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridLabel extends JComponent {
    private int gridWidth;
    private int gridHeight;
    private final int numDivisionsX = 200;
    private final int NumDivisionsY = 50;
    private int deltaX;
    private int deltaY;
    private ArrayList<GridString> strings = new ArrayList<>();


    public GridLabel(Dimension frameSize) {
        this.gridWidth = frameSize.width;
        this.gridHeight = frameSize.height;

        deltaX = gridWidth/numDivisionsX;
        deltaY = gridHeight/NumDivisionsY;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        for (GridString gs : strings
             ) {
            if (gs.getString().equals(" ")) {
                graphics.fillRect(gs.getX()*deltaX,gs.getY()*deltaY,deltaX,deltaY);
            }
            else {
                graphics.drawString(gs.getString(),gs.getX()*deltaX,gs.getY()*deltaY);
            }
        }
    }

    public void addString(int x, int y, String s) {
        strings.add(new GridString(x,y,s));
    }

    public int getMaxX() {
        return this.numDivisionsX;
    }

    public int getMaxY() {
        return this.NumDivisionsY;
    }

    public void clear() {
        this.strings.clear();
    }
}
