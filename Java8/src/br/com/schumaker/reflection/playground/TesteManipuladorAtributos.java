package br.com.schumaker.reflection.playground;

import java.lang.reflect.Field;

/**
 *
 * @author hudson schumaker
 */
public class TesteManipuladorAtributos {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Object produto = new Produto("Produto 1", 20.0, "Marca 1");
        Class<?> classe = produto.getClass();

        //System.out.println(classe.getField("id"));
        //<produto>
        //  <nome>Produto 1</nome>
        //  <valor>20.0</valor>
        //  <marca>Marca 1</marca>
        //</produto>
        for (Field atributo : classe.getDeclaredFields()) {
            atributo.setAccessible(true);
            System.out.println(atributo.getName() + ": " + atributo.get(produto));
        }
    }
}
