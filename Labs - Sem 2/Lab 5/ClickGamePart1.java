import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickGamePart1 extends JPanel implements MouseListener, MouseMotionListener {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private JLabel label;
    private int timer = 0;
    int mouseX = 0, mouseY = 0;
    int moveX = 0, moveY = 0;
    ArrayList<SpherePart1> spheres = new ArrayList<SpherePart1>();

    // constructor - sets the initial conditions for this Game object
    public ClickGamePart1() {
        // make a panel with dimensions WIDTH by HEIGHT with a blue background
        this.setLayout(null);// Don't change
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));// Don't change

        // create and format a JLabel to display a timer
        label = new JLabel("Time: " + 0);
        this.add(label);
        label.setVisible(true);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        // label.setBounds(400, 30, 200, 30);
        label.setBounds(400, 30, 200, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);// I'll tell you later - Don't change

        spheres.add(new SpherePart1());// Just add one for now
    }

    // This is the method that runs the game
    public void playGame() {
        boolean over = false;
        while (!over) {
            try {
                Thread.sleep(10);// pause for 10 milliseconds
                timer += 10;
                // label.setText("Time: " + timer / 1000);
                // label.setText(mouseX + "," + mouseY);
                label.setText(moveX + "," + moveY);
                if (timer % 2000 == 0) {
                    spheres.add(new SpherePart1());
                }
            } catch (InterruptedException ex) {
            }
            for (int i = 0; i < spheres.size(); i++) {
                SpherePart1 curr = spheres.get(i);
                boolean intersects = false;
                int centX = curr.getX() + curr.getSize() / 2;
                int centY = curr.getY() + curr.getSize() / 2;
                int dX = Math.abs(moveX - centX);
                int dY = Math.abs(moveY - centY);
                if (dX * dX + dY * dY <= curr.getSize() * curr.getSize()) {
                    intersects = true;
                }
                if (intersects) {
                    spheres.remove(i);
                } else {
                    curr.move();
                }
            }
            this.repaint();// redraw the screen with the updated locations; calls paintComponent below
        }
    }

    // Precondition: executed when repaint or paintImmediately is called
    // Postcondition: the screen has been updated
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        for (SpherePart1 curr : spheres) {
            curr.draw(page);
        }
    }

    // this method is called whenever the mouse button is pressed
    public void mousePressed(MouseEvent event) {
        mouseX = event.getX(); // returns the x coordinate of the cursor when the mouse is clicked
        mouseY = event.getY(); // returns the y coordinate of the cursor when the mouse is clicked
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

    // MouseMotionListener Stuff: constantly update whenver mouse is moved
    public void mouseMoved(MouseEvent event) {
        moveX = event.getX();
        moveY = event.getY();
    }

    public void mouseDragged(MouseEvent event) {
        moveX = event.getX();
        moveY = event.getY();
    }
}