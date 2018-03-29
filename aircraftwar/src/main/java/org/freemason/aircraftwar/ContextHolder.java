package org.freemason.aircraftwar;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContextHolder {

    private static Map<Class<?>, Object> beans = new ConcurrentHashMap<Class<?>, Object>();
    //战机飞行方向
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
    public static volatile int fighterDirection = 0;
    public static void setFighterDirection(int direction){
        fighterDirection = direction;
    }
    public static int getFighterDirection() {
        return fighterDirection;
    }

    public static <T> T registBean(Object object){
        return (T)beans.put(object.getClass(), object);
    }

    public static <T> T getBean(Class<T> beanType){
        for (Object obj : beans.values()) {
            if(beanType.isInstance(obj)){
                return (T)obj;
            }
        }
        return null;
    }
}
