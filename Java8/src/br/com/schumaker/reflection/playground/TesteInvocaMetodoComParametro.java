package br.com.schumaker.reflection.playground;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author hudson schumaker
 */
public class TesteInvocaMetodoComParametro {
    
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
         Class<?> controleClasse =
                Class.forName("br.com.schumaker.reflection.playground.Controle");

        Constructor<?> construtorPadrao = controleClasse.getDeclaredConstructor();

        Object controle = construtorPadrao.newInstance();

        Method m = controleClasse.getDeclaredMethod("metodoControle2", String.class);

        Object retorno = m.invoke(controle, "string parametro");

        System.out.println(retorno);

    }
    
}
