package ru.fivestarter.fighting.actor;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * @author yuriy on 08.03.15.
 */
public interface Actor {
    void action();
    Rectangle getRect();
    void paint(Graphics2D graphics2D);

}
