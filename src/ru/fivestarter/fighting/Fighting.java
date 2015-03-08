package ru.fivestarter.fighting;

import javax.swing.JFrame;

/**
 * @author yuriy on 08.03.15.
 */
public class Fighting {
    private Fighting() {
    }

    public static void main(String[] args) {
        JFrame gameFrame = new JFrame("Fighting");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(Level.WEIGHT, Level.HEIGHT);
        gameFrame.add(new Level());
        gameFrame.setVisible(true);
    }
}
