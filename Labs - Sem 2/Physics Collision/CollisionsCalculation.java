import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CollisionsCalculation extends JPanel implements MouseListener, MouseMotionListener {
    public static final int WIDTH = 2560;
    public static final int HEIGHT = 1440;

    private JLabel label;
    private int timer = 0;
    int mouseX = 0, mouseY = 0;
    int moveX = 0, moveY = 0;
    public static Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA };
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    ArrayList<Rectangles> boundary = new ArrayList<Rectangles>();
    ArrayList<Block> blocks = new ArrayList<Block>();
    private int score = 0;
    private boolean stop = false;

    public CollisionsCalculation() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);
    }

    // This is the method that runs the game
    public void animate() {
        // Wall
        Wall wall = new Wall();
        boundary.add(wall);
        // Ground
        Ground ground = new Ground();
        boundary.add(ground);

        // Configuration stage

        // Simulation stage
        while (!stop) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
            // Redraws the screen
            this.repaint();
        }
    }

    // Precondition: executed when repaint or paintImmediately is called
    // Postcondition: the screen has been updated
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        // Wall and ground
        for (Rectangles curr : boundary) {
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