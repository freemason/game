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
    private final int speed;

    private int health;

    public int getSpeed(){
        return speed;
    }

    private Weapon weapon;
    protected Plane(int X, int Y,BufferedImage image, int health, int speed) {
        super(X, Y, image);
        this.health = health;
        this.speed = speed;
    }


    public final void shot(Bullet bullet){
        this.health -= bullet.getDamage();
        if(this.health < 0){
            dead();
        }
    }

    abstract Bullet fire();

    abstract void dead();

    public final void move(int direction){
        switch (direction){
            case 87:
                setY(getY() - getSpeed());
                break;
            case 83:
                setY(getY() + getSpeed());
                break;
            case 65:
                setX(getX() - getSpeed());
                break;
            case 68:
                setX(getX() + getSpeed());
                break;
            case 5655:
                setY(getY() - getSpeed());
                setX(getX() - getSpeed());
                break;
            case 5916:
                setY(getY() - getSpeed());
                setX(getX() + getSpeed());
                break;
            case 5495:
                setY(getY() + getSpeed());
                setX(getX() - getSpeed());
                break;
            case 5644:
                setY(getY() + getSpeed());
                setX(getX() + getSpeed());
                break;
            default:
                break;
        }
    }

}
