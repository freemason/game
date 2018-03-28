package org.freemason.aircraftwar.model.plane;

import org.freemason.aircraftwar.container.Container;
import org.freemason.aircraftwar.model.bullet.Bullet;

import java.awt.image.BufferedImage;

public class Fighter extends Plane{


    protected Fighter(int X, int Y, BufferedImage image, int health) {
        super(X, Y, image, health);
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
}
