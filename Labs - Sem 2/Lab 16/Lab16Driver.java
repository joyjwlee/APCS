import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Lab16Driver {
    public static void main(String[] args) {
        // create a JFrame (window) that will be visible on screen
        JFrame frame = new JFrame("THE BORED BUTTON THINGY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the red close button work
        frame.setLocation(0, 0); // place the frame in the upper left corner

        Lab16 screensaver = new Lab16();

        frame.add(screensaver); // add game to the frame so it will be on the screen
        frame.pack();
        frame.setVisible(true);
        screensaver.animate();// call the playGame() method to intitiate the game
    }
}