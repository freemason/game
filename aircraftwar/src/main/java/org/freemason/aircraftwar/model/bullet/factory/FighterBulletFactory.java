package org.freemason.aircraftwar.model.bullet.factory;

import org.freemason.aircraftwar.model.bullet.Bullet;
import org.freemason.aircraftwar.model.bullet.FighterBullet;

public class FighterBulletFactory implements BulletFactory{
    public Bullet produce(int damage, int speed) {
        return new FighterBullet(damage, speed);
    }
}