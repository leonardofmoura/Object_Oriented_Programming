import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private TerminalScreen screen;
    private Arena arena;

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

        arena = new Arena();
    }

    private void draw() throws  IOException {
        screen.clear();
        screen.doResizeIfNecessary();
        arena.draw(screen);
        screen.refresh();
    }

    private int processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case EOF:
                return 1;
            case Character:
                switch (key.getCharacter()) {
                    case 'q':
                        screen.close();
                        break;
                }
            default:
                arena.processKey(key);
                break;
        }
        return 0;
    }

    public KeyStroke readInput() throws IOException {
        KeyStroke key = screen.readInput();
        return key;
    }

    public void run() throws IOException {
        while (true) {
            this.draw();
            if (this.processKey(this.readInput()) == 1) {
                break;
            }
        }

    }

}
