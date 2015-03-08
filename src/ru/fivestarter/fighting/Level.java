package ru.fivestarter.fighting;

import ru.fivestarter.fighting.actor.Actor;
import ru.fivestarter.fighting.actor.Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author yuriy on 08.03.15.
 */
public class Level extends JPanel {
    public static final int WEIGHT = 1200;
    public static final int HEIGHT = 700;

    Image img = new ImageIcon("res/station.png").getImage();
    List<Actor> actors = new ArrayList<>();

    public Level() {
        actors.add(new Player());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(img, 0, 0, WEIGHT, HEIGHT, null);

        for (Actor actor : actors) {
            actor.paint(graphics2D);
        }
    }
}
