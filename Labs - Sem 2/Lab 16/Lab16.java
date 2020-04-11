import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab16 extends JPanel implements MouseListener, MouseMotionListener {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private JLabel label;
    private int timer = 0;
    int mouseX = 0, mouseY = 0;
    int moveX = 0, moveY = 0;
    public static Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA };
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    private int score = 0;

    public Lab16() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);
    }

    // This is the method that runs the game
    public void animate() {
        for (int i = 0; i < 12; i++) {
            ScreenSaverCircle toAdd = new ScreenSaverCircle();
            int size = 30;
            toAdd.setSize(size);
            toAdd.setColor(colors[i % 6]);
            shapes.add(toAdd);
        }

        // while true for screen animation
        while (true) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int scrW = (int) screenSize.getWidth();
            int scrH = (int) screenSize.getHeight();
            try {
                for (int i = 0; i < shapes.size(); i++) {
                    Shape curr = shapes.get(i);
                    // Orbit center, x and y
                    double orbitX = scrW / 2;
                    double orbitY = scrH / 2;
                    // Radius and speed
                    double orbitRadius = 150;
                    double orbitSpeed = Math.PI / 1000;

                    // Use polar coordinates
                    double radian = orbitSpeed * (timer + 165 * i);
                    int drawX = (int) (orbitX + orbitRadius * Math.cos(radian));
                    int drawY = (int) (orbitY + orbitRadius * Math.sin(radian));
                    curr.setX(drawX);
                    curr.setY(drawY);
                }
                Thread.sleep(10);
                timer++;
            } catch (InterruptedException ex) {
            }

            this.repaint();// redraw the screen with the updated locations; calls paintComponent below
        }
    }

    // Precondition: executed when repaint or paintImmediately is called
    // Postcondition: the screen has been updated
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        for (Shape curr : shapes) {
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