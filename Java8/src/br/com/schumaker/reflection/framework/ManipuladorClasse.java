package br.com.schumaker.reflection.framework;

import java.lang.reflect.Constructor;

/**
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ManipuladorClasse {

    private final Class<?> classe;

    public ManipuladorClasse(Class<?> classe) {
        this.classe = classe;
    }

    public ManipuladorConstrutor getConstrutorPadrao() {
        try {
            Constructor<?> construtorPadrao = classe.getDeclaredConstructor();
            return new ManipuladorConstrutor(construtorPadrao);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public ManipuladorObjeto criaInstancia() {
        Object instancia = getConstrutorPadrao().invoca();
        return new ManipuladorObjeto(instancia);
    }
}
