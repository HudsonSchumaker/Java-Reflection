package br.com.schumaker.reflection.framework.protocolo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hudson schumaker
 */
public class QueryParamsBuilder {

    private final Map<String, Object> queryParams = new HashMap<>();

    public QueryParamsBuilder comParametros(String stringQueryParams) {
        String[] stringParams = stringQueryParams.split("&");

        for (String stringParam : stringParams) {
            String[] chaveEValor = stringParam.split("=");

            String chave = chaveEValor[0];
            Object valor = chaveEValor[1];

            queryParams.put(chave, valor);
        }
        return this;
    }

    public Map<String, Object> build() {
        return this.queryParams;
    }
}
