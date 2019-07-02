package br.com.schumaker.reflection.playground;

/**
 *
 * @author hudson schumaker
 */
public class SubControle extends Controle {
    
    public SubControle() {}
    
    public SubControle(String s, int i) {}

    private SubControle(String s) {
        System.out.println(s);
    }
    
    public void metodoSubControle1() {
        System.out.println("Executando método SubControle.metodoSubControle1()");
    }

    private String metodoSubControle2() {
        System.out.println("Executando método SubControle.metodoSubControle2()");
        return "retorno do método SubControle.metodoSubControle2()";
    }
}
