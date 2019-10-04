package estoque.controle.ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import estoque.controle.ms.entity.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {}
