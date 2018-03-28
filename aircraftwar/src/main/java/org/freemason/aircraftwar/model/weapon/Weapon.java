package org.freemason.aircraftwar.model.weapon;

import org.freemason.aircraftwar.model.bullet.Bullet;
import org.freemason.aircraftwar.model.bullet.factory.BulletFactory;
import org.freemason.aircraftwar.model.plane.Plane;

public abstract class Weapon implements BulletFactory{
    //伤害值 射速 攻击间隔
    private  int damage;
    private  int speed;
    private  int launchInterval;
    //战机
    protected Plane plane;

    protected Weapon(int damage, int speed ,int launchInterval, Plane plane) {
        this.damage = damage;
        this.speed = speed;
        this.launchInterval = launchInterval;
        this.plane = plane;
    }

    public final Bullet launch(){
        return produce();
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLaunchInterval() {
        return launchInterval;
    }

    public void upgrade(UpgradeType upgradeType, int upgradeValue){
        switch (upgradeType){
            case fireUpgrade:
                this.damage += upgradeValue;
                break;
            case speedUpgrade:
                this.speed += upgradeValue;
                break;
            case intervalUpgrade:
                this.launchInterval -= upgradeValue;
        }
    }


    public enum UpgradeType{
        fireUpgrade,
        speedUpgrade,
        intervalUpgrade;
    }
}
