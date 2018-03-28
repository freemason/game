package org.freemason.aircraftwar.model.plane;

import org.freemason.aircraftwar.model.bullet.Bullet;
import org.freemason.aircraftwar.utils.MaterialUtils;

import java.awt.image.BufferedImage;

public class Fighter extends Plane{


    public Fighter(int X, int Y, String fighterName, int health) {
        super(X, Y, MaterialUtils.getPlaneImage(fighterName), health);
    }

    Bullet fire() {
        return null;
    }

    void dead() {

    }

    public void fly() {

    }

    public void outOfBounds() {

    }

    public void move() {

    }
}
