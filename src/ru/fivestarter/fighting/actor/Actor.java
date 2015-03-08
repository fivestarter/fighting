package ru.fivestarter.fighting.actor;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * @author yuriy on 08.03.15.
 */
public interface Actor {
    void action();
    int getX();
    void setX(int x);
    int getY();
    void setY(int y);
    Rectangle getRect();
    Image getImage();

}
