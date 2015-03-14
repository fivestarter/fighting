package ru.fivestarter.fighting.controller;

import java.awt.event.KeyEvent;

/**
 * @author yuriy on 14.03.15.
 */
public interface ControllerHandler {
    void keyPressed(KeyEvent e);
    void keyReleased(KeyEvent e);
    void handle();
}
