package estoque.controle.ms.repository.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import estoque.controle.ms.entity.Empresa;

public interface EmpresaService {

	Empresa getById(Integer idEmpresa);	
    Empresa save(Empresa empresa);
    boolean delete(Integer idEmpresa);
    
    @Cacheable(value = "empresa")
    List<Empresa> getAll();
}