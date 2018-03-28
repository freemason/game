package org.freemason.aircraftwar.model.plane;

import org.freemason.aircraftwar.container.Container;
import org.freemason.aircraftwar.model.FlyingObject;
import org.freemason.aircraftwar.model.bullet.Bullet;
import org.freemason.aircraftwar.model.element.Element;
import org.freemason.aircraftwar.model.weapon.FighterWeapon;
import org.freemason.aircraftwar.model.weapon.Weapon;
import org.freemason.aircraftwar.utils.MaterialUtils;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

public abstract class Plane extends Element implements FlyingObject {
    private int health;
    private Weapon weapon;

    protected Plane(int X, int Y,BufferedImage image, int health) {
        super(X, Y, image);
        this.health = health;
    }


    public final void shot(Bullet bullet){
        this.health -= bullet.getDamage();
        if(this.health < 0){
            dead();
        }
    }

    abstract Bullet fire();

    abstract void dead();
}
