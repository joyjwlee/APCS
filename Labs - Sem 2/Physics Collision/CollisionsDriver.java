import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class CollisionsDriver {
    public static void main(String[] args) {
        // create a JFrame (window) that will be visible on screen
        JFrame frame = new JFrame("Elastic Collision Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the red close button work
        frame.setLocation(50, 50); // place the frame in the upper left corner

        CollisionsCalculation engine = new CollisionsCalculation();

        frame.setPreferredSize(new Dimension(1920, 1080)); // set frame 1920x1080
        frame.setResizable(false); // cannot resize
        frame.add(engine); // add game to the frame so it will be on the screen
        frame.pack();
        frame.setVisible(true);
        engine.animate();// call the playGame() method to intitiate the game
    }
}