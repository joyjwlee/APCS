import javax.swing.*;
import java.awt.*;

public class CollisionsDriver {
    // JFrame object
    static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Elastic Collision Simulator"); // create Jframe and give title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the red close button work
        frame.setLocation(50, 50); // place the frame in the upper left corner

        CollisionsCalculation engine = new CollisionsCalculation(); // create the object to run

        frame.setPreferredSize(new Dimension(1920, 1080)); // set frame 1920x1080
        frame.setResizable(false); // cannot resize
        frame.add(engine); // add engine to the frame so it will be on the screen
        frame.pack(); // pack frame
        frame.setVisible(true); // make it able to be seen
        engine.animate(); // call the animate() method to intitiate the game
    }

    public static JFrame getFrame() {
        return frame;
    }
}