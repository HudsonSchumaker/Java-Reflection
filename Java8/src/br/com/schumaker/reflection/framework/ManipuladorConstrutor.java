package br.com.schumaker.reflection.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author hudson schumaker
 */
public class ManipuladorConstrutor {

    private final Constructor<?> construtor;

    public ManipuladorConstrutor(Constructor<?> construtor) {
        this.construtor = construtor;
    }

    public Object invoca() {
        try {
            return construtor.newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
            return new RuntimeException(e);
        } catch (InvocationTargetException e) {
            return new RuntimeException("Erro no construtor!", e.getTargetException());
        }
    }
}
