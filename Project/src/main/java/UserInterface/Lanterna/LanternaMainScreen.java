package UserInterface.Lanterna;

import GameCore.Item.Body_Part_Equip;
import GameCore.Item.Item;
import GameCore.Position;
import GameCore.Stats.EStat;
import UserInterface.Screen;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static java.lang.String.valueOf;

public class LanternaMainScreen implements Screen {
    private Terminal terminal;
    private com.googlecode.lanterna.screen.Screen screen;
    private TextGraphics graphics;
    private final int tabSize = 50;

    public LanternaMainScreen() throws IOException {
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(200,50)).createTerminal();
        screen = new TerminalScreen(terminal);
        graphics = screen.newTextGraphics();

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    public LanternaMainScreen(int columns, int rows) throws IOException {
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(columns,rows)).createTerminal();
        screen = new TerminalScreen(terminal);
        graphics = screen.newTextGraphics();

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    public LanternaMainScreen(Terminal terminal) throws IOException {
        this.terminal = terminal;
        screen = new TerminalScreen(terminal);
        graphics = screen.newTextGraphics();

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

    }

    public void close() throws IOException {
        terminal.close();
    }

    public String readInput() throws IOException {
        return parseArrows(screen.readInput().getKeyType().toString());
    }

    private String parseArrows(String key) {
        switch (key) {
            case  "ArrowUp":
                return "Up";

            case "ArrowDown" :
                return "Down";

            case "ArrowLeft" :
                return "Left";

            case "ArrowRight":
                return "Right";

             default:
                 return key;
        }
    }

    public void drawSideLine() throws IOException {
        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.setForegroundColor(TextColor.ANSI.WHITE);

        for (int i = 0; i < terminal.getTerminalSize().getRows(); i++) {
            putString(terminal.getTerminalSize().getColumns() - tabSize, i, " ",TextColor.ANSI.WHITE.toColor(),TextColor.ANSI.WHITE.toColor());
        }

        //screen.doResizeIfNecessary();
        //screen.refresh();
    }

    public void clear() {
        screen.clear();
    }

    public void putString(int x, int y, String string) {
        graphics.setForegroundColor(TextColor.ANSI.WHITE);
        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.putString(x,y,string);
    }

    public void putString(int x, int y, String string, Color background, Color foreground) {
        int[] backArray = new int[3];
        backArray[0] = background.getRed();
        backArray[1] = background.getGreen();
        backArray[2] = background.getBlue();

        int[] foreArray = new int[3];
        foreArray[0] = foreground.getRed();
        foreArray[1] = foreground.getGreen();
        foreArray[2] = foreground.getBlue();

        graphics.setBackgroundColor(new TextColor.RGB( backArray[0],backArray[1], backArray[2]));
        graphics.setForegroundColor(new TextColor.RGB( foreArray[0],  foreArray[1], foreArray[2]));
        graphics.putString(x,y,string);
    }

    public void refresh() throws IOException {
        screen.doResizeIfNecessary();
        screen.refresh();
    }

    public Position getCenterCoords() throws IOException {
        return new Position((terminal.getTerminalSize().getColumns() - 50)/2,terminal.getTerminalSize().getRows()/2);
    }


    public int getMaxDrawCoord() throws IOException {
        return terminal.getTerminalSize().getColumns() - tabSize;
    }

    public void drawTitle() {
        putString(160,4,"Calamity: Black Nights Onward!",TextColor.ANSI.BLACK.toColor(),new TextColor.RGB(255,255,51).toColor());

    }

    public void drawPlayerCoords(int x,int y){
        putString(160,2,valueOf(x) + "   " + valueOf(y) ,TextColor.ANSI.BLACK.toColor(),new TextColor.RGB(255,255,51).toColor());
    }

    private void drawBar(int x, int y, int percentage,Color fg, Color bg){
        for (int i = 0; i < percentage  ; i++) {
            putString(x+i,y," ",fg,bg);
        }
    }

    private int getfrac(int value, int max_value, int multiplier){
        double tmp = (double) value / (double) max_value;
        int tmpret = (int) Math.round(tmp*multiplier);
        return ( tmpret > 20) ? 20 : tmpret;
    }

    public void drawHealth(int playerHealth, int maxPlayerHealth) {
        int frac = getfrac(playerHealth,maxPlayerHealth,20);

        putString(160,8,"HP:",TextColor.ANSI.BLACK.toColor(),new TextColor.RGB(255,0,0).toColor());
        putString(163,8, valueOf(playerHealth));

        drawBar(168 , 8, 20, new TextColor.RGB(100,0,0).toColor(), TextColor.ANSI.BLACK.toColor());
        drawBar(168,8,frac,new TextColor.RGB(255,0,0).toColor(),TextColor.ANSI.BLACK.toColor());
    }

    public void drawHunger(int playerHunger) {
        int frac = getfrac(playerHunger,100,20);

        putString(160,10,"HU:",TextColor.ANSI.BLACK.toColor(),new TextColor.RGB(0,255,0).toColor());
        putString(163,10, valueOf(playerHunger));

        drawBar(168,10,20,new TextColor.RGB(34,134,34).toColor(),TextColor.ANSI.BLACK.toColor());
        drawBar(168,10,frac,new TextColor.RGB(0,255,0).toColor(),TextColor.ANSI.BLACK.toColor());
    }

    public void drawThirst(int playerThirst) {
        int frac = getfrac(playerThirst,100,20);

        putString(160,12,"TH:",TextColor.ANSI.BLACK.toColor(),new TextColor.RGB(0,0,255).toColor());
        putString(163,12, valueOf(playerThirst));

        drawBar(168, 12, 20, new TextColor.RGB(0,0,128).toColor(), TextColor.ANSI.BLACK.toColor());
        drawBar(168,12,frac,new TextColor.RGB(0,0,255).toColor(),TextColor.ANSI.BLACK.toColor());

    }

    private String nspaces(int n){
        return new String(new char[n]).replace("\0"," ");
    }

    public void drawStats(EStat stats) {
        Color black = TextColor.ANSI.BLACK.toColor();
        Color yellow = new TextColor.RGB(255,255,51).toColor();
        Color white = TextColor.ANSI.WHITE.toColor();

        putString(160,16,"STATS",black,yellow);

        putString(160,17,"Str: ",black,yellow);
        putString(165,17, valueOf(stats.getStr()));

        putString(173,17,"Melee DMG "      + nspaces(4) + ": " ,black,yellow);
        putString(173 + 16,17, valueOf(stats.getMeleeDMG()));
        putString(173,18,"Throw Bonus "    + nspaces(2) + ": ",black,yellow);
        putString(173 + 16,18, valueOf(stats.getThrowbonus()));
        putString(173,19,"Read Time "      + nspaces(4) + ": " ,black,yellow);
        putString(173 + 16,19, valueOf(stats.getReadtime()));
        putString(173,20,"Range Penalty "  + ": ",black,yellow);
        putString(173 + 16,20, valueOf(stats.getRangedpen()));


        putString(160,18,"Dex: ",black,yellow);
        putString(165,18, valueOf(stats.getDex()));

        putString(160,19,"Int: ",black,yellow);
        putString(165,19, valueOf(stats.getInt()));

        putString(160,20,"Per: ",black,yellow);
        putString(165,20, valueOf(stats.getPer()));
    }

    public void drawEquips(List<Item> equips) {
        Color black = TextColor.ANSI.BLACK.toColor();
        Color yellow = new TextColor.RGB(255,255,51).toColor();


        int line_number = 23;

        putString(160, line_number, "EQUIPAMENT:",black,yellow);
        line_number++;

        int i = 0;


        for (Item item:equips) {
            String itemname;
            String durability;
            if (item.isNull()) {
                itemname = "";
                durability = "";
            } else{
                itemname = item.getName();
                durability = valueOf(item.getCurrentDurability());
            }

            int n = (11 - Body_Part_Equip.getPart(i).length());
            String spaces = new String(new char[n]).replace("\0"," ");
            putString(160,line_number, Body_Part_Equip.getPart(i) +  spaces + ": " + itemname + " " + durability,black,yellow);
            line_number++;
            i++;
        }
    }
}
