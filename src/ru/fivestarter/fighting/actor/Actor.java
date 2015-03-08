package ru.fivestarter.fighting.actor;

import java.awt.Image;

/**
 * @author yuriy on 08.03.15.
 */
public interface Actor {
    void action();
    int getX();
    int getY();
    Image getImage();

}
