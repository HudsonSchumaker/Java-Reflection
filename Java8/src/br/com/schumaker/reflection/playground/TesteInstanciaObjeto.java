package br.com.schumaker.reflection.playground;

/**
 *
 * @author hudson schumaker
 */
public class TesteInstanciaObjeto {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<Controle> controleClasse1 = Controle.class;

        SubControle subControle = new SubControle();
        Class<? extends Controle> controleClasse2 = subControle.getClass();

        Controle controle = new Controle();
        Class<? extends Controle> controleClasse3 = controle.getClass();

        Class<?> controleClasse4
                = Class.forName("br.com.schumaker.reflection.playground.Controle");

        Object objetoControle = controleClasse1.newInstance();
        System.out.println(objetoControle instanceof Controle);
        
        Object objetoControle2 =controleClasse4.newInstance();
        System.out.println(objetoControle2 instanceof Controle);
        
    }
}
