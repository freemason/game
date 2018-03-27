package org.freemason.aircraftwar.model;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
    //横纵坐标位置
    private int X;
    private int Y;

    //宽高
    private int width;
    private int height;

    //图像模型
    private BufferedImage image;

    //移动
    public abstract void move();

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
