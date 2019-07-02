package br.com.schumaker.reflection.playground;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author hudson schumaker
 */
public class TesteInstanciaObjetoCorretamente {

    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, 
            IllegalArgumentException, InvocationTargetException {
        
        
        Class<SubControle> subControleClasse1 = SubControle.class;

        Class<?> subControleClasse2
                = Class.forName("br.com.schumaker.reflection.playground.SubControle");

        Class<?> controleClasse1
                = Class.forName("br.com.schumaker.reflection.playground.Controle");

        Constructor<SubControle> subControleClasse1ConstrutorPublico = subControleClasse1.getConstructor();
        System.out.println(subControleClasse1ConstrutorPublico);

        Constructor<SubControle> subControleClasse1ConstrutorPublicoComArgumento
                = subControleClasse1.getConstructor(String.class, int.class);
        System.out.println(subControleClasse1ConstrutorPublicoComArgumento);
        
        Constructor<SubControle> subControleClasse1ConstrutorPrivado
                = subControleClasse1.getDeclaredConstructor(String.class);
        System.out.println(subControleClasse1ConstrutorPrivado);
        
        Constructor<?> construtorControle = subControleClasse2.getConstructor();
        System.out.println(construtorControle);
        
        subControleClasse1ConstrutorPrivado.setAccessible(true);
        Object subControleObject = subControleClasse1ConstrutorPrivado.newInstance("Argumento do construtor");
        if (subControleObject instanceof SubControle) {
            SubControle sub = (SubControle) subControleObject;
            System.out.println(sub.getLista());
        }
        
        
    }
}
