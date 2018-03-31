package org.freemason.aircraftwar.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FighterParamUtils {
    private static Properties fighterParam = new Properties();
    private static final String DEFAULT_FIGHTER_PARAM = "config/fighterparams.json";

    static {
        InputStream inputStream = null;
        try {
            inputStream = FighterParamUtils.class.getClassLoader().getResourceAsStream(DEFAULT_FIGHTER_PARAM);
            fighterParam.load(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            //ignore
        }
    }


    public static void main(String[] args) {
        System.out.println(fighterParam.getProperty("F14.speed"));
        System.out.println(fighterParam.getProperty("F14.damage"));
    }

}
