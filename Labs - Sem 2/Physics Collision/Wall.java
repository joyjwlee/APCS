import java.awt.*;

public class Wall extends Rectangles {
    public Wall() {
        super(150, 150, 5, 750, 0, 0, Color.WHITE);
    }

    public void draw(Graphics g) {
        g.setColor(super.getC());
        g.fillRect((int) super.getX(), (int) super.getY(), (int) super.getW(), (int) super.getH());
    }
}