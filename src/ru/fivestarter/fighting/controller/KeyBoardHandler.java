package ru.fivestarter.fighting.controller;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import ru.fivestarter.fighting.actor.Player;

/**
 * @author yuriy on 14.03.15.
 */
public class KeyBoardHandler implements ControllerHandler {
    private Set<Integer> keys = new HashSet<>();
    private Player player;

    public KeyBoardHandler(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        keys.add(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        keys.remove(key);
    }

    @Override
    public void handle() {
        if (hasUp() && !hasRight() && !hasDown() && !hasLeft()) {
            player.up();
            return;
        }
        if (hasRight() && !hasUp() && !hasDown() && !hasLeft()) {
            player.right();
            return;
        }
        if (hasDown() && !hasUp() && !hasRight() && !hasLeft()) {
            player.down();
            return;
        }
        if (hasLeft() && !hasUp() && !hasDown() && !hasRight()) {
            player.left();
            return;
        }
        if ((!hasLeft() && !hasUp() && !hasDown() && !hasRight()) || hasUp() && hasDown() || hasLeft() && hasRight()) {
            player.stay();
            return;
        }
        if (hasUp() && hasRight()) {
            player.upRight();
            return;
        }

        if (hasDown() && hasRight()) {
            player.downRight();
            return;
        }

        if (hasUp() && hasLeft()) {
            player.upLeft();
            return;
        }

        if (hasDown() && hasLeft()) {
            player.downLeft();
            return;
        }
    }

    private boolean hasUp() {
        return keys.contains(KeyEvent.VK_W);
    }

    private boolean hasRight() {
        return keys.contains(KeyEvent.VK_D);
    }

    private boolean hasDown() {
        return keys.contains(KeyEvent.VK_S);
    }

    private boolean hasLeft() {
        return keys.contains(KeyEvent.VK_A);
    }

}
