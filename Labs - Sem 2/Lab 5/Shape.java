import java.util.*;
import java.awt.*;

public abstract class Shape {
    // Private instance variables
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    public static Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE,
            Color.MAGENTA/* , Color.WHITE */ };
    private int x, y;
    private int xShift, yShift;
    private int size;
    private Color color;

    public Shape() {
        size = (int) (Math.random() * 101) + 50;
        x = (int) (Math.random() * WIDTH) - size;
        y = (int) (Math.random() * HEIGHT) - size;
        xShift = (int) (Math.random() * 3) + 2;
        yShift = xShift;
        if (Math.random() > 0.5)
            xShift *= -1;
        if (Math.random() > 0.5)
            yShift *= -1;
        color = colors[(int) (Math.random() * colors.length)];
    }

    public void move() {
        if (x - xShift < 0)
            xShift = Math.abs(xShift);
        if (x + size + xShift > WIDTH)
            xShift = Math.abs(xShift) * -1;
        if (y - yShift < 0)
            yShift = Math.abs(yShift);
        if (y + size + yShift > HEIGHT)
            yShift = Math.abs(yShift) * -1;
        x += xShift;
        y += yShift;
    }

    // Abstract method
    // public abstract void draw(Graphics g);
    public abstract void draw(Graphics g);

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXShift() {
        return xShift;
    }

    public int getYShift() {
        return yShift;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public Color getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    // Setter methods
    public void setX(int n) {
        x = n;
    }

    public void setY(int n) {
        y = n;
    }

    public void setSize(int n) {
        size = n;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void setXShift(int xS) {
        xShift = xS;
    }

    public void setYShift(int yS) {
        yShift = yS;
    }
}