package estoque.controle.ms.repository.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import estoque.controle.ms.dict.SituacaoTransacao;
import estoque.controle.ms.entity.Estoque;
import estoque.controle.ms.entity.Transacao;
import estoque.controle.ms.repository.TransacaoRepository;

@Service
public class TransacaoServiceImpl implements TransacaoService {

	private TransacaoRepository transacaoRepository = null;
    
    @PersistenceContext
    private EntityManager entityManager;

    TransacaoServiceImpl(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
 	}
    
    
    public List<Transacao> getAll(){
    	return (List<Transacao>) transacaoRepository.findAll();
    }
    
    @Override
    public Transacao getById(Integer idTransacao) {
    	
    	try {    		
    		String sql = "select * from empresa where id = ?1";
    		Query query = entityManager.createNativeQuery(sql, Transacao.class);
    		Transacao transacao = (Transacao) query.setParameter(1, idTransacao)
    										 .getSingleResult();
            return transacao;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			entityManager.close();
		}    	
    }

    @Override
    public Transacao save(Transacao transacao) throws Exception {
    	if(transacao != null && transacao.getId() == null) {
    		
    		//Boolean baixou = baixarEstoque(transacao);
    		//resolver problema de update :(
    		if(true)
    			return transacaoRepository.save(transacao);
    		else
    			throw new Exception("Estoque não tem quantidade para venda");
    	}else {
    		Transacao transacaoExistente = getById(transacao.getId());
    		if(transacaoExistente.getSituacao().equals(SituacaoTransacao.PENDENTE)) {
    			return transacaoRepository.save(transacao);
    		}else {
    			throw new Exception("Transacao precisa estar PENDENTE para ser alterada"); 
    		}
    	}		
		       
    }
    
    @Override
	public Boolean baixarEstoque(Transacao transacao) {
		try {    		
    		String sql = "select * from estoque where id = ?1";
    		Query query = entityManager.createNativeQuery(sql, Estoque.class);
    		Estoque estoque = (Estoque) query.setParameter(1, transacao.getEstoque().getId())
    										 .getSingleResult();
            
			if(estoque.getQuantidade() < transacao.getQuantidade()) {
				return false;
			}else {
				Integer novaQuantidade = estoque.getQuantidade() - transacao.getQuantidade();
				String update = "update estoque set quantidade = ?1 where id = ?2";
				int query2 =  entityManager.createNativeQuery(update, Estoque.class)
					.setParameter(1, novaQuantidade)
					.setParameter(2, estoque.getId())
					.executeUpdate();
				
				return true;
			}
    		
		} catch (Exception e) {
			return null;
			
		} finally {
			entityManager.close();
		}    	
	}


	@Override
    public boolean delete(Integer idTransacao) {
    	
    	try {
    		return transacaoRepository.findById(idTransacao)
    				.map(resultado -> {
    					transacaoRepository.deleteById(idTransacao);
    					return true;
    					}).orElse(false);
        	
		} catch (Exception e) {
			return false;
		}
    }
}