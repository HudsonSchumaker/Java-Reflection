package br.com.schumaker.reflection.api.dao;

import br.com.schumaker.reflection.api.modelo.Produto;
import java.util.Arrays;
import java.util.List;

public class ProdutoDaoMock implements ProdutoDao {

    private static final List<Produto> LISTA_PRODUTO
            = Arrays.asList(new Produto("Produto 1", 20.0, "Marca 1"),
                    new Produto("Produto 2", 30.0, "Marca 1"),
                    new Produto("Produto 3", 40.0, "Marca 2"));

    @Override
    public List<Produto> lista() {
        return LISTA_PRODUTO;
    }

    @Override
    public Produto getProduto(Integer id) {
        return LISTA_PRODUTO.get(id);
    }
}
