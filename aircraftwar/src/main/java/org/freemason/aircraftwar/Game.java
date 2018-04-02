package org.freemason.aircraftwar;

import org.freemason.aircraftwar.container.Container;
import org.freemason.aircraftwar.container.JPanelElementContainer;
import org.freemason.aircraftwar.container.Temp;
import org.freemason.aircraftwar.listener.FireListener;
import org.freemason.aircraftwar.listener.WASDListener;
import org.freemason.aircraftwar.model.plane.Fighter;
import org.freemason.aircraftwar.model.weapon.FighterWeapon;
import org.freemason.aircraftwar.model.weapon.Weapon;
import org.freemason.aircraftwar.utils.MaterialUtils;
import org.freemason.aircraftwar.utils.PropertiesUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Hello world!
 */
public class Game {
    private static BufferedImage backgroundImage = MaterialUtils.getBackgroundImage();

    private static ExecutorService executorService = Executors.newCachedThreadPool();
    static {
        ContextHolder.registBean(executorService);
    }


    private static Fighter initFighter(){
        Fighter fighter = new Fighter(305,400,"F22",200,1);
        FighterWeapon fighterWeapon1 = new FighterWeapon(10,500,fighter, FighterWeapon.MountPosition.leftWing);
        FighterWeapon fighterWeapon2 = new FighterWeapon(10,500,fighter, FighterWeapon.MountPosition.rightWing);
        FighterWeapon fighterWeapon3 = new FighterWeapon(10,500,fighter, FighterWeapon.MountPosition.leftTip);
        FighterWeapon fighterWeapon4 = new FighterWeapon(10,500,fighter, FighterWeapon.MountPosition.rightTip);
        fighter.setWeapon(fighterWeapon1,fighterWeapon2,fighterWeapon3,fighterWeapon4);
        ContextHolder.registBean(fighter);
        return fighter;
    }


    public static void main(String[] args) throws IOException {
        PropertiesUtil.load();
        //新建一个java框框
        JFrame frame = new JFrame("百分点打飞机");

        //Temp t = new Temp();

        JPanelElementContainer jPanelElementContainer = new JPanelElementContainer();
        ContextHolder.registBean(jPanelElementContainer);
        jPanelElementContainer.setFighter(initFighter());
        frame.add(jPanelElementContainer); // 将面板添加到JFrame中
        frame.setSize(backgroundImage.getWidth() + 15, backgroundImage.getHeight() + 39); // 设置大小
        //frame.setAlwaysOnTop(true); // 设置其总在最上
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 默认关闭操作
        frame.setLocationRelativeTo(null); // 设置窗体初始位置
        frame.setVisible(true); // 尽快调用paint
       // frame.setResizable(false);//不能改变大小
        //frame.addKeyListener(new WASDListener());
        frame.addKeyListener(new WASDListener());
        frame.addKeyListener(new FireListener());
    }

}
