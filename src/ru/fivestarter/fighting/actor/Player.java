package ru.fivestarter.fighting.actor;

import java.awt.Graphics2D;
import java.awt.Rectangle;
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

    private Rectangle rectangle;
    private PlayerAnimation animation;

    public Player(int speed) {
        rectangle = new Rectangle(INIT_X, INIT_Y, WEIGHT, HEIGHT);
        animation = new PlayerAnimation(speed, "res/guile.png");
    }

    @Override
    public void action() {

    }

    @Override
    public Rectangle getRect() {
        return rectangle;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        Coordinates coordinates = animation.getCoordinates();
        graphics2D.drawImage(animation.getImg(), rectangle.x, rectangle.y,
                rectangle.x + rectangle.width, rectangle.y + rectangle.height,
                coordinates.getX1(), coordinates.getY1(), coordinates.getX2(), coordinates.getY2(), null);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            rectangle.y -= SPEED;
        }
        if (key == KeyEvent.VK_S) {
            rectangle.y += SPEED;
        }
        if (key == KeyEvent.VK_A) {
            rectangle.x -= SPEED;
        }
        if (key == KeyEvent.VK_D) {
            rectangle.x += SPEED;
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
