package org.freemason.aircraftwar.drive;

import org.freemason.aircraftwar.model.weapon.bullet.Bullet;

/**
 * 飞行指令
 */
public interface FlightCommand {
    //方向移动
    void drive(int direction);
    //开火
    Bullet fire();
}
