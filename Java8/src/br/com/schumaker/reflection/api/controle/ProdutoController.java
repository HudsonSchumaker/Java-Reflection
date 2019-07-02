package br.com.schumaker.reflection.api.controle;

import br.com.schumaker.reflection.api.dao.ProdutoDaoMock;
import br.com.schumaker.reflection.api.modelo.Produto;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoController {

    private final ProdutoDaoMock produtoDao;

    public ProdutoController() {
        produtoDao = new ProdutoDaoMock();
    }

    public List<Produto> lista() {
        return produtoDao.lista();
    }

    public List<Produto> filtra(String nome) {
        return produtoDao.lista().stream()
                .filter(produto -> produto.getNome().toLowerCase().startsWith(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Produto> filtra(String nome, String marca) {
        return produtoDao.lista().stream()
                .filter(produto
                        -> produto.getNome().toLowerCase().startsWith(nome.toLowerCase())
                        && produto.getMarca().equalsIgnoreCase(marca)
                )
                .collect(Collectors.toList());
    }
}
