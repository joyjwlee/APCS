import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickGamePart3 extends JPanel implements MouseListener, MouseMotionListener {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private JLabel label;
    private int timer = 0;
    int mouseX = 0, mouseY = 0;
    int moveX = 0, moveY = 0;
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    PlayerSphere player = new PlayerSphere();
    private int score = 0;

    // constructor - sets the initial conditions for this Game object
    public ClickGamePart3() {
        // make a panel with dimensions WIDTH by HEIGHT with a blue background
        this.setLayout(null);// Don't change
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));// Don't change

        // create and format a JLabel to display a timer
        label = new JLabel("");
        this.add(label);
        label.setVisible(true);
        label.setFont(new Font("Arial", Font.BOLD, 30));
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
                if (timer % 55 == 0) {
                    RamSphere toAdd = new RamSphere();
                    int size = (int) (Math.random() * (player.getSize() + 50)) + 10;
                    toAdd.setSize(size);

                    // get proper coordinates for ramsphere
                    // then set proper direction then add
                    // also change the move method

                    shapes.add(toAdd);
                }
                Thread.sleep(10);
                timer += 10;
                label.setText("Score: " + score);
            } catch (InterruptedException ex) {
            }

            // Intersection calculation based on centers
            int playerX = player.getX() + player.getSize() / 2;
            int playerY = player.getY() + player.getSize() / 2;
            for (int i = 0; i < shapes.size(); i++) {
                Shape curr = shapes.get(i);
                int centX = curr.getX() + curr.getSize() / 2;
                int centY = curr.getY() + curr.getSize() / 2;
                int dX = Math.abs(playerX - centX);
                int dY = Math.abs(playerY - centY);
                int totRadii = (player.getSize() + curr.getSize()) / 2;

                // If intersect
                if (dX * dX + dY * dY <= totRadii * totRadii) {
                    // If can eat
                    if (player.getSize() >= curr.getSize()) {
                        shapes.remove(i);
                        score++;
                        player.setSize(player.getSize() + 2);
                    }
                    // If not big enough
                    else {
                        shapes.get(i).move();
                        over = true;
                    }
                }
                // If not intersect
                else {
                    // If out of bounds
                    if (centX <= -2000 || 3000 <= centX || centY <= -1600 || 2400 <= centY) {
                        shapes.remove(i);
                    }
                    // If in bounds
                    else {
                        shapes.get(i).move();
                    }
                }

                // think about possible i and j decrements when removing
                // FOR TESTING PURPOSES - DELETE LATER!
                // over = false;
            }

            player.setX(moveX - player.getSize() / 2);
            player.setY(moveY - player.getSize() / 2);
            this.repaint();// redraw the screen with the updated locations; calls paintComponent below
        }
        // label.setText("Score: " + score);
        // change everything to final end screen
        // call repaint after
    }

    // Precondition: executed when repaint or paintImmediately is called
    // Postcondition: the screen has been updated
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        player.draw(page);
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