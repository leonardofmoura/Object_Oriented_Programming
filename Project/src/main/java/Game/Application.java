package Game;

import UserInterface.Lanterna.LanternaMainScreen;
import UserInterface.Swing.SwingMainScreen;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("swing")) {
            SwingMainScreen screen = new SwingMainScreen();
            Game game = new Game(screen);
            game.start();
            game.end();
        }
        else if (args[0].equals("lanterna")) {
            try {
                LanternaMainScreen screen = new LanternaMainScreen();

                Game game = new Game(screen);
                game.start();
                game.end();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Wrong arguments: <lanterna|swing>");
        }
    }
}