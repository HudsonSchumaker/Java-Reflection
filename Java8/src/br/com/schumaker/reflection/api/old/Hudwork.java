package br.com.schumaker.reflection.api.old;

import br.com.schumaker.reflection.api.controle.ProdutoController;
import java.util.Map;

/**
 *
 * @author hudson schumaker
 */
public class Hudwork {

    private final String pacoteBase;

    public Hudwork(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        Request request = new Request(url);
        String nomeControle = request.getNomeControle();
        String nomeMetodo = request.getNomeMetodo();
        Map<String, Object> params = request.getQueryParams();

        Object controller = new Reflexao()
                .refleteClasse(pacoteBase + nomeControle)
                .getConstructor()
                .invoke();

        System.out.println(controller instanceof ProdutoController);

        return null;
    }
}
