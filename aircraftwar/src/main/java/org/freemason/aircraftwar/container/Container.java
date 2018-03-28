package org.freemason.aircraftwar.container;

import org.freemason.aircraftwar.model.bullet.EnemyBullet;
import org.freemason.aircraftwar.model.bullet.FighterBullet;
import org.freemason.aircraftwar.model.element.Element;
import org.freemason.aircraftwar.model.plane.Enemy;
import org.freemason.aircraftwar.model.plane.Fighter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Container {

    private final int height;
    private final int width;

    protected Container(int height, int width) {
        this.height = height;
        this.width = width;
    }


    private List<FighterBullet> fighterBullets = new ArrayList<FighterBullet>(50);
    private List<EnemyBullet>   enemyBullets   = new ArrayList<EnemyBullet>(50);

    private List<Enemy> enemys = new ArrayList<Enemy>(20);
    private Fighter fighter = new Fighter(0,0,"F14",100);





    public void enemyJoin(Enemy e){
        enemys.add(e);
    }
    public void dropEnemy(Enemy e){
        enemys.remove(e);
        e.dead();
    }



    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Element> getElementList() {
        return elementList;
    }
}
