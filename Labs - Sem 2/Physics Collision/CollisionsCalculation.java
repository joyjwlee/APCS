/*
TODO:
- double precision, do overhaul
- configuration stage
*/

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CollisionsCalculation extends JPanel implements MouseListener, MouseMotionListener {
    // static final variables
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final Color BACKGROUNDCOLOR = Color.black;
    public static final Color FOREGROUNDCOLOR = Color.white;

    // int variables
    int mouseX = 0, mouseY = 0; // click
    int moveX = 0, moveY = 0; // drag
    int numB = 0; // number of blocks
    int selectedBlock = 0; // selected blocks; 0 is no selected

    // arraylists
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    ArrayList<Rectangles> boundary = new ArrayList<Rectangles>();
    ArrayList<Block> blocks = new ArrayList<Block>();

    // boolean variables
    private boolean configured = false;
    private boolean start = false;
    private boolean stop = false;

    // constructor
    public CollisionsCalculation() {
        this.setLayout(null);
        this.setBackground(BACKGROUNDCOLOR);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);
    }

    // MAIN METHOD, ALL METHODS IN HERE!!
    public void animate() {
        // makes wall and ground
        makeBoundary();

        // configuration stage
        makeBlocks();

        // wait to start
        startButton();

        // simulation stage
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
        // Blocks
        for (Block curr : blocks) {
            curr.draw(page);
        }
    }

    // called whenever the mouse is clicked; update x and y coordinates
    public void mousePressed(MouseEvent event) {
        mouseX = event.getX();
        mouseY = event.getY();

        // sort based on position first then update selected
        Collections.sort(blocks);
        int temp = selectedBlock;
        for (int i = 0; i < blocks.size(); i++) {
            Block curr = blocks.get(i);
            if (curr.getX() <= mouseX && mouseX <= curr.getX() + curr.getW()) {
                if (curr.getY() <= mouseY && mouseY <= curr.getY() + curr.getH()) {
                    selectedBlock = i + 1; // 1 based for user
                }
            }
        }
        // if click but no change, reset
        if (temp == selectedBlock) {
            selectedBlock = 0;
        }
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
        Wall wall = new Wall(FOREGROUNDCOLOR);
        boundary.add(wall);
        // Ground
        Ground ground = new Ground(FOREGROUNDCOLOR);
        boundary.add(ground);
        // Tick marks along ground
        for (int i = 0; i <= 200; i++) {
            Ground tick = new Ground(FOREGROUNDCOLOR);
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

    // configure the blocks
    public void makeBlocks() {
        // text field -- doesn't work :(
        // JPanel jp = new JPanel();
        // JLabel jl = new JLabel();
        // JTextField jt = new JTextField();
        // jp.add(jt);
        // this.add(jp);

        // hopefully this works?
        JFrame frame = CollisionsDriver.getFrame();
        // submit button
        JButton mass_1 = new JButton("Enter");
        mass_1.setBounds(150, 100, 140, 40);

        // enter name label
        JLabel label = new JLabel();
        label.setText("Enter left box mass :");
        label.setBounds(10, 10, 100, 100);

        // empty label which will show event after button clicked
        JLabel label1 = new JLabel();
        label1.setBounds(10, 110, 200, 100);
        // textfield to enter name
        JTextField textfield = new JTextField();
        textfield.setBounds(110, 50, 200, 30);
        // add to frame
        frame.add(label1);
        frame.add(textfield);
        frame.add(label);
        frame.add(mass_1);

        // action listener
        mass_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String textFieldValue = textfield.getText();
                label1.setText("Input:\t" + textFieldValue);
            }
        });
        // end

        // test blocks
        blocks.add(new Block(50, 700, -7, FOREGROUNDCOLOR));
        blocks.add(new Block(5, 500, -5, FOREGROUNDCOLOR));
        blocks.add(new Block(3, 100, 4, FOREGROUNDCOLOR));

        // while (!configured) {
        // this.repaint();
        // }
    }

    // megamethod of jbuttons and jtextfields
    public void startButton() {
        JButton setValues = new JButton("START");
        setValues.addActionListener(new ActionListener() {
            // if clicked
            public void actionPerformed(ActionEvent ae) {
                if (!setValues.getText().equals("")) {
                    setValues.setText(setValues.getText());
                }
                setValues.setVisible(false);
                start = true;
            }
        });
        setValues.setBounds(1500, 150, 180, 70);
        setValues.setFont(new Font("Serif", Font.BOLD, 35));
        setValues.setForeground(BACKGROUNDCOLOR);
        setValues.setBackground(FOREGROUNDCOLOR);
        setValues.setOpaque(true);
        setValues.setBorderPainted(true);
        setValues.setBorder(
                BorderFactory.createBevelBorder(0, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR));
        this.add(setValues);

        // test text label
        JLabel label = new JLabel("");
        this.add(label);
        label.setVisible(true);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBounds(400, 30, 200, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(FOREGROUNDCOLOR);

        // don't move on until start is pressed
        while (!start) {
            this.repaint();
            if (selectedBlock == 0) {
                label.setText("None selected");
            } else {
                label.setText("Block: " + selectedBlock);
            }
        }
    }

    public void simulation() {
        // sorts by initial position, since blocks will stay in order forever
        Collections.sort(blocks);

        // TRY TO FIGURE OUT INITIALIZATION HERE
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
        }

        while (!stop) {
            // Move first then update velocity
            for (Block curr : blocks) {
                curr.setX(curr.getX() + curr.getV() / 10);
            }

            // Update velocity, only check to right
            for (int i = 0; i < blocks.size() - 1; i++) {
                Block curr = blocks.get(i);
                Block right = blocks.get(i + 1);
                // Bounce off wall
                if (curr.getX() < 150) {
                    curr.setV(Math.abs(curr.getV()));
                }
                // If there is a collision, update velocities
                if (intersects(curr, right)) {
                    double m1 = curr.getM();
                    double v1 = curr.getV();
                    double m2 = right.getM();
                    double v2 = right.getV();
                    curr.setV(calculateVelocity(m1, v1, m2, v2));
                    right.setV(calculateVelocity(m2, v2, m1, v1));
                    i++;
                }
            }

            // try catch
            try {
                Thread.sleep(0, 10);
            } catch (InterruptedException ex) {
            }

            // redraw screen
            this.repaint();
        }
    }

    // returns true if blocks intersect
    public boolean intersects(Block left, Block right) {
        return (left.getX() + left.getW() >= right.getX());
    }

    // returns velocity for body 1
    // after elastic collision
    public double calculateVelocity(double m1, double v1, double m2, double v2) {
        double first = ((m1 - m2) / (m1 + m2)) * v1;
        double second = ((2 * m2) / (m1 + m2)) * v2;
        return (first + second);
    }
}