package org.freemason.aircraftwar.model.weapon.bullet;


import org.freemason.aircraftwar.utils.PropertiesUtil;

public class FighterBullet extends Bullet{

    /*private static final String FIGHTER_BULLET_SPEED_KEY = "fighter.bullet.speed";
    private static final int FIGHTER_BULLET_SPEED = PropertiesUtil.getProperties().getInteger(FIGHTER_BULLET_SPEED_KEY);
*/
    public FighterBullet(int X, int Y, int damage) {
        super(X, Y, damage, false);
    }

    @Override
    public void destroy() {
        container.removeBullet(this);
    }

    @Override
    protected void join() {
        container.addBullet(this);
    }

}