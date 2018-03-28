package org.freemason.aircraftwar.container;

import org.freemason.aircraftwar.model.element.Element;

import java.util.LinkedList;
import java.util.List;

public abstract class Container {

    private final int height;
    private final int width;

    private List<Element> elementList = new LinkedList<Element>();

    protected Container(int height, int width) {
        this.height = height;
        this.width = width;
    }


    public void join(Element e){
        elementList.add(e);
    }
    public void drop(Element e){
        elementList.remove(e);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Element> getElementList() {
        return elementList;
    }
}
