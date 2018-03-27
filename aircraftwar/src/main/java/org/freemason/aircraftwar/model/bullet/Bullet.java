package org.freemason.aircraftwar.model.bullet;

import org.freemason.aircraftwar.model.FlyingObject;
import org.freemason.aircraftwar.model.Plane;

public abstract class Bullet extends FlyingObject {
    //子弹伤害值
    private final int damage;
    //飞行速度
    private final int speed;
    //飞行方向
    private final boolean direction;

    //子弹 方向为true 向上飞 即为座机子弹   反之为敌机子弹
    protected Bullet(int damage, int speed, boolean direction) {
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

    public void hit(Plane plane){
        //逻辑判断
        plane.shot(this);
    }

}
