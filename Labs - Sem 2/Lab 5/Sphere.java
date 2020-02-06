import java.awt.*;

public class Sphere {
    // Private instance variables
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private int x, y;
    private int xShift, yShift;
    private int size;
    private Color color;

    public Sphere() {
        x = (int) (Math.random() * WIDTH);
        y = (int) (Math.random() * HEIGHT);
        size = 50;
        x += size / 2;
        y += size / 2;
        xShift = 2;
        yShift = 2;
        if (Math.random() > 0.5)
            xShift *= -1;
        if (Math.random() > 0.5)
            yShift *= -1;
        color = Color.RED;
    }

    public void move() {
        if (x < 0 || x + size > WIDTH)
            xShift *= -1;
        if (y < 0 || y + size > HEIGHT)
            yShift *= -1;
        x += xShift;
        y += yShift;
    }

    public void draw(Graphics page) {
        page.setColor(color);
        page.fillOval(x, y, size, size);
    }

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }
}