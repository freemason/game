package org.freemason.aircraftwar.model.weapon.bullet;

import org.freemason.aircraftwar.utils.PropertiesUtil;

public class EnemyBullet extends Bullet{

    /*private static final String ENEMY_BULLET_SPEED_KEY = "enemy.bullet.speed";
    private static final int ENEMY_BULLET_SPEED = PropertiesUtil.getProperties().getInteger(ENEMY_BULLET_SPEED_KEY);
*/
    public EnemyBullet(int X, int Y, int damage) {
        super(X, Y, damage, true);
    }

    @Override
    public void destroy() {
        container.removeEnemyBullet(this);
    }
    @Override
    protected void join() {
        container.addEnemyBullet(this);
    }
}