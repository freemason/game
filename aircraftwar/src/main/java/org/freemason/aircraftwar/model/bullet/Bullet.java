package org.freemason.aircraftwar.model.bullet;

import org.freemason.aircraftwar.container.Container;
import org.freemason.aircraftwar.model.FlyingObject;
import org.freemason.aircraftwar.model.bullet.factory.BulletFactory;
import org.freemason.aircraftwar.model.element.Element;
import org.freemason.aircraftwar.model.plane.Plane;
import org.freemason.aircraftwar.utils.MaterialUtils;

import java.awt.image.BufferedImage;

public abstract class Bullet extends Element implements FlyingObject {
    //子弹伤害值
    private final int damage;
    //飞行速度
    private final int speed;
    //飞行方向
    private final boolean direction;

    //子弹 方向为true 向上飞 即为座机子弹   反之为敌机子弹
    protected Bullet(int X, int Y, int damage, int speed, boolean direction) {
        super(X, Y, MaterialUtils.getBulletImage());
        this.damage = damage;
        this.speed = speed;
        this.direction = direction;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isDirection() {
        return direction;
    }

    public final void fly(){
        if (direction){
            setY(getY() + getSpeed());
        }else {
            setY(getY() - getSpeed());
        }
    }

    //子弹击中飞机
    public void hit(Plane plane){
        //碰撞判断
        plane.shot(this);
        container.drop(this);
    }

}
