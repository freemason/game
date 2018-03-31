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

    public abstract void shot(Bullet bullet);/*{
        this.currentHealth -= bullet.getDamage();
        if(this.currentHealth <= 0){
            destroy();
        }
    }*/

    public abstract Bullet fire();

    //移动方法
    public void move(int direction){
        /*斜向飞行的速度问题   像素大小递增减只能是整数  。。。。。
        double angle = Math.sin(Math.PI/4);
        System.out.println(angle);*/
        switch (direction){
            case 87:
                setY(getY() - currentSpeed);
                break;
            case 83:
                setY(getY() + currentSpeed);
                break;
            case 65:
                setX(getX() - currentSpeed);
                break;
            case 68:
                setX(getX() + currentSpeed);
                break;
            case 5655:
                setY(getY() - currentSpeed);
                setX(getX() - currentSpeed);
                break;
            case 5916:
                setY(getY() - currentSpeed);
                setX(getX() + currentSpeed);
                break;
            case 5395:
                setY(getY() + currentSpeed);
                setX(getX() - currentSpeed);
                break;
            case 5644:
                setY(getY() + currentSpeed);
                setX(getX() + currentSpeed);
                break;
            default:
                break;
        }
    }

}
