import java.util.*;
import java.awt.*;

public class Wall extends Rectangles {
    public Wall() {
        super(150, 150, 5, 750, 0, 0, Color.WHITE);
    }

    public void draw(Graphics g) {
        g.setColor(super.getC());
        g.fillRect(super.getX(), super.getY(), super.getW(), super.getH());
    }
}