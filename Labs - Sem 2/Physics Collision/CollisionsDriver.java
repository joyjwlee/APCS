import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class CollisionsDriver {
    public static void main(String[] args) {
        // create a JFrame (window) that will be visible on screen
        JFrame frame = new JFrame("Collision Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the red close button work
        frame.setLocation(0, 0); // place the frame in the upper left corner

        CollisionsCalculation engine = new CollisionsCalculation();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // set full screen
        frame.add(engine); // add game to the frame so it will be on the screen
        frame.pack();
        frame.setVisible(true);
        engine.animate();// call the playGame() method to intitiate the game
    }
}