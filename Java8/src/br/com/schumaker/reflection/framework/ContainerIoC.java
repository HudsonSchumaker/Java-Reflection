package br.com.schumaker.reflection.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ContainerIoC {
    
    private final Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();

    public Object getInstancia(Class<?> tipoFonte) {
        Stream<Constructor<?>> construtores
                = Stream.of(tipoFonte.getDeclaredConstructors());

        Optional<Constructor<?>> construtorPadrao
                = construtores.filter(construtor -> construtor.getParameterCount() == 0)
                .findFirst();

        try {
            if (construtorPadrao.isPresent()) {
                Object instancia = construtorPadrao.get().newInstance();
                return instancia;
            } else {
                Constructor<?> construtor = tipoFonte.getDeclaredConstructors()[0];
                List<Object> params = new ArrayList<>();
                for (Parameter param : construtor.getParameters()) {
                    Class<?> tipoDoParametro = param.getType();
                    params.add(getInstancia(tipoDoParametro));
                }
                return construtor.newInstance(params.toArray());
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
        mapaDeTipos.put(tipoFonte, tipoDestino);
    }
}
