package org.freemason.aircraftwar.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MaterialUtils {

    private static Map<String, BufferedImage> airplaneImages = new HashMap<String, BufferedImage>();
    private static BufferedImage bulletImage;

    private static final String DEFAULT_PLANE_MATERIAL_PATH = "material/fighter";
    private static final String DEFAULT_BULLET_MATERIAL_PATH = "material/bullet/bullet.png";

    static {
        URL url = MaterialUtils.class.getClassLoader().getResource(DEFAULT_PLANE_MATERIAL_PATH);
        File[] files = new File(url.getFile()).listFiles();
        for (File file : files) {
            try {
                airplaneImages.put(file.getName(), ImageIO.read(file));
            } catch (IOException e) {
                continue;
                //file has been checked,ignore IOException
            }
        }

        url = MaterialUtils.class.getClassLoader().getResource(DEFAULT_BULLET_MATERIAL_PATH);
        try {
            bulletImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getPlaneImage(String planeName){
        return airplaneImages.get(planeName);
    }

    public static Map<String, BufferedImage> getAirplanes() {
        return airplaneImages;
    }

    public static BufferedImage getBulletImage() {
        return bulletImage;
    }
}