import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class ClickDriver {
    public static void main(String[] args) {
        // create a JFrame (window) that will be visible on screen
        JFrame frame = new JFrame("THE BORED BUTTON THINGY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the red close button work
        frame.setLocation(0, 0); // place the frame in the upper left corner
        // ClickGame game = new ClickGame(); // create a Game object
        // ClickGamePart2 game = new ClickGamePart2();
        ClickGamePart3 game = new ClickGamePart3();

        BufferedImage cursor_image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        cursor_image.createGraphics();
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursor_image, new Point(0, 0), "empty");
        frame.setCursor(cursor);

        frame.add(game); // add game to the frame so it will be on the screen
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        game.playGame();// call the playGame() method to intitiate the game

        /*
         * The 5 Changes 1. Don't bounce, continue to move 2. Instead of click, based on
         * intersection 3. Spawn in 1 of 8 random zones 4. Random initial speed 5.
         * Cursor moves player, increments based on how well the player does
         */
    }
}