package org.freemason.aircraftwar.model.weapon;

import org.freemason.aircraftwar.model.bullet.Bullet;
import org.freemason.aircraftwar.model.bullet.FighterBullet;
import org.freemason.aircraftwar.model.plane.Fighter;

public class FighterWeapon extends Weapon{

    public FighterWeapon(int damage, int speed, int launchInterval, Fighter fighter) {
        super(damage, speed, launchInterval, fighter);
    }

    public Bullet produce() {
      return new FighterBullet(plane.getX(), plane.getY(), getDamage(), getSpeed());
    }
}
