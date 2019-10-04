package estoque.controle.ms.repository.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import estoque.controle.ms.entity.Transacao;

public interface TransacaoService {

	Transacao getById(Integer idEmpresa);	
	Transacao save(Transacao empresa) throws Exception;
    boolean delete(Integer idEmpresa);
    Boolean baixarEstoque(Transacao transacao);
    
    @Cacheable(value = "transacao")
    List<Transacao> getAll();
}