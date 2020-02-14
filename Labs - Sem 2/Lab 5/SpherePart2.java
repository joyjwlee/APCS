import java.util.*;
import java.awt.*;

public class SpherePart2 extends Shape {
    public SpherePart2() {
        super();
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(super.getX(), super.getY(), super.getSize(), super.getSize());
    }
}