import java.awt.*;

public class Ground extends Rectangles {
    public Ground() {
        super(150, 900, 0x3f3f3f, 5, 0, 0, Color.WHITE);
    }

    public void draw(Graphics g) {
        g.setColor(super.getC());
        g.fillRect((int) super.getX(), (int) super.getY(), (int) super.getW(), (int) super.getH());
    }
}