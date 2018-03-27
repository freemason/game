package org.freemason.aircraftwar.model.weapon;

import org.freemason.aircraftwar.model.bullet.Bullet;

public class FighterWeapon extends Weapon{
    protected FighterWeapon(int damage, int speed) {
        super(damage, speed);
    }

    Bullet launch() {
        return null;
    }

    public Bullet produce(int damage, int speed, boolean direction) {
        return null;
    }
}
