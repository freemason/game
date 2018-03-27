package org.freemason.aircraftwar.model;

import org.freemason.aircraftwar.model.bullet.Bullet;
import org.freemason.aircraftwar.model.weapon.Weapon;

import java.util.List;

public abstract class Plane extends FlyingObject{
    private int health;
    private List<Weapon> weapons;

    public final void shot(Bullet bullet){
        this.health -= bullet.getDamage();
        if(this.health < 0){
            dead();
        }
    }

    abstract Bullet fire();

    abstract void dead();
}
