package estoque.controle.ms.repository.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import estoque.controle.ms.entity.Empresa;
import estoque.controle.ms.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private EmpresaRepository empresaRepository = null;
    
    @PersistenceContext
    private EntityManager entityManager;

    EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
 	}
    
    
    public List<Empresa> getAll(){
    	return (List<Empresa>) empresaRepository.findAll();
    }
    
    @Override
    public Empresa getById(Integer idEmpresa) {
    	
    	try {    		
    		String sql = "select * from empresa where id = ?1";
    		Query query = entityManager.createNativeQuery(sql, Empresa.class);
    		Empresa empresa = (Empresa) query.setParameter(1, idEmpresa)
    										 .getSingleResult();
            return empresa;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			entityManager.close();
		}    	
    }

    @Override
    public Empresa save(Empresa empresa) {
        try {
        	return empresaRepository.save(empresa);			
		} catch (Exception e) {
			return null;
		}        
    }
    
    @Override
    public boolean delete(Integer idEmpresa) {
    	
    	try {
    		return empresaRepository.findById(idEmpresa)
    				.map(resultado -> {
    					empresaRepository.deleteById(idEmpresa);
    					return true;
    					}).orElse(false);
        	
		} catch (Exception e) {
			return false;
		}
    }
}