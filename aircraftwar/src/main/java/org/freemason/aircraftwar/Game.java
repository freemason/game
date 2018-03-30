package org.freemason.aircraftwar;

import org.freemason.aircraftwar.container.Container;
import org.freemason.aircraftwar.container.Temp;
import org.freemason.aircraftwar.listener.WASDListener;
import org.freemason.aircraftwar.model.plane.Fighter;
import org.freemason.aircraftwar.utils.MaterialUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Hello world!
 */
public class Game {

    public static Container container = null;// new GlobalContainer(800, 600);
    private static ExecutorService executorService = Executors.newCachedThreadPool();
private static int i = 0;
    private static BufferedImage background = MaterialUtils.getBackgroundImage();
    /*for (int i = 0; i < bufferedImages.size(); i++){
        executorService.execute(new DrawTask(g,bufferedImages.get(i),616/bufferedImages.size()*i,839/bufferedImages.size()*i));
    }*/
    private static Fighter fighter = new Fighter(300,400,"F22",200,3);
    static {
        ContextHolder.registBean(fighter);
        ContextHolder.registBean(executorService);
    }

    private static boolean Wpressed = false;

    private static boolean Apressed = false;

    private static boolean Spressed = false;

    private static boolean Dpressed = false;




    public static void main(String[] args) {
        //新建一个java框框
        JFrame frame = new JFrame("fighter");

        Temp t = new Temp();

        /*t.addKeyListener(new WASDListener());
        t.addKeyListener(new WASDListener());*/
       ContextHolder.registBean(t);
       frame.add(t); // 将面板添加到JFrame中
        frame.setSize(616, 839); // 设置大小
        //frame.setAlwaysOnTop(true); // 设置其总在最上
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 默认关闭操作
        frame.setLocationRelativeTo(null); // 设置窗体初始位置
        frame.setVisible(true); // 尽快调用paint
        //frame.addKeyListener(new WASDListener());
        frame.addKeyListener(new WASDListener());
    }


    static class DrawTask implements Runnable{
        private Graphics g;
        private BufferedImage image;
        private int X;
        private int Y;

        public DrawTask(Graphics g, BufferedImage image, int x, int y) {
            this.g = g;
            this.image = image;
            X = x;
            Y = y;
        }

        public void run() {
            g.drawImage(image,X,Y,null);
        }
    }

}
