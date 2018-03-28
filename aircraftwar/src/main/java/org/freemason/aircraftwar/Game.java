package org.freemason.aircraftwar;

import org.freemason.aircraftwar.container.Container;
import org.freemason.aircraftwar.utils.MaterialUtils;

import javax.swing.*;
import java.awt.*;
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("飞机大战");
        JPanel p = new JPanel(){
            @Override
            public void paint(Graphics g) {
                g.drawImage(MaterialUtils.getBackgroundImage(),0,0,null);

                List<BufferedImage> bufferedImages = new ArrayList<BufferedImage>(MaterialUtils.getAirplanes().values());
                for (int i = 0; i < bufferedImages.size(); i++){
                    executorService.execute(new DrawTask(g,bufferedImages.get(i),616/bufferedImages.size()*i,839/bufferedImages.size()*i));
                }
            }
        };

        p.paint(MaterialUtils.getBackgroundImage().getGraphics());



        /*Image image=Toolkit.getDefaultToolkit().getImage("图片名.jpg");
        Graphics g = image.getGraphics();*/



        frame.add(p); // 将面板添加到JFrame中
        frame.setSize(616, 839); // 设置大小
        frame.setAlwaysOnTop(true); // 设置其总在最上
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 默认关闭操作
        frame.setIconImage(new ImageIcon("images/icon.jpg").getImage()); // 设置窗体的图标
        frame.setLocationRelativeTo(null); // 设置窗体初始位置
        frame.setVisible(true); // 尽快调用paint
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
