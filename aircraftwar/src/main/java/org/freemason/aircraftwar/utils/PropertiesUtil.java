package org.freemason.aircraftwar.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PropertiesUtil {
    private static boolean initialized = false;

    private static JSONObject properties;

    public synchronized static void load() throws IOException {
        if (initialized){
            return;
        }
        initialized = true;
        InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("config/enviroment.json");
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        properties = JSON.parseObject(CharStreams.toString(reader));
        reader.close();
        inputStream.close();
    }

    public static JSONObject getProperties() {
        if (!initialized){
            throw new NullPointerException("properties was not initialized yet!");
        }
        return properties;
    }

}
