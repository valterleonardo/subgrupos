package estoque.controle.ms.repository.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import estoque.controle.ms.entity.Produto;

public interface ProdutoService {

	Produto getById(Integer idProduto);	
    Produto save(Produto produto);
    boolean delete(Integer idProduto);
   
    @Cacheable(value = "produto")
    List<Produto> getAll();	
}