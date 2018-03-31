package org.freemason.aircraftwar.model.weapon;

import org.freemason.aircraftwar.model.weapon.bullet.Bullet;
import org.freemason.aircraftwar.model.weapon.factory.BulletFactory;
import org.freemason.aircraftwar.model.plane.Plane;
import org.freemason.aircraftwar.model.weapon.factory.MultiBulletFactory;
import org.freemason.aircraftwar.utils.MaterialUtils;

import java.awt.image.BufferedImage;

public abstract class Weapon{
    //伤害值 射速 攻击间隔
    private int damage;
    private long launchInterval;
    //战机
    protected Plane plane;

    protected BufferedImage bulletImage = MaterialUtils.getBulletImage();

    protected Weapon(int damage, long launchInterval, Plane plane) {
        this.damage = damage;
        this.launchInterval = launchInterval;
        this.plane = plane;
    }

    public abstract void reset();

    public abstract Bullet launch();
    /*{
        //子弹发射位置相对偏移量

        return MultiBulletFactory.produceFighterBullet(plane.getX(), plane.getY(), damage);
    }*/

    public int getDamage() {
        return damage;
    }

    public long getLaunchInterval() {
        return launchInterval;
    }


    public void upgrade(UpgradeType upgradeType, int upgradeValue, long duration){
        switch (upgradeType){
            case fireUpgrade:
                this.damage += upgradeValue;
                break;
            case intervalUpgrade:
                this.launchInterval -= upgradeValue;
                break;
        }
    }

    public enum UpgradeType{
        fireUpgrade,
        intervalUpgrade
    }
}
