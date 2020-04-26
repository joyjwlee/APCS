import java.awt.*;

public class Ground extends Rectangles {
    public Ground(Color c) {
        super(150, 900, 0x3f3f3f, 5, 0, 0, c);
    }

    public void draw(Graphics g) {
        g.setColor(super.getC());
        g.fillRect((int) super.getX(), (int) super.getY(), (int) super.getW(), (int) super.getH());
    }
}