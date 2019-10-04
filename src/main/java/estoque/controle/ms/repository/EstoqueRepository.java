package estoque.controle.ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import estoque.controle.ms.entity.Estoque;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Integer> {}
