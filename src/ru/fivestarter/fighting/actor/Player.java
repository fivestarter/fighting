package ru.fivestarter.fighting.actor;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import ru.fivestarter.fighting.actor.animation.PlayerAnimation;

/**
 * @author yuriy on 08.03.15.
 */
public class Player implements Actor{
    public static final int INIT_X = 30;
    public static final int INIT_Y = 450;
    public static final int SPEED = 5;
    public static final int HEIGHT = 140;
    public static final int WEIGHT = 90;

    private Coordinates coordinates;
    private PlayerAnimation animation;

    public Player(int framePerSecond) {
        coordinates = new Coordinates(INIT_X, INIT_Y, WEIGHT, HEIGHT);
        animation = new PlayerAnimation(framePerSecond, "res/guile.png");
    }

    @Override
    public void action() {

    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        Coordinates sourceCoordinates = animation.getCoordinates();
        graphics2D.drawImage(animation.getImg(), coordinates.getX1(), coordinates.getY1(),
                coordinates.getX2(), coordinates.getY2(),
                sourceCoordinates.getX1(), sourceCoordinates.getY1(),
                sourceCoordinates.getX2(), sourceCoordinates.getY2(), null);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            coordinates.setY1(coordinates.getY1() - SPEED);
            animation.goRight();
        }
        if (key == KeyEvent.VK_S) {
            coordinates.setY1(coordinates.getY1() + SPEED);
            animation.goRight();
        }
        if (key == KeyEvent.VK_A) {
            coordinates.setX1(coordinates.getX1() - SPEED);
            animation.turnLeft();
            animation.goRight();
        }
        if (key == KeyEvent.VK_D) {
            coordinates.setX1(coordinates.getX1() + SPEED);
            animation.turnRight();
            animation.goRight();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_A || key == KeyEvent.VK_S || key == KeyEvent.VK_W) {
            animation.stay();
        }
    }
}
