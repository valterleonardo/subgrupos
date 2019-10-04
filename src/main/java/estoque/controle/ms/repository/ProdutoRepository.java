package estoque.controle.ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import estoque.controle.ms.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {}
