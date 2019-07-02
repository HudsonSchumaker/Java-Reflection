package br.com.schumaker.reflection.api.old;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author hudsons chumaker
 */
public class ClassMaker {

    private final Class<?> clazz;
    private Constructor<?> constructor;
    private Method metodo;

    public ClassMaker(Class<?> clazz) {
        this.clazz = clazz;
    }

    public ClassMaker getConstructor() {
        try {
            constructor = clazz.getConstructor(); //clazz.getDeclaredConstructor();
            return this;
        } catch (NoSuchMethodException | SecurityException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ClassMaker getMethod() {
        return null;

    }

    public Object invoke() {
        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }
}
