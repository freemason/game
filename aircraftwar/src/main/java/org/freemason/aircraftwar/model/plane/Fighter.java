package org.freemason.aircraftwar.model.plane;

import org.freemason.aircraftwar.model.weapon.Weapon;
import org.freemason.aircraftwar.model.weapon.bullet.Bullet;
import org.freemason.aircraftwar.utils.MaterialUtils;

public class Fighter extends Plane{

    public Fighter(int X, int Y, String fighterName, int health, int speed, Weapon...weapon) {
        super(X, Y, MaterialUtils.getPlaneImage(fighterName), health, speed,weapon);
    }

    public void setWeapon(Weapon...weapon){
        super.setWeapon(weapon);
    }

    @Override
    public void shot(Bullet bullet) {
        setCurrentHealth(getCurrentHealth() - bullet.getDamage());
        if(getCurrentHealth() <= 0){
            destroy();
        }
    }
    @Override
    public Bullet fire() {
        for (Weapon w : getWeapon()){
            w.launch();
        }
        return null;
    }

    @Override
    protected void outOfBounds() {
        throw new UnsupportedOperationException("fighter does not support out of bounds");
    }

    @Override
    protected void join() {
    }

    @Override
    public void destroy() {

    }

    @Override
    public void move(int direction) {
        /*if (getX() <= 0 || getX() + getWidth() >= container.getWidth() || getY() <=0 || getY() + getWidth() >= container.getHeight()){
            return;
        }*/
        /* d→    a←   w↑   s↓
         * ↑        87
         * ←        65
         * ↓        83
         * →        68
         * ←↑       5655
         * ↑→       5916
         * ←↓       5395
         * ↓→       5644
         */
        /*if (getX() <= 0 && (direction == 65 || direction == 5655 || direction ==) )*/
        //贴近左边界
        if (getX() <= 0){
            if (direction == 65){
                return;
            }
            if (direction == 5655){
                direction = 87;
            }
            if (direction == 5395){
                direction = 83;
            }
        }
        //贴近右边界
        if (getX() + getWidth() >= container.getWidth()){
            if (direction == 68){
                return;
            }
            if (direction == 5916){
                direction = 87;
            }
            if (direction == 5644){
                direction = 83;
            }
        }
        //下边界
        if (getY() + getHeight() > container.getHeight()){
            if (direction == 83){
                return;
            }
            if (direction == 5395){
                direction = 65;
            }
            if (direction == 5644){
                direction = 68;
            }
        }
        //上边界
        if(getY() <= 0){
            if (direction == 87){
                return;
            }
            if (direction == 5655){
                direction = 65;
            }
            if (direction == 5916){
                direction = 68;
            }
        }
        super.move(direction);
    }
}
