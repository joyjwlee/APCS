import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CollisionsCalculation extends JPanel implements MouseListener, MouseMotionListener {
    public static final int WIDTH = 2560;
    public static final int HEIGHT = 1440;

    private JLabel label;
    int mouseX = 0, mouseY = 0;
    int moveX = 0, moveY = 0;
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    ArrayList<Rectangles> boundary = new ArrayList<Rectangles>();
    ArrayList<Block> blocks = new ArrayList<Block>();
    private boolean stop = false;

    public CollisionsCalculation() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);
    }

    // ! This is the method that runs the game
    public void animate() {
        // * Makes wall and ground
        makeBoundary();

        // ? Configuration stage
        configuration();

        // ? Simulation stage
        simulation();
    }

    // Precondition: executed when repaint or paintImmediately is called
    // Postcondition: the screen has been updated
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        // Wall and ground
        for (Rectangles curr : boundary) {
            curr.draw(page);
        }
        for (Block curr : blocks) {
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

    // Makes boundary
    public void makeBoundary() {
        // Wall
        Wall wall = new Wall();
        boundary.add(wall);
        // Ground
        Ground ground = new Ground();
        boundary.add(ground);
        // Tick marks along ground
        for (int i = 0; i <= 200; i++) {
            Ground tick = new Ground();
            tick.setX(150 + 10 * i);
            tick.setY(ground.getY());
            tick.setW(1);
            tick.setH(10);
            if (i % 5 == 0) {
                tick.setH(15);
            }
            if (i % 10 == 0) {
                tick.setH(20);
            }
            boundary.add(tick);
        }
    }

    // megamethod of jbuttons and jtextfields
    public void configuration() {
        JButton setValues = new JButton("Set Values");
        setValues.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (!setValues.getText().equals(""))
                    setValues.setText(setValues.getText());
                setValues.setVisible(false);
                initialization();

            }
        });
        setValues.setBounds(1500, 150, 180, 70);
        setValues.setFont(new Font("Serif", Font.BOLD, 35));
        setValues.setForeground(Color.BLACK);
        setValues.setBackground(Color.white);
        setValues.setOpaque(true);
        setValues.setBorderPainted(true);
        setValues.setBorder(BorderFactory.createBevelBorder(0, Color.white, Color.white, Color.white, Color.white));
        this.add(setValues);
    }

    public void initialization() {

    }

    public void simulation() {
        // test block
        Block block = new Block(50, 600, 2);
        blocks.add(block);

        // test block
        Block block1 = new Block(5, 200, 3);
        blocks.add(block1);

        // sorts by initial position, since blocks will stay in order forever
        Collections.sort(blocks);

        while (!stop) {
            try {
                // Move first then update velocity
                for (Block curr : blocks) {
                    curr.setX(curr.getX() + curr.getV());
                }

                // Update velocity, only check to right
                for (int i = 0; i < blocks.size() - 1; i++) {
                    Block curr = blocks.get(i);
                    // Bounce off wall
                    if (curr.getX() < 150) {
                        curr.setV(curr.getV() * -1);
                    }

                    // If there is a collision, update velocities
                    Block right = blocks.get(i + 1);
                    if (curr.getX() + curr.getW() >= right.getX()) {
                        double m1 = curr.getM();
                        double v1 = curr.getV();
                        double m2 = right.getM();
                        double v2 = right.getV();
                        curr.setV(calculateVelocity(m1, v1, m2, v2));
                        right.setV(calculateVelocity(m2, v2, m1, v1));
                        i++;
                    }
                }
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }

            // redraw screen
            this.repaint();
        }

    }

    // returns velocity for body 1
    // after elastic collision
    public double calculateVelocity(double m1, double v1, double m2, double v2) {
        double first = ((m1 - m2) / (m1 + m2)) * v1;
        double second = ((2 * m2) / (m1 + m2)) * v2;
        return (first + second);
    }
}