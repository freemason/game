package org.freemason.aircraftwar.model.bullet;

import org.freemason.aircraftwar.container.Container;

import java.awt.image.BufferedImage;

public class EnemyBullet extends Bullet{

    protected EnemyBullet(int X, int Y, int damage, int speed, boolean direction) {
        super(X, Y, damage, speed, direction);
    }

    public void outOfBounds() {

    }
}
