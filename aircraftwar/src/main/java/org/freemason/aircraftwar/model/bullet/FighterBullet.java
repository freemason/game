package org.freemason.aircraftwar.model.bullet;



public class FighterBullet extends Bullet{
    public FighterBullet(int X, int Y, int damage) {
        super(X, Y, damage,2, true);    //       2px/ms
    }

    public void move(int direction) {

    }
}


