package br.com.schumaker.reflection.playground;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author hudson schumaker
 */
public class TesteInvocaMetodoSemParametro {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> subControleClasse
                = Class.forName("br.com.schumaker.reflection.playground.SubControle");

        for (Method m : subControleClasse.getMethods()) {
            //System.out.println(m);
        }

        for (Method m : subControleClasse.getDeclaredMethods()) {
            System.out.println(m);
        }

        Constructor<?> construtorPadrao = subControleClasse.getDeclaredConstructor();
        construtorPadrao.setAccessible(true);
        Object subControle = construtorPadrao.newInstance();

        Method m = subControleClasse.getDeclaredMethod("metodoSubControle2");
        m.setAccessible(true);
        Object retorno = m.invoke(subControle);

        System.out.println(retorno);

    }
}
