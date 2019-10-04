package estoque.controle.ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import estoque.controle.ms.entity.Transacao;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Integer> {}
