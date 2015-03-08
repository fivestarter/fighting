package ru.fivestarter.fighting;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author yuriy on 08.03.15.
 */
public class Level extends JPanel {
    public static final int WEIGHT = 1200;
    public static final int HEIGHT = 700;

    Image img = new ImageIcon("res/station.png").getImage();

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(img, 0, 0, WEIGHT, HEIGHT, null);
    }
}
