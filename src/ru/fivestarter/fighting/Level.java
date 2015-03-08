package ru.fivestarter.fighting;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import ru.fivestarter.fighting.actor.Actor;
import ru.fivestarter.fighting.actor.Player;

/**
 * @author yuriy on 08.03.15.
 */
public class Level extends JPanel implements ActionListener{
    public static final int WEIGHT = 1200;
    public static final int HEIGHT = 700;
    private static final int PERIOD = 20;
    private static final int MAX_TOP = 330;
    private static final int MAX_BOTTOM = HEIGHT;
    private static final int MAX_LEFT = 0;
    private static final int MAX_RIGHT = WEIGHT;

    Timer mainTimer = new Timer(PERIOD, this);

    Image img = new ImageIcon("res/station.png").getImage();
    List<Actor> actors = new ArrayList<>();

    public Level() {
        Player player = new Player();
        actors.add(player);
        mainTimer.start();
        addKeyListener(new PlayerKeyAdapter(player));
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(img, 0, 0, WEIGHT, HEIGHT, null);

        for (Actor actor : actors) {
            actor.paint(graphics2D);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Actor actor : actors) {
            fixCoordinates(actor);
            actor.action();
        }
        repaint();
    }

    public void fixCoordinates(Actor actor) {
        if (actor.getRect().x + actor.getRect().width > MAX_RIGHT) {
            actor.getRect().x = MAX_RIGHT - actor.getRect().width;
        }
        if (actor.getRect().x < MAX_LEFT) {
            actor.getRect().x = MAX_LEFT;
        }
        if (actor.getRect().y + actor.getRect().height > MAX_BOTTOM) {
            actor.getRect().y = MAX_BOTTOM - actor.getRect().height;
        }
        if (actor.getRect().y < MAX_TOP) {
            actor.getRect().y = MAX_TOP;
        }

    }

    private class PlayerKeyAdapter extends KeyAdapter {
        private Player player;

        public PlayerKeyAdapter(Player player) {
            this.player = player;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}
