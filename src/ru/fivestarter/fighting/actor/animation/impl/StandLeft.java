package ru.fivestarter.fighting.actor.animation.impl;

/**
 * @author yuriy on 11.03.15.
 */
public class StandLeft extends Stand {
    private static final int X = 53;
    private static final int WIDTH = -53;
    public StandLeft(int framePerSecond) {
        super(framePerSecond);
    }

    @Override
    public int getInitX() {
        return X;
    }

    @Override
    public int getInitWidth() {
        return WIDTH;
    }
}
