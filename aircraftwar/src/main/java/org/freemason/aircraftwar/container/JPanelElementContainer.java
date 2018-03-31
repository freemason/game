package org.freemason.aircraftwar.container;

import org.freemason.aircraftwar.ContextHolder;
import org.freemason.aircraftwar.model.weapon.bullet.Bullet;
import org.freemason.aircraftwar.model.weapon.bullet.EnemyBullet;
import org.freemason.aircraftwar.model.weapon.bullet.FighterBullet;
import org.freemason.aircraftwar.model.plane.Enemy;
import org.freemason.aircraftwar.model.plane.Fighter;
import org.freemason.aircraftwar.utils.MaterialUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/**
 * JPanel 实现元素容器并在元素（数量、位置）发生变化时重绘
 * @see JPanel
 * @see ElementContainer
 * @see BufferedImage
 * @see List
 * @see CopyOnWriteArrayList
 */
public class JPanelElementContainer extends JPanel implements ElementContainer {
    private ExecutorService executorService = ContextHolder.getBean(ExecutorService.class);
    private final BufferedImage backgroundImage = MaterialUtils.getBackgroundImage();

    private Fighter fighter;

    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
    }

    public JPanelElementContainer() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (bullets.isEmpty()){
                        continue;
                    }
                    for (FighterBullet fighterBullet : bullets){
                        fighterBullet.move(0);
                    }
                    repaint();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private List<Enemy> enemys = new CopyOnWriteArrayList<>();

    private List<EnemyBullet> enemyBullets = new CopyOnWriteArrayList<>();

    private List<FighterBullet> bullets = new CopyOnWriteArrayList<>();


    /**
     * @see {@link JComponent#paint}
     * @param g --!
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null); // 画背景图
        paintExistElements(g);
    }

    public void paintExistElements(Graphics g){
        g.drawImage(fighter.getImage(), fighter.getX(), fighter.getY(), null);

        for (FighterBullet fighterBullet : bullets){
            g.drawImage(fighterBullet.getImage(), fighterBullet.getX(), fighterBullet.getY(), null);
        }

    }

    @Override
    public int getHeight() {
        return backgroundImage.getHeight();
    }

    @Override
    public int getWidth() {
        return backgroundImage.getWidth();
    }

    public void addEnemy(Enemy e) {
        this.enemys.add(e);
    }

    public void removeEnemy(Enemy e) {
        this.enemys.remove(e);
    }

    public void addBullet(FighterBullet fighterBullet) {
        this.bullets.add(fighterBullet);
    }

    public void removeBullet(FighterBullet fighterBullet) {
        this.bullets.remove(fighterBullet);
    }

    public void addEnemyBullet(EnemyBullet enemyBullet) {
        this.enemyBullets.add(enemyBullet);
    }

    public void removeEnemyBullet(EnemyBullet enemyBullet) {
        this.enemyBullets.remove(enemyBullet);
    }
}
