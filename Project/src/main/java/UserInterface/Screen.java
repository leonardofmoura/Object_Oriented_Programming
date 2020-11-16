package UserInterface;

import GameCore.Item.Item;
import GameCore.Position;
import GameCore.Stats.EStat;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Screen {
    String readInput() throws IOException;

    void clear();

    void drawSideLine() throws IOException;

    void putString(int x, int y, String string);

    void putString(int x, int y, String string, Color background, Color foreground);

    void refresh() throws IOException;

    Position getCenterCoords() throws IOException;

    int getMaxDrawCoord() throws IOException;

    void close() throws IOException;

    void drawHealth(int PlayerHealth, int playerMaxHealth);

    void drawHunger(int playerHunger);

    void drawThirst(int playerThirst);

    void drawTitle();

    void drawStats(EStat stats);

    void drawEquips(List<Item> equips);

    void drawPlayerCoords(int x, int y);
}

