package org.freemason.aircraftwar.model.plane.enemy;

import org.freemason.aircraftwar.model.plane.Plane;
import org.freemason.aircraftwar.model.weapon.bullet.Bullet;
import org.freemason.aircraftwar.model.weapon.bullet.FighterBullet;

import java.awt.image.BufferedImage;

public class Enemy extends Plane {
    protected Enemy(int X, BufferedImage image, int health) {
        super(X, -image.getHeight(), image, health,10);
    }

    @Override
    public void shot(Bullet bullet) {
        FighterBullet fighterBullet = (FighterBullet)bullet;
        //碰撞逻辑

        bullet.hit(this);
    }
    @Override
    public Bullet fire() {
        return null;
    }

    @Override
    public void destroy() {
        container.removeEnemy(this);
    }

    @Override
    public void outOfBounds() {
        if(getY() >= container.getHeight()){
            destroy();
        }
    }

    @Override
    protected void join() {
        container.addEnemy(this);
    }


    public enum EnemyLevel{
        kindergarten(1,2),
        preschool(1,1),
        primary(1,1),
        junior(1,2),
        senior (1,1),
        bachelor(1,2),
        master(1,1),
        doctor(1,2);

        EnemyLevel(int damage, int speed){
            this.damage = damage;
            this.speed = speed;
        }
        private int id;
        private int damage;
        private int speed;

        public int getDamage() {
            return damage;
        }

        public int getSpeed() {
            return speed;
        }
    }

}
