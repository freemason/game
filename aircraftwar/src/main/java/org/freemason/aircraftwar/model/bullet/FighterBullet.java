package org.freemason.aircraftwar.model.bullet;

public class FighterBullet extends  Bullet{

    public FighterBullet(int damage, int speed) {
        super(damage, speed, true);
    }

    public void move(){
        setY(getY() + getSpeed());
    }
}
