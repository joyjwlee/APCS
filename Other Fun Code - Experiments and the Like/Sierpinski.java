import java.awt.*;
import javax.swing.*;

public class Sierpinski extends JPanel {
	public static int OFFSET = 25;
	private static int depth = 7;

	@Override
	public void paint(Graphics g) {
		Point p1 = new Point(getWidth() / 2, OFFSET);
		Point p2 = new Point(OFFSET, getHeight() - OFFSET);
		Point p3 = new Point(getWidth() - OFFSET, getHeight() - OFFSET);
		drawTriangles(g, depth, p1, p2, p3);
	}

	private static void drawLine(Graphics g, Point p1, Point p2) {
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	private static Point midPoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}

	private static void drawTriangles(Graphics g, int depth, Point p1, Point p2, Point p3) {
		if (depth == 0) {
			drawLine(g, p1, p2);
			drawLine(g, p2, p3);
			drawLine(g, p3, p1);
		} else {
			drawTriangles(g, depth - 1, p1, midPoint(p1, p2), midPoint(p1, p3));
			drawTriangles(g, depth - 1, p2, midPoint(p2, p1), midPoint(p2, p3));
			drawTriangles(g, depth - 1, p3, midPoint(p3, p1), midPoint(p3, p2));
		}
	}

	public static void main(String[] args) {
		JFrame w = new JFrame("Triangles");
		w.setBounds(500, 500, 500, 500);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Sierpinski panel = new Sierpinski();
		panel.setBackground(Color.WHITE);
		Container c = w.getContentPane();
		c.add(panel);
		w.setResizable(false);
		w.setVisible(true);
	}
}