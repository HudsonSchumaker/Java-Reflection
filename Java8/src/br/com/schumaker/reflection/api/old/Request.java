package br.com.schumaker.reflection.api.old;

import br.com.schumaker.reflection.api.old.QueryParamsBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hudson schumaker
 */
public class Request {

    private final String nomeControle;
    private final String nomeMetodo;
    private final Map<String, Object> queryParams;

    /*
     * Casos possíveis:
     * /controlador/metodo
     * /controlador/metodo?param1=valor1&param2=valor2
     */
    public Request(String url) {
        String[] partesUrl = url.replaceFirst("/", "").split("[?]");

        String[] controleEMetodo = partesUrl[0].split("/");

        nomeControle = Character.toUpperCase(controleEMetodo[0].charAt(0))
                + controleEMetodo[0].substring(1) + "Controller";

        nomeMetodo = controleEMetodo[1];

        queryParams = partesUrl.length > 1
                ? new QueryParamsBuilder().comParametros(partesUrl[1]).build()
                : new HashMap<String, Object>();
    }

    public String getNomeControle() {
        return nomeControle;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }
}