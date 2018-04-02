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
    protected void shot(Bullet bullet) {
        if (bullet instanceof FighterBullet){
            FighterBullet fighterBullet = (FighterBullet)bullet;
            fighterBullet.hit(this);
        }
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
        kindergarten(10,1,2),
        preschool(10,1,2),
        primary(10,1,2),
        junior(10,1,2),
        senior(10,1,2),
        bachelor(10,1,2),
        master(10,1,2),
        doctor(10,1,2);

        EnemyLevel(int health, int damage, int speed){
            this.health = health;
            this.damage = damage;
            this.speed = speed;
        }
        private int health;
        private int damage;
        private int speed;

        public int getHealth() {
            return health;
        }

        public int getDamage() {
            return damage;
        }

        public int getSpeed() {
            return speed;
        }
    }

}
