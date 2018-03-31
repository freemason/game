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
    public void outOfBounds() {

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

        super.move(direction);
    }
}
