import java.awt.*;

// Used to make wall, ground, and blocks
public abstract class Rectangles implements Comparable<Rectangles> {
    // Private instance variables
    private double x, y; // location
    private double width, height;
    private double mass, velocity;
    private Color color;

    public Rectangles(double x, double y, double width, double height, double mass, double velocity, Color color) {
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
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return width;
    }

    public double getH() {
        return height;
    }

    public double getM() {
        return mass;
    }

    public double getV() {
        return velocity;
    }

    public Color getC() {
        return color;
    }

    // Setter methods
    public void setX(double n) {
        x = n;
    }

    public void setY(double n) {
        y = n;
    }

    public void setW(double n) {
        width = n;
    }

    public void setH(double n) {
        height = n;
    }

    public void setM(double n) {
        mass = n;
    }

    public void setV(double n) {
        velocity = n;
    }

    public void setC(Color n) {
        color = n;
    }

    // sort by position for collisions
    @Override
    public int compareTo(Rectangles other) {
        int compareage = (int) ((Rectangles) other).getX();
        return ((int) (this.getX()) - compareage);
    }
}