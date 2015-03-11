package ru.fivestarter.fighting.actor.animation;

import java.awt.Image;

import javax.swing.ImageIcon;

import ru.fivestarter.fighting.actor.Coordinates;
import ru.fivestarter.fighting.actor.animation.impl.walk.Left;
import ru.fivestarter.fighting.actor.animation.impl.walk.Right;
import ru.fivestarter.fighting.actor.animation.impl.stand.Stand;
import ru.fivestarter.fighting.actor.animation.impl.stand.StandLeft;
import ru.fivestarter.fighting.actor.animation.impl.stand.StandRight;

/**
 * @author yuriy on 09.03.15.
 */
public class PlayerAnimation {

    private Image img;

    private CoordinateManager coordinateManager;
    private Stand stand;
    private CoordinateManager walkForward;

    private StandLeft standLeft;
    private StandRight standRight;
    private Left left;
    private Right right;

    public PlayerAnimation(int framePerSecond, String path) {
        img = new ImageIcon(path).getImage();
        standLeft = new StandLeft(framePerSecond);
        standRight = new StandRight(framePerSecond);
        stand = standRight;

        left = new Left(framePerSecond);
        right = new Right(framePerSecond);
        walkForward = right;
        coordinateManager = stand;
    }

    public Image getImg() {
        return img;
    }

    public Coordinates getCoordinates() {
        return coordinateManager.getCoordinates();
    }

    public void stay() {
        if (coordinateManager != stand) {
            coordinateManager = stand;
            coordinateManager.init();
        }
    }

    public void goRight() {
        if (coordinateManager != walkForward) {
            coordinateManager = walkForward;
            coordinateManager.init();
        }

    }

    public void turnRight() {
        stand = standRight;
        walkForward = right;
    }

    public void turnLeft() {
        stand = standLeft;
        walkForward = left;
    }
}
