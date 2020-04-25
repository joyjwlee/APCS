import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CollisionsCalculation extends JPanel implements MouseListener, MouseMotionListener {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;

    int mouseX = 0, mouseY = 0;
    int moveX = 0, moveY = 0;
    int numB = 0;
    private JLabel label;
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    ArrayList<Rectangles> boundary = new ArrayList<Rectangles>();
    ArrayList<Block> blocks = new ArrayList<Block>();
    private boolean start = false;
    private final boolean stop = false;

    public CollisionsCalculation() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);

        // create and format a JLabel to display a timer
        label = new JLabel("");
        this.add(label);
        label.setVisible(true);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBounds(400, 30, 200, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);
    }

    // method to run simulation
    public void animate() {
        // makes wall and ground
        makeBoundary();

        // configuration stage; only "start" button for now
        configuration();

        // simulation stage
        simulation();
    }

    // Precondition: executed when repaint or paintImmediately is called
    // Postcondition: the screen has been updated
    public void paintComponent(final Graphics page) {
        super.paintComponent(page);
        // Wall and ground
        for (final Rectangles curr : boundary) {
            curr.draw(page);
        }
        // Blocks
        for (final Block curr : blocks) {
            curr.draw(page);
        }
    }

    // this method is called whenever the mouse button is pressed
    public void mousePressed(final MouseEvent event) {
        mouseX = event.getX(); // returns the x coordinate of the cursor when the mouse is clicked
        mouseY = event.getY(); // returns the y coordinate of the cursor when the mouse is clicked
    }

    // required for compiling; do not use
    public void mouseClicked(final MouseEvent event) {
    }

    // required for compiling; do not use
    public void mouseReleased(final MouseEvent event) {
    }

    // required for compiling; do not use
    public void mouseEntered(final MouseEvent event) {
    }

    // required for compiling; do not use
    public void mouseExited(final MouseEvent event) {
    }

    // MouseMotionListener Stuff: constantly update whenver mouse is moved
    public void mouseMoved(final MouseEvent event) {
        moveX = event.getX();
        moveY = event.getY();
    }

    public void mouseDragged(final MouseEvent event) {
        moveX = event.getX();
        moveY = event.getY();
    }

    // Makes boundary
    public void makeBoundary() {
        // Wall
        final Wall wall = new Wall();
        boundary.add(wall);
        // Ground
        final Ground ground = new Ground();
        boundary.add(ground);
        // Tick marks along ground
        for (int i = 0; i <= 200; i++) {
            final Ground tick = new Ground();
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
        final JButton setValues = new JButton("START");
        setValues.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent ae) {
                if (!setValues.getText().equals(""))
                    setValues.setText(setValues.getText());
                setValues.setVisible(false);
                initialization();
                start = true;
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

    // work on later perhaps...
    public void initialization() {
    }

    public void simulation() {
        // test block
        final Block block = new Block(50, 600, 2);
        blocks.add(block);

        // test block
        final Block block1 = new Block(5, 400, -5);
        blocks.add(block1);

        // sorts by initial position, since blocks will stay in order forever
        Collections.sort(blocks);

        // don't move on until start is pressed
        while (!start) {
            this.repaint();
        }

        while (!stop) {
            try {
                // Move first then update velocity
                for (final Block curr : blocks) {
                    curr.setX(curr.getX() + curr.getV());
                }

                // Update velocity, only check to right
                for (int i = 0; i < blocks.size() - 1; i++) {
                    final Block curr = blocks.get(i);
                    // Bounce off wall
                    if (curr.getX() < 150) {
                        curr.setV(curr.getV() * -1);
                    }

                    // If there is a collision, update velocities
                    final Block right = blocks.get(i + 1);
                    if (curr.getX() + curr.getW() >= right.getX()) {
                        final double m1 = curr.getM();
                        final double v1 = curr.getV();
                        final double m2 = right.getM();
                        final double v2 = right.getV();
                        curr.setV(calculateVelocity(m1, v1, m2, v2));
                        right.setV(calculateVelocity(m2, v2, m1, v1));
                        i++;
                    }
                }
                Thread.sleep(10);
            } catch (final InterruptedException ex) {
            }

            // set label text
            label.setText("Number of blocks: " + numB);

            // redraw screen
            this.repaint();
        }

    }

    // returns velocity for body 1
    // after elastic collision
    public double calculateVelocity(final double m1, final double v1, final double m2, final double v2) {
        final double first = ((m1 - m2) / (m1 + m2)) * v1;
        final double second = ((2 * m2) / (m1 + m2)) * v2;
        return (first + second);
    }
}