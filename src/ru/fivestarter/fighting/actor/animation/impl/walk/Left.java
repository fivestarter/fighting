package ru.fivestarter.fighting.actor.animation.impl.walk;

/**
 * @author yuriy on 11.03.15.
 */
public class Left extends WalkForward {
    private static final int X1 = 216;
    private static final int WIDTH = -55;

    public Left(int framePerSecond) {
        super(framePerSecond);
    }

    @Override
    public int getInitX() {
        return X1;
    }

    @Override
    public int getInitWidth() {
        return WIDTH;
    }
}
