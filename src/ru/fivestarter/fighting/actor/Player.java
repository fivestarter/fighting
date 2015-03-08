package ru.fivestarter.fighting.actor;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

/**
 * @author yuriy on 08.03.15.
 */
public class Player implements Actor{
    public static final int INIT_X = 30;
    public static final int INIT_Y = 350;
    public static final int SPEED = 3;

    Image img = new ImageIcon("res/spl.png").getImage();
    private int x = INIT_X;
    private int y = INIT_Y;
    private Rectangle rectangle;

    public Player() {
        rectangle = new Rectangle(0, 0, img.getWidth(null), img.getHeight(null));
    }

    @Override
    public void action() {

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Rectangle getRect() {
        return rectangle;
    }

    @Override
    public Image getImage() {
        return img;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            y -= SPEED;
        }
        if (key == KeyEvent.VK_S) {
            y += SPEED;
        }
        if (key == KeyEvent.VK_A) {
            x -= SPEED;
        }
        if (key == KeyEvent.VK_D) {
            x += SPEED;
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
