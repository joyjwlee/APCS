import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickGame extends JPanel implements MouseListener {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private JLabel label;
    private int timer = 0;

    // constructor - sets the initial conditions for this Game object
    public ClickGame() {
        // make a panel with dimensions WIDTH by HEIGHT with a blue background
        this.setLayout(null);// Don't change
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));// Don't change

        // create and format a JLabel to display a timer
        label = new JLabel("Time: " + 0);
        this.add(label);
        label.setVisible(true);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBounds(400, 30, 200, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);

        this.addMouseListener(this);

        this.setFocusable(true);// I'll tell you later - Don't change
    }

    // This is the method that runs the game
    public void playGame() {
        boolean over = false;
        while (!over) {
            try {
                Thread.sleep(10);// pause for 10 milliseconds
                timer += 10;
                label.setText("Time: " + timer / 1000);
            } catch (InterruptedException ex) {
            }
            this.repaint();// redraw the screen with the updated locations; calls paintComponent below
        }
    }

    // Precondition: executed when repaint or paintImmediately is called
    // Postcondition: the screen has been updated
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
    }

    // this method is called whenever the mouse button is pressed
    public void mousePressed(MouseEvent event) {
        int mouseX = event.getX(); // returns the x coordinate of the cursor when the mouse is clicked
        int mouseY = event.getY(); // returns the y coordinate of the cursor when the mouse is clicked
    }

    // required for compiling; do not use
    public void mouseClicked(MouseEvent event) {
    }

    // required for compiling; do not use
    public void mouseReleased(MouseEvent event) {
    }

    // required for compiling; do not use
    public void mouseEntered(MouseEvent event) {
    }

    // required for compiling; do not use
    public void mouseExited(MouseEvent event) {
    }
}