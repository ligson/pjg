package org.ligson.pjg.line;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class JLine extends JFrame {
	public Graphics graphics;
	//坐标实际间隔
	public static int len = 10;
	//坐标长度
	public static int lineLen = 5;
	//数字间隔
	public static int numSize = 10;

	public JLine() {
		// TODO Auto-generated constructor stub
		setSize(500, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("图形解密");
		// setUndecorated(true);
	}

	@Override
	public void paint(Graphics g) {
		graphics = g;
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.YELLOW);
		g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
		g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		g.setColor(Color.RED);
		g.fillArc(getWidth() / 2 - 5, getHeight() / 2 - 5, 11, 11, 0, 360);
		g.setColor(Color.WHITE);

		// x+

		for (int i = getWidth() / 2; i < getWidth(); i += len) {
			g.drawLine(i, getHeight() / 2, i, getHeight() / 2 - lineLen);
		}
		// x-
		for (int i = getWidth() / 2; i > 0; i -= len) {
			g.drawLine(i, getHeight() / 2, i, getHeight() / 2 - lineLen);
		}
		// y+
		for (int i = getHeight() / 2; i < getHeight(); i += 20) {
			g.drawLine(getWidth() / 2, i, getWidth() / 2 + lineLen, i);
		}
		// y-
		for (int i = getHeight() / 2; i > 0; i -= len) {
			g.drawLine(getWidth() / 2, i, getWidth() / 2 + lineLen, i);
		}

		g.setColor(Color.BLACK);
		// x+
		int num = 0;

		for (int i = getWidth() / 2; i < getWidth(); i += len) {
			g.drawString(num + "", i - 5, getHeight() / 2 + 10);
			num += numSize;
		}
		int maxX = num;
		// x-
		num = 0;
		for (int i = getWidth() / 2; i > 0; i -= len) {
			g.drawString(num + "", i - 5, getHeight() / 2 + 10);
			num -= numSize;
		}
		int minX = num;

		// y+
		num = 0;
		for (int i = getHeight() / 2; i < getHeight(); i += 20) {
			if (num != 0) {
				g.drawString(num + "", getWidth() / 2 - 10, i + 5);
			}
			num -= numSize;
		}
		// y-
		num = 0;
		for (int i = getHeight() / 2; i > 0; i -= len) {
			if (num != 0) {
				g.drawString(num + "", getWidth() / 2 - 10, i + 5);
			}
			num += numSize;
		}

		// g.setColor(Color.BLUE);
		int[] xPoints = new int[maxX - minX];
		int[] yPoints = new int[maxX - minX];
		System.out.println(xPoints.length);

		int xIdx = 0;
		for (int i = minX; i < maxX; i++) {
			int xNum = i;
			int yNum = i * 3;
			System.out.println("(" + xNum + "," + yNum + ")");
		}
		
		for (int i = 0; i < getWidth(); i++) {
			int xNum = i;
			int yNum = i * 3;
			System.out.println("--(" + xNum + "," + yNum + ")--"+(xNum-xPoints.length/2));
			int x = (xNum-xPoints.length/2);
			int y = (xNum-xPoints.length/2);
			xPoints[xIdx] = x;
			yPoints[xIdx] = x;
			xIdx++;
			g.drawLine(xNum, yNum, xNum+1, yNum+1);
		}
		
		
		

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		final JLine jLine = new JLine();
		jLine.setVisible(true);
		System.out.println(jLine.graphics);
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					jLine.repaint();
				}
			}
		});
		// thread.start();
	}
}
