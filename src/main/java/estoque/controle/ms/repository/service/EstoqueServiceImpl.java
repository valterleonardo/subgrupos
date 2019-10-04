package estoque.controle.ms.repository.service;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import estoque.controle.ms.entity.Estoque;
import estoque.controle.ms.repository.EstoqueRepository;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    private EstoqueRepository estoqueRepository = null;
    
    @PersistenceContext
    private EntityManager entityManager;

    EstoqueServiceImpl(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
 	}
    
    
    public List<Estoque> getAll(){
    	return (List<Estoque>) estoqueRepository.findAll();
    }
    
    @Override
    public Estoque getById(Integer idEstoque) {
    	
    	try {    		
    		String sql = "select * from estoque where id = ?1";
    		Query query = entityManager.createNativeQuery(sql, Estoque.class);
    		Estoque estoque = (Estoque) query.setParameter(1, idEstoque)
    										 .getSingleResult();

            return estoque;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			entityManager.close();
		}    	
    }

    @Override
    public Estoque save(Estoque estoque) {
        return estoqueRepository.save(estoque);			
    }
    
    @Override
    public boolean delete(Estoque estoque) {
    	
    	try {
    		return estoqueRepository.findById(estoque.getId())
    				.map(resultado -> {
    					estoqueRepository.delete(estoque);;
    					return true;
    					}).orElse(false);
        	
		} catch (Exception e) {
			return false;
		}
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Estoque> getEstoquePorEmpresaId(Integer idEmpresa){
    	
    	try {
    		String sql = "select * from estoque where empresa_id = ?1";
    		Query query = entityManager.createNativeQuery(sql, Estoque.class);
			List<Estoque> resultList =  query.setParameter(1, idEmpresa)
											 .getResultList();
    		
    		return resultList;
			
		} catch (Exception e) {
			return Collections.emptyList();
		} finally {
			entityManager.close();
		}
    	
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Estoque> getEstoquePorProdutoId(Integer idProduto){
    	
    	try {
    		String sql = "select * from estoque where produto_id = ?1";
    		Query query = entityManager.createNativeQuery(sql, Estoque.class);
			List<Estoque> resultList =  query.setParameter(1, idProduto)
											 .getResultList();
    		
    		return resultList;
			
		} catch (Exception e) {
			return Collections.emptyList();
		} finally {
			entityManager.close();
		}
    	
    }


	@Override
	@SuppressWarnings("unchecked")
	public List<Estoque> getEstoquePorEmpresaProduto(Integer idEmpresa, Integer idProduto) {
		try {
    		String sql = "select * from estoque where produto_id = ?1 and empresa_id = ?2";
    		Query query = entityManager.createNativeQuery(sql, Estoque.class);
			List<Estoque> resultList =  query.setParameter(1, idProduto)
											 .setParameter(2, idEmpresa)
											 .getResultList();
    		
    		return resultList;
			
		} catch (Exception e) {
			return Collections.emptyList();
		} finally {
			entityManager.close();
		}
	}

}