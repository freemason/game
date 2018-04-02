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

    //飞行方向
    private final boolean direction;

    //子弹  可销毁
    public abstract void destroy();

    @Override
    public final void outOfBounds() {
        destroy();
    }

    //子弹 方向为true 向下飞 即为敌机子弹  反之为座机子弹
    protected Bullet(int X, int Y, int damage, boolean direction) {
        super(X, Y, MaterialUtils.getBulletImage());
        this.damage = damage;
        this.direction = direction;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public final void move(int dir){
        //bullet has only two directions, ignore direction parameter!
        if (direction){
            setY(getY() + 1);
        }else {
            setY(getY() - 1);
        }
        if (checkOutOfBounds()){
            outOfBounds();
        }
    }


    /**
     * 子弹击中飞机
     * @param plane 被击中的飞机
     */
    public void hit(Plane plane){
        //碰撞判断
        if((getY() + getHeight() > plane.getY() && getY() < plane.getY() + plane.getHeight() ) &&   //纵向
            getX() + getWidth()  > plane.getX() && getX() < plane.getX() + plane.getWidth() ){      //横向
            plane.shot(this);
            destroy();
        }
    }

    private boolean checkOutOfBounds(){
        if (direction){
            return getY() >= container.getHeight();
        }else{
            return getY() + getHeight() < 0;
        }
    }

}
