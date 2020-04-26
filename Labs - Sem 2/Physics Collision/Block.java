import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;

public class Block extends Rectangles {
    public Block(int mass, int position, int velocity, Color c) {
        // call constructor
        super(0, 0, 0, 0, 0, 0, c);

        // according to mass, size aysmptotically reaches 300
        double size = 300 - 1500 / (mass + 5);

        // set all of the values
        this.setX(position + 150);
        this.setY(900 - size);
        this.setW(size);
        this.setH(size);
        this.setM(mass);
        this.setV(velocity);
    }

    // double precision to draw rectangle
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.getC());
        Rectangle2D rect = new Rectangle2D.Double(this.getX(), this.getY(), this.getW(), this.getH());
        g2.draw(rect);
    }
}