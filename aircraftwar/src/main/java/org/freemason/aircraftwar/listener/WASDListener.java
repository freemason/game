package org.freemason.aircraftwar.listener;

import org.freemason.aircraftwar.ContextHolder;
import org.freemason.aircraftwar.container.Temp;
import org.freemason.aircraftwar.model.plane.Fighter;
import org.freemason.aircraftwar.utils.MaterialUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class WASDListener extends KeyAdapter {
    private AtomicBoolean drawing = new AtomicBoolean(false);

    private Temp t = ContextHolder.getBean(Temp.class);
    private Fighter f = ContextHolder.getBean(Fighter.class);
    private Graphics graphics = MaterialUtils.getBackgroundImage().getGraphics();
    private ExecutorService executorService = ContextHolder.getBean(ExecutorService.class);

    private static volatile int fighterDirection = 0;

    private boolean WDOWN = false;
    private boolean ADOWN = false;
    private boolean SDOWN = false;
    private boolean DDOWN = false;

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode != 87 &&keyCode != 83&&keyCode != 65&&keyCode != 68){
            return;
        }

        updateKeyState(e.getKeyCode(), true);
        ContextHolder.setFighterDirection(getPressedKey());
        fighterDirection = getPressedKey();

        f.move(fighterDirection);

    }

    public void keyReleased(KeyEvent e) {
        updateKeyState(e.getKeyCode(), false);
        ContextHolder.setFighterDirection(getPressedKey());
        fighterDirection = getPressedKey();

    }

    private void updateKeyState(int keyCode, boolean down) {
        switch (keyCode) {
            case 87:
                WDOWN = down;
                break;
            case 83:
                SDOWN = down;
                break;
            case 65:
                ADOWN = down;
                break;
            case 68:
                DDOWN = down;
                break;
        }
    }


    private int getPressedKey() {
        int r = 0;
        //按住上下  和  左右其中一个
        if (WDOWN && SDOWN) {
            if (ADOWN && !DDOWN) {
                return 65;
            }
            if (!ADOWN && DDOWN) {
                return 68;
            }
            return r;
        }
        //按住左右  和  上下其中一个
        if (ADOWN && DDOWN) {
            if (WDOWN) {
                return 87;
            }
            if (SDOWN) {
                return 83;
            }
            return r;
        }
        r = 1;
        if (WDOWN) {
            r *= 87;
        }
        if (ADOWN) {
            r *= 65;
        }
        if (SDOWN) {
            r *= 83;
        }
        if (DDOWN) {
            r *= 68;
        }

        if (!WDOWN && !ADOWN && !SDOWN && !DDOWN) {
            //全部未按下
            return 0;
        }
        return r;
    }

   /* private void draw() {
        drawing.set(true);
        executorService.submit(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                drawing.set(false);
            }
        });
    }*/

}
