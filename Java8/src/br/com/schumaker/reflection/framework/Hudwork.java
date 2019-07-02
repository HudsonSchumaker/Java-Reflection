package br.com.schumaker.reflection.framework;

import br.com.schumaker.reflection.framework.protocolo.Request;
import java.util.Map;

/**
 *
 * @author hudson schumaker
 */
public class Hudwork {

    private final String pacoteBase;
    private final ContainerIoC container;

    public Hudwork(String pacoteBase) {
        this.pacoteBase = pacoteBase;
        this.container = new ContainerIoC();
    }

    public Object executa(String url) {
        // TODO - processa a requisicao executando o metodo
        // da classe em questao
        // Produto lista
        // produto -> roduto
        Request request = new Request(url);

        String nomeControle = request.getNomeControle();
        String nomeMetodo = request.getNomeMetodo();
        Map<String, Object> params = request.getQueryParams();

//        Object retorno = new Reflexao()
//                .refleteClasse(pacoteBase + nomeControle)
//                .criaInstancia()
//                .getMetodo(nomeMetodo, params)
//                .comTratamentoDeExcecao((metodo, e) -> {
//                    System.out.println("Erro no método " + metodo.getName() 
//                        + " da classe " + metodo.getDeclaringClass().getName() + ".\n\n");
//                    throw new RuntimeException("ERRO!"); //e.getTargetException();
//                })
//                .invoca();
        Class<?> classeControle = new Reflexao().getClasse(pacoteBase + nomeControle);
        Object instanciaControle = container.getInstancia(classeControle);
        Object retorno = new ManipuladorObjeto(instanciaControle)
                .getMetodo(nomeMetodo, params)
                .comTratamentoDeExcecao((metodo, ex) -> {
                    System.out.println("Erro no método " + metodo.getName() + " da classe "
                            + metodo.getDeclaringClass().getName() + ".\n\n");
                    throw new RuntimeException("Erro no método!");
                }).invoca();

        System.out.println(retorno);
        retorno = new ConversorXML().converte(retorno);
        return retorno;
    }

    public <S, D extends S> void registra(Class<S> tipoFonte, Class<D> tipoDestino) {
        container.registra(tipoFonte, tipoDestino);
    }
}
