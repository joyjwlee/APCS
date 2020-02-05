public class Sphere {
    // Private instance variables
    private int x, y;
    private int xShift = 2, yShift = 2;
    private int size;

    public Sphere() {
        x = (int) Math.random() * 50;
        y = (int) Math.random() * 50;
        size = 100;

    }

    public void move() {
        //
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