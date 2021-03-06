package ru.fivestarter.fighting.actor.animation.impl.walk;

import ru.fivestarter.fighting.actor.Coordinates;
import ru.fivestarter.fighting.actor.animation.CoordinateManager;

/**
 * @author yuriy on 09.03.15.
 */
public class WalkBackward implements CoordinateManager {
    private static final int X1 = 379;
    private static final int Y1 = 20;
    private static final int WIDTH = 56;
    private static final int HEIGHT = 83;

    private static final int STEP = 56;
    private static final int FRAMES = 2;
    private static final int FREQ = 3;

    private Coordinates coordinates;
    private int framePerSecond;
    private int count = 0;
    private int frame = 0;

    public WalkBackward(int framePerSecond) {
        this.framePerSecond = framePerSecond;
        init();
    }

    @Override
    public Coordinates getCoordinates() {
        if (count >= framePerSecond / FREQ) {
            frame++;
            if (frame > FRAMES) {
                coordinates.setX1(X1);
                frame = 0;
            } else {
                coordinates.setX1(coordinates.getX1() - STEP);
            }
            count = 0;
        }
        count++;
        return coordinates;
    }

    @Override
    public void init() {
        count = 0;
        frame = 0;
        coordinates = new Coordinates(X1, Y1, WIDTH, HEIGHT);
    }

}
