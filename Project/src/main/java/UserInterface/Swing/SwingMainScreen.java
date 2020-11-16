package UserInterface.Swing;

import GameCore.Item.Item;
import GameCore.Position;
import GameCore.Stats.EStat;
import UserInterface.Screen;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;

//work in progress

public class SwingMainScreen implements Screen, KeyListener {
    private JFrame mainFrame;
    private final int tabSize = 50;
    private GridLabel grid;
    private String lastTypedKey;
    private boolean keyPressed = false;

    public SwingMainScreen() {
        mainFrame = new JFrame("Cataclysm Black Nights Onward");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(),BoxLayout.X_AXIS));

        mainFrame.setPreferredSize(new Dimension(1600,800));
        mainFrame.getContentPane().setBackground(Color.BLACK);
        mainFrame.setResizable(false);

        mainFrame.pack();
        mainFrame.setVisible(true);

        this.grid = new GridLabel(mainFrame.getSize());
        grid.setForeground(Color.white);
        mainFrame.getContentPane().add(grid);

        mainFrame.addKeyListener(this);

        /*
        try {
            drawSideLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        putString(5,5,"X");
        putString(20,20,"Y");

         */
    }

    void setLastTypedKey(String key) {
        lastTypedKey = key;
    }

    @Override
    public String readInput() throws IOException {
        System.out.println("Entrou no loop");

        while (!keyPressed) {
            //do nothing
        }

        System.out.println("saiu");
        String temp = lastTypedKey;
        lastTypedKey = "";
        return temp;
    }

    @Override
    public void clear() {
        this.grid.clear();
    }

    @Override
    public void drawSideLine() throws IOException {
        for (int i = 0; i < grid.getMaxY(); i++) {
            this.putString(grid.getMaxX() - tabSize, i, " ");
        }
    }

    @Override
    public void putString(int x, int y, String string) {
        this.grid.addString(x,y,string);
    }

    @Override
    public void putString(int x, int y, String string, Color background, Color foreground) {
        this.grid.addString(x,y,string);
    }

    @Override
    public void refresh() throws IOException {
        mainFrame.repaint();
    }

    @Override
    public Position getCenterCoords() throws IOException {
        return new Position((grid.getMaxX() - tabSize)/2,grid.getMaxY()/2);
    }

    @Override
    public int getMaxDrawCoord() throws IOException {
        return grid.getMaxX() - tabSize;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void drawHealth(int PlayerHealth, int playerMaxHealth) {

    }

    @Override
    public void drawHunger(int playerHunger) {

    }

    @Override
    public void drawThirst(int playerThirst) {

    }

    @Override
    public void drawTitle() {

    }

    @Override
    public void drawStats(EStat stats) {

    }

    @Override
    public void drawEquips(List<Item> equips) {

    }

    @Override
    public void drawPlayerCoords(int x, int y) {

    }

    private String parseKey(String key) {
        String[] k = key.split(" ");

        return k[0];
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(KeyEvent.getKeyText(keyEvent.getKeyCode()));
        keyPressed = true;
        lastTypedKey = KeyEvent.getKeyText(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
