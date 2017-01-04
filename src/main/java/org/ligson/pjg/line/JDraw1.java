package org.ligson.pjg.line;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class JDraw1 extends JFrame {
	public JDraw1() {
		// TODO Auto-generated constructor stub
		setSize(500, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("图形解密");
		// setUndecorated(true);
	}

	public Point convertToPos(double x, double y) {
		double x2 = x + getWidth() / 2;
		double y2 = getHeight() / 2 - y;
		Point p = new Point();
		p.setLocation(x2, y2);
		return p;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);

		Point p1 = convertToPos(-250, 0);
		Point p2 = convertToPos(250, 0);
		g.drawLine(p1.x, p1.y, p2.x, p2.y);

		Point p3 = convertToPos(0, 250);
		Point p4 = convertToPos(0, -250);
		g.drawLine(p3.x, p3.y, p4.x, p4.y);

		/*
		 * for (double i = -250; i < 250; i+=0.1) { double y =
		 * Math.sin(2*i)*100; System.out.println(y); Point p = convertToPos(i,
		 * y); g.drawArc(p.x, p.y, 1, 1, 0, 360);
		 * 
		 * }
		 */

		// x2/a2 - y2/b2 = 1
		// y2=(x2/a2-1)*b2
		for (double i = -2500; i < 2500; i += 0.1) {
			double y1 = Math.sqrt((i * i / 200 - 2) * 100);
			double y2 = -y1;

			Point p11 = convertToPos(i, y1);
			Point p22 = convertToPos(i, y2);

			g.drawArc(p11.x, p11.y, 1, 1, 0, 360);
			g.drawArc(p22.x, p22.y, 1, 1, 0, 360);
			
			

		}
		
		 Ellipse2D ellipse=new Ellipse2D.Double(50,50,300,200); 
		 Graphics2D graphics2d = (Graphics2D) g;
		 graphics2d.draw(ellipse);

	}

	public static void main(String[] args) {
		final JDraw1 draw1 = new JDraw1();
		draw1.setVisible(true);
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					draw1.repaint();
				}
			}
		});
		// thread.start();
	}
}
