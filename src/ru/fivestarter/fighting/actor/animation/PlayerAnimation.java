package ru.fivestarter.fighting.actor.animation;

import java.awt.Image;

import javax.swing.ImageIcon;

import ru.fivestarter.fighting.actor.Coordinates;
import ru.fivestarter.fighting.actor.animation.impl.StandingManager;
import ru.fivestarter.fighting.actor.animation.impl.WalkForward;

/**
 * @author yuriy on 09.03.15.
 */
public class PlayerAnimation {

    private Image img;

    private CoordinateManager coordinateManager;
    private CoordinateManager standingManager;
    private CoordinateManager walkForward;


    public PlayerAnimation(int speed, String path) {
        img = new ImageIcon(path).getImage();
        standingManager = new StandingManager(speed);
        walkForward = new WalkForward(speed);
        coordinateManager = standingManager;
    }

    public Image getImg() {
        return img;
    }

    public Coordinates getCoordinates() {
        return coordinateManager.getCoordinates();
    }

    public void stay() {
        coordinateManager = standingManager;
    }

    public void goRight() {
        coordinateManager = walkForward;
    }
}
