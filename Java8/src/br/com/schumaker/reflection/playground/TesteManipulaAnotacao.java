package br.com.schumaker.reflection.playground;

/**
 *
 * @author hudson schumaker
 */
public class TesteManipulaAnotacao {

    public static void main(String[] args) {
        Produto produto = new Produto("Produto 1", 20.0, "Marca 1");
        Class<?> classe = produto.getClass();

        System.out.println(classe.getDeclaredAnnotation(NomeTagXML.class).value());
    }

}
