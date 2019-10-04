package estoque.controle.ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import estoque.controle.ms.entity.emecMemoriaCalculo;

@Repository
public interface MemoriaCalculoRepository extends CrudRepository<emecMemoriaCalculo, Long> {}
