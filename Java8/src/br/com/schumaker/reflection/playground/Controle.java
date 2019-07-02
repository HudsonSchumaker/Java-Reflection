package br.com.schumaker.reflection.playground;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hudson schumaker
 */
public class Controle {

    private final List<String> lista = Arrays.asList("item 1", "item 2", "item 3");

    public Controle() {
    }

    public Controle(String s) {
    }

    private Controle(String s, String t) {
    }

    public List<String> getLista() {
        return lista;
    }
    
    public void metodoControle2(String p1) {
        System.out.println("Controle.metodoControle2(String p1)");
        System.out.println("Parâmetro obtido: " + p1);

    }

    public void metodoControle2(String p1, String p2) {
        System.out.println("Controle.metodoControle2(String p1, String p2)");
        System.out.println("Parâmetro obtido p1: " + p1);
        System.out.println("Parâmetro obtido p2: " + p2);

    }

    public void metodoControle2(String p1, Integer p2) {
        System.out.println("Controle.metodoControle2(String p1, Integer p2)");
        System.out.println("Parâmetro obtido p1: " + p1);
        System.out.println("Parâmetro obtido p2: " + p2);

    }
}
