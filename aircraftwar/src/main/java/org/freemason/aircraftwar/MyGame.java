package org.freemason.aircraftwar;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.*;

public class MyGame{

    /**

     * 在JFRame中加入JPanel，并在JPanel中实现动画

     */

    public static void main(String[] arg0){

        JFrame GFrame = new JFrame();	//创建窗口

        MyDrawPanel DPanel = new MyDrawPanel();	//创建画板

        /*设置JFrame*/

        GFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GFrame.setLocation(100, 20);

        GFrame.setSize(600, 600);

        GFrame.setVisible(true);

        GFrame.add(DPanel);	//在JFrame中加入DPanel

        DPanel.launchJPanel();

    }

}

class MyDrawPanel extends JPanel{

    int x=200, y=150,speed = 3;

    private double degree;

    public void launchJPanel(){

        new PaintThread ().start ();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Color c = g.getColor();

        g.setColor(Color.orange);

        g.fillOval(x, y, 40, 40);

        g.setColor(c);

        move();

    }

    public void move(){

        x += speed * Math.cos(degree);

        y += speed * Math.sin(degree);

        if((x < 0) || (x > 800 - 600/2)){

            degree = Math.PI - degree;

        }

        if((y < 30)||(y > 800-600/2)){

            degree = -degree;

        }

        degree += 0.1;

    }

    class PaintThread extends Thread{

        @Override

        public void run() {

// TODO Auto-generated method stub

            while(true){

                repaint();

                try {

                    Thread.sleep(5);

                } catch (InterruptedException e) {

// TODO Auto-generated catch block

                    e.printStackTrace();

                }

            }

        }

    }

}
