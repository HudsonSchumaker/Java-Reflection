package br.com.schumaker.reflection.api.dao;

import br.com.schumaker.reflection.api.modelo.Produto;
import java.util.List;

/**
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface ProdutoDao {

    public List<Produto> lista();
    public Produto getProduto(Integer id);
}
