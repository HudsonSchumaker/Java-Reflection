package br.com.schumaker.reflection.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ManipuladorMetodo {

    private final Object instancia;
    private final Method metodo;
    private final Map<String, Object> params;
    private BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao;

    public ManipuladorMetodo(Object instancia, Method metodo, Map<String, Object> params) {
        this.instancia = instancia;
        this.metodo = metodo;
        this.params = params;
    }
    
    public ManipuladorMetodo comTratamentoDeExcecao(BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao) {
        this.tratamentoExcecao = tratamentoExcecao;
        return this;
    }

    public Object invoca() {
        try {
            List<Object> parametros = new ArrayList<>();
            Stream.of(metodo.getParameters())
                    .forEach(p -> parametros.add(params.get(p.getName())));

            return metodo.invoke(instancia, parametros.toArray());
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
             if (tratamentoExcecao != null) {
                return tratamentoExcecao.apply(metodo, e);
            }
            throw new RuntimeException("Erro dentro do método!", e);
        }
    }
}
