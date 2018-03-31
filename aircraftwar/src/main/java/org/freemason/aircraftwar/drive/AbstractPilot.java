package org.freemason.aircraftwar.drive;

import org.freemason.aircraftwar.model.weapon.bullet.Bullet;
import org.freemason.aircraftwar.model.plane.Plane;

/**
 * 抽象飞行员 实现 飞行指令
 */
public abstract class AbstractPilot implements FlightCommand {
    //驾驶的飞机
    private Plane target;

    //初始化给当前对象指定飞机  并且不能为空
    protected AbstractPilot(Plane target){
        setTarget(target);
    }

    protected void setTarget(Plane target){
        if (target == null){
            throw new NullPointerException("target plane can not be null!");
        }
        this.target = target;
    }
    //基础实现驾驶方法
    public void drive(int direction){
        this.target.move(direction);
    }
    //技术实现开火方法
    public Bullet fire(){
        return this.target.fire();
    }
}
