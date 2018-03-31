package org.freemason.aircraftwar.model.weapon.factory;

import org.freemason.aircraftwar.model.plane.Enemy;
import org.freemason.aircraftwar.model.weapon.bullet.Bullet;
import org.freemason.aircraftwar.model.weapon.bullet.EnemyBullet;
import org.freemason.aircraftwar.model.weapon.bullet.FighterBullet;

public interface BulletFactory {

    /*FighterBullet produceFighterBullet(int X, int Y, int damage);

    EnemyBullet produceEnemyBullet(int X, int Y, int damage);*/

    Bullet produce(int X, int Y, int damage);

}
