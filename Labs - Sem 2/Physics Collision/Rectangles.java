import java.util.*;
import java.awt.*;

// Used to make wall, ground, and blocks
public abstract class Rectangles {
    // Private instance variables
    private int x, y; // location
    private int width, height;
    private int mass, velocity;
    private Color color;

    public Rectangles(int x, int y, int width, int height, int mass, int velocity, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.mass = mass;
        this.velocity = velocity;
        this.color = color;
    }

    // Abstract method
    public abstract void draw(Graphics g);

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return width;
    }

    public int getH() {
        return height;
    }

    public int getM() {
        return mass;
    }

    public int getV() {
        return velocity;
    }

    public Color getC() {
        return color;
    }

    // Setter methods
    public void setX(int n) {
        x = n;
    }

    public void setY(int n) {
        y = n;
    }

    public void setW(int n) {
        width = n;
    }

    public void setH(int n) {
        height = n;
    }

    public void setM(int n) {
        mass = n;
    }

    public void getV(int n) {
        velocity = n;
    }

    public void setC(Color n) {
        color = n;
    }
}