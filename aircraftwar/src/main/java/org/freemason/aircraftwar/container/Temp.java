package org.freemason.aircraftwar.container;

import org.freemason.aircraftwar.ContextHolder;
import org.freemason.aircraftwar.model.plane.Fighter;
import org.freemason.aircraftwar.utils.MaterialUtils;

import javax.swing.*;
import java.awt.*;

public class Temp extends JPanel {



    @Override
    public void paint(Graphics g) {
        g.drawImage(MaterialUtils.getBackgroundImage(), 0, 0, null); // 画背景图
        paintHero(g); // 画英雄机
    }

    /** 画英雄机 */
    public void paintHero(Graphics g) {
        Fighter f = ContextHolder.getBean(Fighter.class);
        g.drawImage(f.getImage(), f.getX(), f.getY(), null);
    }

}
