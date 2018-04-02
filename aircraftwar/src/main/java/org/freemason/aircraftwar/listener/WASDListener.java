package org.freemason.aircraftwar.listener;

import org.freemason.aircraftwar.ContextHolder;
import org.freemason.aircraftwar.container.JPanelElementContainer;
import org.freemason.aircraftwar.model.plane.Fighter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 */
public class WASDListener extends KeyAdapter {

    private JPanelElementContainer jPanelElementContainer = ContextHolder.getBean(JPanelElementContainer.class);
    private Fighter f = ContextHolder.getBean(Fighter.class);
    private ExecutorService executorService = ContextHolder.getBean(ExecutorService.class);

    private static volatile int fighterDirection = 0;
    private static AtomicBoolean flying = new AtomicBoolean(false);
    private boolean UPPRESSED = false;
    private boolean LEFTPRESSED = false;
    private boolean DOWNPRESSED = false;
    private boolean RIGHTPRESSED = false;

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
        executorService.execute(()->fly());

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
        executorService.execute(()->fly());
    }

    private void modifyDirectionByPressedKey() {
        fighterDirection = getPressedKey();
    }


    private void fly() {
        while (fighterDirection > 0) {
            flying.set(true);
            f.move(fighterDirection);
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
                UPPRESSED = down;
                break;
            case 83:
                DOWNPRESSED = down;
                break;
            case 65:
                LEFTPRESSED = down;
                break;
            case 68:
                RIGHTPRESSED = down;
                break;
            default:
                break;
        }
    }


    private int getPressedKey() {
        //同时按住左右时   如果再按下  上或者下
        if (LEFTPRESSED && RIGHTPRESSED) {
            if (UPPRESSED || DOWNPRESSED) {
                if (UPPRESSED && !DOWNPRESSED) {
                    return 87;
                }
                if (!UPPRESSED) {
                    return 83;
                }
            } else {
                return 0;
            }
        }

        if (UPPRESSED && LEFTPRESSED) {
            return 5655;
        }
        if (UPPRESSED && RIGHTPRESSED) {
            return 5916;
        }
        if (DOWNPRESSED && LEFTPRESSED) {
            return 5395;
        }
        if (DOWNPRESSED && RIGHTPRESSED) {
            return 5644;
        }
        if (UPPRESSED) {
            return 87;
        }
        if (LEFTPRESSED) {
            return 65;
        }
        if (DOWNPRESSED) {
            return 83;
        }
        if (RIGHTPRESSED) {
            return 68;
        }
        return 0;
    }
}
