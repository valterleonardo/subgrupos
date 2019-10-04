package estoque.controle.ms.repository.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import estoque.controle.ms.entity.Produto;
import estoque.controle.ms.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository = null;
    
    @PersistenceContext
    private EntityManager entityManager;

    ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
 	}
    
    
    public List<Produto> getAll(){
    	return (List<Produto>) produtoRepository.findAll();
    }
    
    @Override
    public Produto getById(Integer idProduto) {
    	
    	try {    		
    		String sql = "select * from produto where id = ?1";
    		Query query = entityManager.createNativeQuery(sql, Produto.class);
    		Produto produto = (Produto) query.setParameter(1, idProduto)
    										 .getSingleResult();
            return produto;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			entityManager.close();
		}    	
    }

    @Override
    public Produto save(Produto produto) {
        try {
        	return produtoRepository.save(produto);			
		} catch (Exception e) {
			return null;
		}        
    }
    
    @Override
    public boolean delete(Integer idProduto) {
    	
    	try {
    		return produtoRepository.findById(idProduto)
    				.map(resultado -> {
    					produtoRepository.deleteById(idProduto);
    					return true;
    					}).orElse(false);
        	
		} catch (Exception e) {
			return false;
		}
    }
}