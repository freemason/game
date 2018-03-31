package org.freemason.aircraftwar.model.weapon.factory;

import org.freemason.aircraftwar.model.weapon.bullet.EnemyBullet;
import org.freemason.aircraftwar.model.weapon.bullet.FighterBullet;

//子弹只有两种   敌我双方   不存在扩展的可能   故使用静态工厂模式
public class MultiBulletFactory{

    public static FighterBullet produceFighterBullet(int X, int Y, int damage) {
        return new FighterBullet(X, Y, damage);
    }

    public static EnemyBullet produceEnemyBullet(int X, int Y, int damage) {
        return new EnemyBullet(X, Y, damage);
    }
}
