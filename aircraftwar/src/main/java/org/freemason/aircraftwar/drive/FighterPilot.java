package org.freemason.aircraftwar.drive;

import org.freemason.aircraftwar.model.plane.Fighter;

public class FighterPilot extends AbstractPilot {

    private final String politName;

    public FighterPilot(String name, Fighter fighter) {
        super(fighter);
        this.politName = name == null ? "老司机" : name;
    }

    public void bombard(){
        //需要飞机实现轰炸  并且记录次数
    }



}
