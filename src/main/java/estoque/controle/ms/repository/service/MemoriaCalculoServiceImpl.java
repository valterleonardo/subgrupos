package estoque.controle.ms.repository.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import estoque.controle.ms.entity.Empresa;
import estoque.controle.ms.entity.MemoriaVO;
import estoque.controle.ms.entity.emecGrupoMemoria;
import estoque.controle.ms.entity.emecMemoriaCalculo;
import estoque.controle.ms.repository.MemoriaCalculoRepository;

@Service
public class MemoriaCalculoServiceImpl implements MemoriaCalculoService {

    private MemoriaCalculoRepository memoriaCalculoRepository = null;
    
    @PersistenceContext
    private EntityManager entityManager;

    MemoriaCalculoServiceImpl(MemoriaCalculoRepository memoriaCalculoRepository) {
        this.memoriaCalculoRepository = memoriaCalculoRepository;
 	}

	@Override
	public emecMemoriaCalculo getMemorias(Integer id) {
		try {    		
    		String sql = "select * from emecmemoriacalculo where cdmemoriacalculo = ?1";
    		Query query = entityManager.createNativeQuery(sql, emecMemoriaCalculo.class);
    		emecMemoriaCalculo memoriaCalculo = (emecMemoriaCalculo) query.setParameter(1, id)
    										 					   .getSingleResult();
            return memoriaCalculo;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			entityManager.close();
		}    	
	}

	@Override
	public List<emecGrupoMemoria> getGrupoMemoria(Integer cdMemoriaCalculo) {
		try {    		
    		String sql = "select * from emecgrupomemoria where cdmemoriacalculo = ?1 and coalesce(cdpai,0) = 0";
    		Query query = entityManager.createNativeQuery(sql, emecGrupoMemoria.class);
    		List<emecGrupoMemoria> memoriaCalculo = (List<emecGrupoMemoria>) query.setParameter(1, cdMemoriaCalculo)
    										 					   .getResultList();
            return memoriaCalculo;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			entityManager.close();
		}    	
	}
	
	@Override
	public List<MemoriaVO> getGrupoMemoriaSql(Integer cdMemoriaCalculo) {
		try {    		
    		String sql = "select \n" + 
    				"	grupo.cdmemoriacalculo,\n" + 
    				"	grupo.cdgrupomemoria,\n" + 
    				"	grupo.degrupomemoria,\n" + 
    				"	grupo.cdordem,\n" + 
    				"	mc.cdtabela,\n" + 
    				"	'descricao da versao do orcamento' as  dememoria\n" + 
    				"from \n" + 
    				"	emecGrupoMemoria grupo\n" + 
    				"	join emecMemoriaCalculo mc on grupo.cdmemoriacalculo = mc.cdmemoriacalculo\n" + 
    				"where\n" + 
    				"	mc.cdtabela = ?1 \n" + 
    				"	and coalesce(grupo.cdpai,0) = 0";
    		Query query = entityManager.createNativeQuery(sql, MemoriaVO.class);
    		List<MemoriaVO> memoriaCalculo = (List<MemoriaVO>) query.setParameter(1, 5401001)
    										 					   .getResultList();
            return memoriaCalculo;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			entityManager.close();
		}    	
	}
    
}