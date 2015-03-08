package ru.fivestarter.fighting.actor;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author yuriy on 08.03.15.
 */
public class Player implements Actor{
    public static final int INIT_X = 30;
    public static final int INIT_Y = 350;

    Image img = new ImageIcon("res/spl.png").getImage();
    private int x = INIT_X;
    private int y = INIT_Y;

    @Override
    public void paint() {

    }

    @Override
    public void action() {

    }
}
