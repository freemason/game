package org.freemason.aircraftwar.model.weapon.bullet;

import org.freemason.aircraftwar.ContextHolder;
import org.freemason.aircraftwar.model.Moveable;
import org.freemason.aircraftwar.model.element.Element;
import org.freemason.aircraftwar.model.plane.Plane;
import org.freemason.aircraftwar.utils.MaterialUtils;

import java.util.concurrent.ExecutorService;

public abstract class Bullet extends Element implements Moveable {

    //子弹伤害值
    private final int damage;
    //飞行速度
    private final int speed;
    //飞行方向
    private final boolean direction;

    //子弹  可销毁
    public abstract void destroy();

    @Override
    public final void outOfBounds() {
        destroy();
    }

    //子弹 方向为true 向下飞 即为敌机子弹  反之为座机子弹
    protected Bullet(int X, int Y, int damage, int speed, boolean direction) {
        super(X, Y, MaterialUtils.getBulletImage());
        this.damage = damage;
        this.speed = speed;
        this.direction = direction;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public final void move(int dir){

        if (direction){
            setY(getY() + speed);
        }else {
            setY(getY() - speed);
        }
        if (checkOutOfBounds()){
            outOfBounds();
            destroy();
        }
        //bullet has only two directions, ignore direction parameter!
    }

    //子弹击中飞机
    public void hit(Plane plane){
        //碰撞判断
        plane.shot(this);
        destroy();
    }

    private boolean checkOutOfBounds(){
        if (direction){
            return getY() >= container.getHeight();
        }else{
            return getY() + getHeight() < 0;
        }
    }


}