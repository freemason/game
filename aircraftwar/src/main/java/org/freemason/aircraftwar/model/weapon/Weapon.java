package org.freemason.aircraftwar.model.weapon;

import org.freemason.aircraftwar.model.bullet.Bullet;

public abstract class Weapon{

    protected

    private final int damage;
    private final int speed;

    protected Weapon(int damage, int speed) {
        this.damage = damage;
        this.speed = speed;
    }

    abstract Bullet launch();

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }
}
