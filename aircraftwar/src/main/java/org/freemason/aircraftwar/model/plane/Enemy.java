package org.freemason.aircraftwar.model.plane;

import org.freemason.aircraftwar.model.weapon.bullet.Bullet;

import java.awt.image.BufferedImage;

public class Enemy extends Plane{
    protected Enemy(int X, int Y, BufferedImage image, int health) {
        super(X, Y, image, health,10);
    }

    @Override
    public void shot(Bullet bullet) {

    }
    @Override
    public Bullet fire() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void outOfBounds() {

    }

    @Override
    protected void join() {
        container.addEnemy(this);
    }
}
