package org.ligson.pjg.line;

import javax.swing.*;

/**
 * Created by ligson on 2017/1/4.
 */
public class Chess extends JFrame {
    public Chess() {
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.setVisible(true);
    }
}
