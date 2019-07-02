package br.com.schumaker.reflection.api.old;

/**
 *
 * @author hudson schumaker
 */
public class Reflexao {

    public ClassMaker refleteClasse(String fqn) {
        try {
            Class<?> classe = Class.forName(fqn);
            return new ClassMaker(classe);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
