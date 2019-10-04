package estoque.controle.ms.repository.service;

import java.util.List;

import estoque.controle.ms.entity.Estoque;

public interface EstoqueService {

	Estoque getById(Integer idEstoque);	
    Estoque save(Estoque estoque);
    boolean delete(Estoque estoque);
    
    List<Estoque> getAll();
	List<Estoque> getEstoquePorEmpresaId(Integer idEmpresa);
	List<Estoque> getEstoquePorProdutoId(Integer idProduto);    
	List<Estoque> getEstoquePorEmpresaProduto(Integer idProduto, Integer idEmpresa);
	
}
