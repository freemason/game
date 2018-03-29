package org.freemason.aircraftwar.model.element;

import org.freemason.aircraftwar.Game;
import org.freemason.aircraftwar.container.Container;

import java.awt.image.BufferedImage;

public abstract class Element {
    //所处容器

    //横纵坐标位置
    private int X;
    private int Y;

    //宽高
    private final int width;
    private final int height;

    //图像模型
    private final BufferedImage image;


    protected Element(int X, int Y, BufferedImage image){
        this.X = X;
        this.Y = Y;
        this.image = image;
        this.height = image.getHeight();
        this.width = image.getWidth();
    }

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

    public int getHeight() {
        return height;
    }

    public BufferedImage getImage() {
        return image;
    }


}
