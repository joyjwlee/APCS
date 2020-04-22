import java.util.*;
import java.awt.*;

public class Block extends Rectangles {
    public Block() {
        super(150, 1150, 0x3f3f3f, 5, 0, 0, Color.WHITE);
    }

    public void draw(Graphics g) {
        g.setColor(super.getC());
        g.fillRect(super.getX(), super.getY(), super.getW(), super.getH());
    }
}