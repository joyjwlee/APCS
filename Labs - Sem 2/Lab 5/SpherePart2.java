import java.awt.*;

public class SpherePart2 {
    // Private instance variables
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    public static Color[] colors = new Color[6];
    private int x, y;
    private int xShift, yShift;
    private int size;
    private Color color;

    public SpherePart2() {
        size = (int) (Math.random() * 101) + 50;
        x = (int) (Math.random() * WIDTH) - size;
        y = (int) (Math.random() * HEIGHT) - size;
        xShift = 2;
        yShift = 2;
        if (Math.random() > 0.5)
            xShift *= -1;
        if (Math.random() > 0.5)
            yShift *= -1;
        color = Color.RED;
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

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
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