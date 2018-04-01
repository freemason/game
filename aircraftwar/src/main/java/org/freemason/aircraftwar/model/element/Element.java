package org.freemason.aircraftwar.model.element;



import org.freemason.aircraftwar.ContextHolder;
import org.freemason.aircraftwar.container.ElementContainer;
import org.freemason.aircraftwar.container.JPanelElementContainer;

import java.awt.image.BufferedImage;

/**
 * JFrame 中展示的顶级抽象基类
 * @see org.freemason.aircraftwar.model.plane.Plane
 * @see org.freemason.aircraftwar.model.weapon.bullet.Bullet
 */
public abstract class Element {

    //横纵坐标位置
    private int X;
    private int Y;

    //宽高
    private final int width;
    private final int height;

    //图像模型
    private final BufferedImage image;

    //元素容器
    protected JPanelElementContainer container = ContextHolder.getBean(JPanelElementContainer.class);

    //越界
    protected abstract void outOfBounds();

    //加入容器
    protected abstract void join();

    protected Element(int X, int Y, BufferedImage image){
        this.X = X;
        this.Y = Y;
        this.image = image;
        this.height = image.getHeight();
        this.width = image.getWidth();
        join();
    }
    //getters and setters
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
