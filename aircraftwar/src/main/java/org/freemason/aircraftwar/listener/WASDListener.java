package org.freemason.aircraftwar.listener;

import org.freemason.aircraftwar.ContextHolder;
import org.freemason.aircraftwar.container.Temp;
import org.freemason.aircraftwar.model.plane.Fighter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 */
public class WASDListener extends KeyAdapter {

    private Temp t = ContextHolder.getBean(Temp.class);
    private Fighter f = ContextHolder.getBean(Fighter.class);
    private ExecutorService executorService = ContextHolder.getBean(ExecutorService.class);

    private static volatile int fighterDirection = 0;
    private static AtomicBoolean flying = new AtomicBoolean(false);
    private boolean WDOWN = false;
    private boolean ADOWN = false;
    private boolean SDOWN = false;
    private boolean DDOWN = false;

    public void keyPressed(KeyEvent e) {

        //如果不是W A S D键 不做任何操作
        //----------------------
        int keyCode = e.getKeyCode();
        if (keyCode != 87 && keyCode != 83 && keyCode != 65 && keyCode != 68) {
            return;
        }
        //-------------------------
        //更新键位状态 按下的键位状态
        //-------------------------
        updateKeyState(e.getKeyCode(), true);
        //-------------------------
        modifyDirectionByPressedKey();

        if (flying.get()) {
            return;
        }

        //飞行动作交给线程池异步执行
        executorService.execute(new Runnable() {
            public void run() {
                fly();
            }
        });

        //ContextHolder.setFighterDirection(getPressedKey());
        // System.out.println(fighterDirection);
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode != 87 && keyCode != 83 && keyCode != 65 && keyCode != 68) {
            return;
        }

        updateKeyState(e.getKeyCode(), false);
        modifyDirectionByPressedKey();


        if (flying.get()) {
            return;
        }

        //飞行动作交给线程池异步执行
        executorService.execute(new Runnable() {
            public void run() {
                fly();
            }
        });

    }

    private void modifyDirectionByPressedKey() {
        fighterDirection = getPressedKey();
    }


    private void fly() {
        while (fighterDirection > 0) {
            flying.set(true);
            f.move(fighterDirection);
            t.repaint();
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flying.set(false);
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
            default:
                break;
        }
    }


    private int getPressedKey() {
        //同时按住左右时   如果再按下  上或者下
        if (ADOWN && DDOWN) {

            if (WDOWN || SDOWN) {
                if (WDOWN && !SDOWN) {
                    return 87;
                }
                if (!WDOWN) {
                    return 83;
                }
            } else {
                return 0;
            }
        }

        if (WDOWN && ADOWN) {
            return 5655;
        }
        if (WDOWN && DDOWN) {
            return 5916;
        }
        if (SDOWN && ADOWN) {
            return 5395;
        }
        if (SDOWN && DDOWN) {
            return 5644;
        }

        if (WDOWN) {
            return 87;
        }
        if (ADOWN) {
            return 65;
        }
        if (SDOWN) {
            return 83;
        }
        if (DDOWN) {
            return 68;
        }
        return 0;
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
