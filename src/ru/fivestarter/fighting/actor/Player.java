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

    private int diagonalSpeed = (int) Math.sqrt(Math.pow(SPEED, 2)/2);
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

    public void up() {
        coordinates.setY1(coordinates.getY1() - SPEED);
        animation.walk();
    }

    public void down() {
        coordinates.setY1(coordinates.getY1() + SPEED);
        animation.walk();
    }

    public void right() {
        coordinates.setX1(coordinates.getX1() + SPEED);
        animation.turnRight();
        animation.walk();
    }

    public void left() {
        coordinates.setX1(coordinates.getX1() - SPEED);
        animation.turnLeft();
        animation.walk();
    }

    public void stay() {
        animation.stay();
    }

    public void upRight() {
        coordinates.setY1(coordinates.getY1() - diagonalSpeed);
        coordinates.setX1(coordinates.getX1() + diagonalSpeed);
        animation.turnRight();
        animation.walk();
    }

    public void downRight() {
        coordinates.setY1(coordinates.getY1() + diagonalSpeed);
        coordinates.setX1(coordinates.getX1() + diagonalSpeed);
        animation.turnRight();
        animation.walk();
    }

    public void upLeft() {
        coordinates.setY1(coordinates.getY1() - diagonalSpeed);
        coordinates.setX1(coordinates.getX1() - diagonalSpeed);
        animation.turnLeft();
        animation.walk();
    }

    public void downLeft() {
        coordinates.setY1(coordinates.getY1() + diagonalSpeed);
        coordinates.setX1(coordinates.getX1() - diagonalSpeed);
        animation.turnLeft();
        animation.walk();
    }
}
