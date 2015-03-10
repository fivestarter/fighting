package ru.fivestarter.fighting.actor;

/**
 * @author yuriy on 09.03.15.
 */
public class Coordinates {
    private int x1;
    private int y1;
    private int with;
    private int height;

    public Coordinates(int x1, int y1, int with, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.with = with;
        this.height = height;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getWith() {
        return with;
    }

    public void setWith(int with) {
        this.with = with;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX2() {
        return getX1() + getWith();
    }


    public int getY2() {
        return getY1() + getHeight();
    }

}
