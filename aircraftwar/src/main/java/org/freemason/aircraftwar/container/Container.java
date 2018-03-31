package org.freemason.aircraftwar.container;

import org.freemason.aircraftwar.model.weapon.bullet.EnemyBullet;
import org.freemason.aircraftwar.model.weapon.bullet.FighterBullet;
import org.freemason.aircraftwar.model.plane.Enemy;
import org.freemason.aircraftwar.model.plane.Fighter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Container extends JPanel{

    private final int height;
    private final int width;

    private List<FighterBullet> fighterBullets = new ArrayList<FighterBullet>(50);
    private List<EnemyBullet>   enemyBullets   = new ArrayList<EnemyBullet>(50);

    private List<Enemy> enemys = new ArrayList<Enemy>(20);
    private Fighter fighter;

    public Container(int height, int width, String fighterName) {
        fighter = new Fighter(0,0,fighterName,100,20);
        this.height = height;
        this.width = width;

    }

    public void enemyJoin(Enemy e){
        enemys.add(e);
    }
    public void dropEnemy(Enemy e){
        enemys.remove(e);
    }



    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

}
