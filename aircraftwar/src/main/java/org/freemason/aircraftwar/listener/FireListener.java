package org.freemason.aircraftwar.listener;


import org.freemason.aircraftwar.ContextHolder;
import org.freemason.aircraftwar.container.JPanelElementContainer;
import org.freemason.aircraftwar.model.plane.Fighter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class FireListener extends KeyAdapter{
    private Fighter f = ContextHolder.getBean(Fighter.class);
    private ExecutorService executorService = ContextHolder.getBean(ExecutorService.class);
    private JPanelElementContainer jPanelElementContainer = ContextHolder.getBean(JPanelElementContainer.class);
    private volatile boolean fireDown = false;
    private static AtomicBoolean firing = new AtomicBoolean(false);
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode != 74){
            return;
        }
        fireDown = true;

        if (firing.get()){
            return;
        }

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (fireDown){
                    firing.set(true);
                    f.fire();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                firing.set(false);
            }
        });
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode != 74){
            return;
        }
        fireDown = false;
        /*fireDown = false;
        if (firing.get()){
            return;
        }*/
    }
}
