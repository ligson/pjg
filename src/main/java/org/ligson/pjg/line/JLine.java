package org.ligson.pjg.line;

import javax.swing.JFrame;

public class JLine extends JFrame {
	public JLine() {
		// TODO Auto-generated constructor stub
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("图形解密");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JLine jLine = new JLine();
		jLine.setVisible(true);
	}
}
