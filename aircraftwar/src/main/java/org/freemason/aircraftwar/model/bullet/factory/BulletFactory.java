package org.freemason.aircraftwar.model.bullet.factory;

import org.freemason.aircraftwar.model.bullet.Bullet;

public interface BulletFactory {
    Bullet produce(int damage, int speed);
}
