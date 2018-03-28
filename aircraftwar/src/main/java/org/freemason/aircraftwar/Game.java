package org.freemason.aircraftwar;

import org.freemason.aircraftwar.container.Container;
import org.freemason.aircraftwar.listener.KeyBoardListener;
import org.freemason.aircraftwar.utils.MaterialUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Hello world!
 */
public class Game {

    public static Container container = null;// new GlobalContainer(800, 600);

    private static ExecutorService executorService = Executors.newCachedThreadPool();


    /*for (int i = 0; i < bufferedImages.size(); i++){
        executorService.execute(new DrawTask(g,bufferedImages.get(i),616/bufferedImages.size()*i,839/bufferedImages.size()*i));
    }*/

    public static void main(String[] args) {
        JFrame frame = new JFrame("百分点飞机大战");
        JPanel p = new JPanel(){
            @Override
            public void paint(Graphics g) {
                g.drawImage(MaterialUtils.getBackgroundImage(),0,0,null);
                Image fighter = MaterialUtils.getPlaneImage("F22");
                g.drawImage(fighter,270,720,null);
            }
        };
        p.paint(MaterialUtils.getBackgroundImage().getGraphics());

        frame.add(p); // 将面板添加到JFrame中
        frame.setSize(616, 839); // 设置大小
        frame.setAlwaysOnTop(true); // 设置其总在最上
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 默认关闭操作
        frame.setLocationRelativeTo(null); // 设置窗体初始位置
        frame.setVisible(true); // 尽快调用paint
        frame.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                System.out.println(e);
            }

            public void keyReleased(KeyEvent e) {

            }
        });

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
