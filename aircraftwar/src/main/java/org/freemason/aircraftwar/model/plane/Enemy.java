package org.freemason.aircraftwar.model.plane;

import org.freemason.aircraftwar.model.bullet.Bullet;

import java.awt.image.BufferedImage;

public class Enemy extends Plane{
    protected Enemy(int X, int Y, BufferedImage image, int health) {
        super(X, Y, image, health);
    }

    Bullet fire() {
        return null;
    }

    public void dead() {

    }

    public void move() {

    }
}
