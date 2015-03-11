package ru.fivestarter.fighting.actor.animation.impl.stand;

/**
 * @author yuriy on 11.03.15.
 */
public class StandRight extends Stand {
    private static final int X = 0;
    private static final int WIDTH = 53;
    public StandRight(int framePerSecond) {
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
