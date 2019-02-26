import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private TerminalScreen screen;

    public Game() {
        try {
            Terminal terminal =new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null); //we dont need a cursor
            screen.startScreen();           //screens must be started
            screen.doResizeIfNecessary();   //resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws  IOException {
        screen.clear();
        screen.setCharacter(10,10, new TextCharacter('X'));
        screen.refresh();
    }

    public void run() throws IOException {
        this.draw();
    }
}
