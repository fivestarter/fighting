package ru.fivestarter.fighting.actor;

import java.awt.Graphics2D;

/**
 * @author yuriy on 08.03.15.
 */
public interface Actor {
    void paint(Graphics2D graphics2D);
    void action();
}
