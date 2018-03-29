package org.freemason.aircraftwar.container;

import org.freemason.aircraftwar.ContextHolder;
import org.freemason.aircraftwar.model.plane.Fighter;
import org.freemason.aircraftwar.utils.MaterialUtils;
import sun.java2d.SunGraphics2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Temp extends JPanel {

    public Temp(){
    }
/*Random r = new Random();*/


    @Override
    public void paint(Graphics g) {
        g.drawImage(MaterialUtils.getBackgroundImage(), 0, 0, null); // 画背景图
        paintHero(g); // 画英雄机
    }

    /** 画英雄机 */
    public void paintHero(Graphics g) {
        Fighter f = ContextHolder.getBean(Fighter.class);
        long st = System.currentTimeMillis();
        g.drawImage(f.getImage(), f.getX(), f.getY(), null);
        System.out.println(System.currentTimeMillis() -st);
    }

}
