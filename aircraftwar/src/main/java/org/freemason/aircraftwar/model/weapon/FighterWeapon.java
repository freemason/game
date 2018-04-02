package org.freemason.aircraftwar.model.weapon;

import org.freemason.aircraftwar.model.weapon.bullet.Bullet;
import org.freemason.aircraftwar.model.plane.Fighter;
import org.freemason.aircraftwar.model.weapon.factory.MultiBulletFactory;
import org.freemason.aircraftwar.utils.MaterialUtils;

public class FighterWeapon extends Weapon{
    private MountPosition position;
    public FighterWeapon(int damage, long launchInterval, Fighter fighter,MountPosition position) {
        super(damage, launchInterval, fighter);

        if (position == null){
            throw new NullPointerException("mountposition must be specified!");
        }
        this.position = position;
    }

    private int[] locate(){
        switch (position){
            case leftTip:
                return new int[]{plane.getX(),plane.getY() + plane.getHeight()*3/4};
            case leftWing:
                return new int[]{plane.getX() + plane.getWidth()/4 - bulletImage.getWidth()/2, plane.getY() + plane.getHeight()*3/4};
            case rightWing:
                return new int[]{plane.getX() + plane.getWidth()*3/4 -4 , plane.getY() + plane.getHeight()*3/4};
            case rightTip:
                return new int[]{plane.getX() + plane.getWidth() - bulletImage.getWidth(), plane.getY() + plane.getHeight()*3/4};
            default:
                return new int[]{plane.getX() + plane.getWidth()/2, plane.getY() + plane.getHeight()/2};
        }
    }


    @Override
    public void reset() {

    }

    @Override
    public Bullet launch() {
        int[] xy = locate();
        return MultiBulletFactory.produceFighterBullet(xy[0], xy[1], getDamage());
    }

    public enum MountPosition{
        leftTip,
        leftWing,
        rightWing,
        rightTip
    }
}
