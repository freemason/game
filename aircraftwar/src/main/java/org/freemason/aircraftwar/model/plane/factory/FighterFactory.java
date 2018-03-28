package org.freemason.aircraftwar.model.plane.factory;

import org.freemason.aircraftwar.model.plane.Fighter;
import org.freemason.aircraftwar.utils.MaterialUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class FighterFactory {


    private List<String> fighterNames = new ArrayList<String>(MaterialUtils.getAirplanes().keySet());

    abstract Fighter produce(String fighterName);

    public static void main(String[] args) {
    }


}
