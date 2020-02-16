import java.util.*;
import java.awt.*;

public class PlayerSphere extends Shape {
    public PlayerSphere() {
        super();
        super.setSize(20);
        super.setColor(Color.BLUE);
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(super.getX(), super.getY(), super.getSize(), super.getSize());
    }
}