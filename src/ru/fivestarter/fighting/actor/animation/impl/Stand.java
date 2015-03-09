package ru.fivestarter.fighting.actor.animation.impl;

import ru.fivestarter.fighting.actor.Coordinates;
import ru.fivestarter.fighting.actor.animation.CoordinateManager;

/**
 * @author yuriy on 09.03.15.
 */
public class Stand implements CoordinateManager {
    private static final int X1 = 0;
    private static final int Y1 = 20;
    private static final int X2 = 53;
    private static final int Y2 = 103;
    private static final int STEP = 53;
    private static final int FRAMES = 2;
    private static final int FREQ = 3;

    private Coordinates coordinates = new Coordinates(X1, Y1, X2, Y2);
    private int speed;
    private int count = 0;
    private int frame = 0;

    public Stand(int speed) {
        this.speed = speed;
    }

    @Override
    public Coordinates getCoordinates() {
        if (count >= speed / FREQ) {
            frame++;
            if (frame > FRAMES) {
                coordinates.setX1(X1);
                coordinates.setX2(X2);
                frame = 0;
            } else {
                coordinates.setX1(coordinates.getX1() + STEP);
                coordinates.setX2(coordinates.getX2() + STEP);
            }
            count = 0;
        }
        count++;
        return coordinates;
    }
}
