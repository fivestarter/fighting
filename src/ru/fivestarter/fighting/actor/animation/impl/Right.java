package ru.fivestarter.fighting.actor.animation.impl;

/**
 * @author yuriy on 11.03.15.
 */
public class Right extends WalkForward {
    private static final int X1 = 161;
    private static final int WIDTH = 53;

    public Right(int framePerSecond) {
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
