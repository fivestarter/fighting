package ru.fivestarter.fighting.actor;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

/**
 * @author yuriy on 08.03.15.
 */
public class Player implements Actor{
    public static final int INIT_X = 30;
    public static final int INIT_Y = 450;
    public static final int SPEED = 5;
    public static final int HEIGHT = 140;
    public static final int WEIGHT = 90;

    private static final int SOURCE_X1 = 0;
    private static final int SOURCE_Y1 = 20;
    private static final int SOURCE_WEIGHT = 51;
    private static final int SOURCE_HEIGHT = 83;


    Image img = new ImageIcon("res/guile.png").getImage();
    private Rectangle rectangle;
    private Rectangle sourceRect;
    private int speed;

    public Player(int speed) {
        this.speed = speed;
        rectangle = new Rectangle(INIT_X, INIT_Y, WEIGHT, HEIGHT);
        sourceRect = new Rectangle(SOURCE_X1, SOURCE_Y1, SOURCE_WEIGHT, SOURCE_HEIGHT);
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
        graphics2D.drawImage(img, rectangle.x, rectangle.y,
                rectangle.x + rectangle.width, rectangle.y + rectangle.height,
                sourceRect.x, sourceRect.y, sourceRect.x + sourceRect.width, sourceRect.y + sourceRect.height, null);
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
