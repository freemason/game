package org.freemason.aircraftwar.container;

import org.freemason.aircraftwar.model.weapon.bullet.EnemyBullet;
import org.freemason.aircraftwar.model.weapon.bullet.FighterBullet;
import org.freemason.aircraftwar.model.plane.enemy.Enemy;

public interface ElementContainer {


 //   void add(Element e);

    int getHeight();

    int getWidth();


    void addEnemy(Enemy e);
    void removeEnemy(Enemy e);

    void addBullet(FighterBullet fighterBullet);
    void removeBullet(FighterBullet fighterBullet);

    void addEnemyBullet(EnemyBullet enemyBullet);
    void removeEnemyBullet(EnemyBullet enemyBullet);

}
