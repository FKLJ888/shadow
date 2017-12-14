package dqh.project.hour.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by XP on 2017/11/3.
 */
public class CreateObjUtil {

    public static <T> T getT(Object o, int i) {
        try {
            ParameterizedType parameterizedType = (ParameterizedType) o.getClass().getGenericSuperclass();
            Class<T> clazz= (Class<T>) parameterizedType.getActualTypeArguments()[i];
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
