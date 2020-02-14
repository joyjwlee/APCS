import java.util.*;
import java.awt.*;

public class Cube extends Shape {
    public Cube() {
        super();
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getX(), super.getY(), super.getSize(), super.getSize());
    }
}