import java.util.*;
import java.awt.*;

public class Block extends Rectangles {
    public Block(int mass, int position, int velocity) {
        // call constructor
        super(0, 0, 0, 0, 0, 0, Color.WHITE);

        // according to mass, size aysmptotically reaches 300
        double val = 300 - 1500 / (mass + 5);
        int size = (int) val;

        // set all of the values
        this.setX(position + 150);
        this.setY(900 - size);
        this.setW(size);
        this.setH(size);
        this.setM(mass);
        this.getV(velocity);
    }

    public void draw(Graphics g) {
        g.setColor(super.getC());
        g.fillRect(super.getX(), super.getY(), super.getW(), super.getH());
    }
}