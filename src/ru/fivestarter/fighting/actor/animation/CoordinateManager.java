package ru.fivestarter.fighting.actor.animation;

import ru.fivestarter.fighting.actor.Coordinates;

/**
 * @author yuriy on 09.03.15.
 */
public interface CoordinateManager {
    Coordinates getCoordinates();
    void init();
}
