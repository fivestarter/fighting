package ru.fivestarter.fighting.actor.animation;

import java.awt.Image;

import javax.swing.ImageIcon;

import ru.fivestarter.fighting.actor.Coordinates;
import ru.fivestarter.fighting.actor.animation.impl.Stand;
import ru.fivestarter.fighting.actor.animation.impl.WalkBackward;
import ru.fivestarter.fighting.actor.animation.impl.WalkForward;

/**
 * @author yuriy on 09.03.15.
 */
public class PlayerAnimation {

    private Image img;

    private CoordinateManager coordinateManager;
    private CoordinateManager stand;
    private CoordinateManager walkForward;
    private CoordinateManager walkBackward;


    public PlayerAnimation(int speed, String path) {
        img = new ImageIcon(path).getImage();
        stand = new Stand(speed);
        walkForward = new WalkForward(speed);
        walkBackward = new WalkBackward(speed);
        coordinateManager = stand;
    }

    public Image getImg() {
        return img;
    }

    public Coordinates getCoordinates() {
        return coordinateManager.getCoordinates();
    }

    public void stay() {
        coordinateManager = stand;
    }

    public void goRight() {
        coordinateManager = walkForward;
    }

    public void goBack() {
        coordinateManager = walkBackward;
    }
}
