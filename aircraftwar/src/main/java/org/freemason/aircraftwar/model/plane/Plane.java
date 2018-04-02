package org.freemason.aircraftwar.model.plane;

import org.freemason.aircraftwar.model.Moveable;
import org.freemason.aircraftwar.model.weapon.bullet.Bullet;
import org.freemason.aircraftwar.model.element.Element;
import org.freemason.aircraftwar.model.weapon.Weapon;

import java.awt.image.BufferedImage;

public abstract class Plane extends Element implements Moveable{
    //初始飞行速度
    private final int initialSpeed;
    //生命值上限
    private final int maxHealth;

    //当前速度
    private int currentSpeed;
    //当前生命值
    private int currentHealth;

    //武器装备
    private Weapon[] weapon;

    protected Weapon[] getWeapon(){
        return weapon;
    }

    public abstract void destroy();

    public int getInitialSpeed() {
        return initialSpeed;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    protected int getCurrentSpeed() {
        return currentSpeed;
    }

    protected int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    protected void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }



    //允许子类修改挂载的武器  以实现 火力升级等
    protected void setWeapon(Weapon...weapon){
        this.weapon = weapon;
    }

    protected Plane(int X, int Y, BufferedImage image, int maxHealth, int initialSpeed, Weapon...weapon) {
        super(X, Y, image);
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.initialSpeed = initialSpeed;
        this.currentSpeed = initialSpeed;
        this.weapon = weapon;
    }
    //throw  new UnsupportedOperationException("fighter can't escape from the container!");

    protected abstract void shot(Bullet bullet);/*{
        this.currentHealth -= bullet.getDamage();
        if(this.currentHealth <= 0){
            destroy();
        }
    }*/

    public abstract Bullet fire();

    /**
     * 飞机移动步长均为1px 以调用频率实现速度
     * @param direction 飞行方向
     * d→    a←   w↑   s↓
     * ↑        87
     * ←        65
     * ↓        83
     * →        68
     * ←↑       5655
     * ↑→       5916
     * ←↓       5395
     * ↓→       5644
     */
    public void move(int direction){
        switch (direction){
            case 87:
                setY(getY() - 1);
                break;
            case 83:
                setY(getY() + 1);
                break;
            case 65:
                setX(getX() - 1);
                break;
            case 68:
                setX(getX() + 1);
                break;
            case 5655:
                setY(getY() - 1);
                setX(getX() - 1);
                break;
            case 5916:
                setY(getY() - 1);
                setX(getX() + 1);
                break;
            case 5395:
                setY(getY() + 1);
                setX(getX() - 1);
                break;
            case 5644:
                setY(getY() + 1);
                setX(getX() + 1);
                break;
            default:
                break;
        }
    }

}
