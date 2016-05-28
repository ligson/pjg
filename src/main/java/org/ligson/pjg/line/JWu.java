package org.ligson.pjg.line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class JWu extends JFrame implements MouseMotionListener{
	public static int x = 0;
	public static int y = 0;
	public JWu() {
		// TODO Auto-generated constructor stub
		setSize(500, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("图形解密");
		addMouseMotionListener(this);
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		//g.drawString("流远岫", x, y);
		g.fillRect(x, y, 100, 100);
	}
	public static void main(String[] args) {
		final JWu wu = new JWu();
		wu.setVisible(true);
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					wu.repaint();
				}
				
			}
		});
		thread.start();
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		System.out.println("x="+x+",y="+y);
	}

}
