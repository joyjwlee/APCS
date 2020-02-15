import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickGamePart2 extends JPanel implements MouseListener, MouseMotionListener {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private JLabel label;
    private int timer = 0;
    int mouseX = 0, mouseY = 0;
    int moveX = 0, moveY = 0;
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    private int shapeCount = 0;
    private int circCount = 0;

    // constructor - sets the initial conditions for this Game object
    public ClickGamePart2() {
        // make a panel with dimensions WIDTH by HEIGHT with a blue background
        this.setLayout(null);// Don't change
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));// Don't change

        // create and format a JLabel to display a timer
        label = new JLabel("");
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
    }

    // This is the method that runs the game
    public void playGame() {
        boolean over = false;
        while (!over) {
            try {
                if (timer % 2000 == 0) {
                    if (shapes.size() <= 50) {
                        if (Math.random() > 0.5) {
                            shapes.add(new SpherePart2());
                        } else {
                            shapes.add(new Cube());
                        }
                        shapeCount++;
                    }
                }
                Thread.sleep(10);// pause for 10 milliseconds
                timer += 10;
                // label.setText("Time: " + timer / 1000);
                // label.setText(mouseX + "," + mouseY);
                label.setText(moveX + "," + moveY);
            } catch (InterruptedException ex) {
            }
            for (int i = 0; i < shapes.size(); i++) {
                Shape curr = shapes.get(i);
                if (curr instanceof SpherePart2) {
                    int centX = curr.getX() + curr.getSize() / 2;
                    int centY = curr.getY() + curr.getSize() / 2;
                    int dX = Math.abs(moveX - centX);
                    int dY = Math.abs(moveY - centY);

                    if (dX * dX + dY * dY <= curr.getSize() * curr.getSize() / 4) { // If intersect, remove same colors
                        Color toRemove = shapes.get(i).getColor();
                        shapes.remove(i);
                        shapeCount--;
                        circCount++;
                        for (int j = 0; j < shapes.size(); j++) {
                            if (shapes.get(j) instanceof SpherePart2 && shapes.get(j).getColor() == toRemove) {
                                shapes.remove(j);
                                shapeCount--;
                                circCount++;
                            }
                        }
                    } else { // Otherwise move it
                        curr.move();
                    }
                } else { // Move non-sphere
                    curr.move();
                }
            }
            this.repaint();// redraw the screen with the updated locations; calls paintComponent below
            if (shapeCount == 50) {
                over = true;
            }
        }
        label.setText("Elim: " + circCount);
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