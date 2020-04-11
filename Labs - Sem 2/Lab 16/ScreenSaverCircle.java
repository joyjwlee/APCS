import java.util.*;
import java.awt.*;

public class ScreenSaverCircle extends Shape {
    public ScreenSaverCircle() {
        super();
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(super.getX(), super.getY(), super.getSize(), super.getSize());
    }
}