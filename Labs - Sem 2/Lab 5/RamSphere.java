import java.util.*;
import java.awt.*;

public class RamSphere extends Shape {
    public RamSphere() {
        super();
        super.setSize((int) (Math.random() * 50) + 1);
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(super.getX(), super.getY(), super.getSize(), super.getSize());
    }
}