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
import ru.fivestarter.fighting.controller.ControllerHandler;
import ru.fivestarter.fighting.controller.KeyBoardHandler;

/**
 * @author yuriy on 08.03.15.
 */
public class Level extends JPanel implements ActionListener{
    public static final int WEIGHT = 1200;
    public static final int HEIGHT = 700;
    public static final int SECOND = 1000;
    private static final int FRAME_PER_SECOND = 25;
    private static final int MAX_TOP = 330;
    private static final int MAX_BOTTOM = HEIGHT;
    private static final int MAX_LEFT = 0;
    private static final int MAX_RIGHT = WEIGHT;

    Timer mainTimer = new Timer(SECOND / FRAME_PER_SECOND, this);

    Image img = new ImageIcon("res/station.png").getImage();
    List<Actor> actors = new ArrayList<>();
    private ControllerHandler controller;

    public Level() {
        Player player = new Player(FRAME_PER_SECOND);
        controller = new KeyBoardHandler(player);
        actors.add(player);
        mainTimer.start();
        addKeyListener(new PlayerKeyAdapter());
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
        controller.handle();
        for (Actor actor : actors) {
            fixCoordinates(actor);
            actor.action();
        }
        repaint();
    }

    public void fixCoordinates(Actor actor) {
        if (actor.getCoordinates().getX2() > MAX_RIGHT) {
            actor.getCoordinates().setX1(MAX_RIGHT - actor.getCoordinates().getWith());
        }
        if (actor.getCoordinates().getX1() < MAX_LEFT) {
            actor.getCoordinates().setX1(MAX_LEFT);
        }
        if (actor.getCoordinates().getY2() > MAX_BOTTOM) {
            actor.getCoordinates().setY1(MAX_BOTTOM - actor.getCoordinates().getHeight());
        }
        if (actor.getCoordinates().getY1() < MAX_TOP) {
            actor.getCoordinates().setY1(MAX_TOP);
        }

    }

    private class PlayerKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            controller.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            controller.keyReleased(e);
        }
    }
}
