package org.freemason.aircraftwar.model.bullet;



public class FighterBullet extends Bullet{

    public FighterBullet(int X, int Y, int damage, int speed) {
        super(X, Y, damage, speed, true);
    }

    public void outOfBounds() {
        if (getY() > container.getHeight()){
            container.drop(this);
        }
    }
}
