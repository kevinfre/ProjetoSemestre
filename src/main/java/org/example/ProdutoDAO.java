package org.example;

import java.util.List;

public interface ProdutoDAO {
    boolean createProduto(Produto produto);
    List<Produto> read ();
    boolean update(Produto produto);
    boolean delete(Produto produto);
}
