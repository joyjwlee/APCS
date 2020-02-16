import java.util.*;
import java.awt.*;

public class RamSphere extends Shape {
    public RamSphere() {
        super();
        super.setSize((int) (Math.random() * 50) + 1);
        int region = (int) (Math.random() * 8) + 1;
        int maxX = 0, minX = 0;
        int maxY = 0, minY = 0;
        if (region == 1) {
            super.setXShift(Math.abs(super.getXShift()));
            super.setYShift(Math.abs(super.getYShift()));
            minX = -2000;
            maxX = 0;
            minY = -1600;
            maxY = 0;
        } else if (region == 2) {
            super.setYShift(Math.abs(super.getYShift()));
            minX = 0;
            maxX = 1000;
            minY = -1600;
            maxY = 0;
        } else if (region == 3) {
            super.setXShift(Math.abs(super.getXShift()) * -1);
            super.setYShift(Math.abs(super.getYShift()));
            minX = 1000;
            maxX = 3000;
            minY = -1600;
            maxY = 0;
        } else if (region == 4) {
            super.setXShift(Math.abs(super.getXShift()));
            minX = -2000;
            maxX = 0;
            minY = 0;
            maxY = 800;
        } else if (region == 5) {
            super.setXShift(Math.abs(super.getXShift()) * -1);
            minX = 1000;
            maxX = 3000;
            minY = 0;
            maxY = 800;
        } else if (region == 6) {
            super.setXShift(Math.abs(super.getXShift()));
            super.setYShift(Math.abs(super.getYShift()) * -1);
            minX = -2000;
            maxX = 0;
            minY = 800;
            maxY = 2400;
        } else if (region == 7) {
            super.setYShift(Math.abs(super.getYShift()) * -1);
            minX = 0;
            maxX = 1000;
            minY = 800;
            maxY = 2400;
        } else {
            super.setXShift(Math.abs(super.getXShift()) * -1);
            super.setYShift(Math.abs(super.getYShift()) * -1);
            minX = 1000;
            maxX = 3000;
            minY = 800;
            maxY = 2400;
        }
        super.setX((int) (Math.random() * ((maxX - minX) + 1)) + minX);
        super.setY((int) (Math.random() * ((maxY - minY) + 1)) + minY);
    }

    public void move() {
        super.setX(super.getX() + super.getXShift());
        super.setY(super.getY() + super.getYShift());
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(super.getX(), super.getY(), super.getSize(), super.getSize());
    }
}