package estoque.controle.ms.repository.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estoque.controle.ms.entity.FilhoVO;
import estoque.controle.ms.entity.MemoriaVO;
import estoque.controle.ms.entity.emecGrupoMemoria;
import estoque.controle.ms.entity.emecMemoriaCalculo;

@Service
public class MemoriaCalculoServiceImpl implements MemoriaCalculoService {
    
    @Autowired
    private EntityManagerFactory emf;

	@Override
	public emecMemoriaCalculo getMemorias(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		try {    		
    		String sql = "select * from emecmemoriacalculo where cdmemoriacalculo = ?1";
    		Query query = em.createNativeQuery(sql, emecMemoriaCalculo.class);
    		emecMemoriaCalculo memoriaCalculo = (emecMemoriaCalculo) query.setParameter(1, id)
    										 					   .getSingleResult();
            return memoriaCalculo;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			em.close();
		}    	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<emecGrupoMemoria> getGrupoMemoria(Integer cdMemoriaCalculo) {
		EntityManager em = emf.createEntityManager();
		
		try {    		
    		String sql = "select * from emecgrupomemoria where cdmemoriacalculo = ?1 and coalesce(cdpai,0) = 0";
    		Query query = em.createNativeQuery(sql, emecGrupoMemoria.class);
    		List<emecGrupoMemoria> memoriaCalculo = (List<emecGrupoMemoria>) query.setParameter(1, cdMemoriaCalculo)
    										 					   .getResultList();
            return memoriaCalculo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			em.close();
		}    	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FilhoVO> getSubGrupoServicoSql(Long cdMemoriaCalculo, Long cdGrupoMemoria) {
		EntityManager em = emf.createEntityManager();
		
		try {    		
    		String sql = " select " + 
    				"	gm.cdgrupomemoria as id, " + 
    				"	gm.degrupomemoria as descricao, " + 
    				"	gm.cdordem as ordem, " + 
    				"	'SUBGRUPO' as tipo, " + 
    				"	null as quantidade, " + 
    				"	null as unidade " + 
    				" from " + 
    				"	emecGrupoMemoria gm " + 
    				" where " + 
    				"	gm.cdmemoriacalculo = :cdMemoriaCalculo and " + 
    				"	gm.cdpai = :cdGrupoMemoria " + 
    				" UNION " +  
    				" select " + 
    				"	sm.cdservicomemoria as id, " + 
    				"	sm.deservico as descricao, " + 
    				"	sm.cdordem as ordem, " + 
    				"	'SERVICO' as tipo, " + 
    				"	sm.qtquantidade as quantidade, " + 
    				"	sm.deunidmedida as unidade " + 
    				" from " + 
    				"	emecServicoMemoria sm " + 
    				"	join emecGrupoMemoria gm on gm.cdgrupomemoria = sm.cdgrupomemoria " + 
    				" where " + 
    				"	sm.cdgrupomemoria = :cdGrupoMemoria and " + 
    				"	gm.cdmemoriacalculo = :cdMemoriaCalculo ";
    		
    		Query query = em.createNativeQuery(sql, FilhoVO.class);
    		List<FilhoVO> filhos = (List<FilhoVO>) query
    								.setParameter("cdMemoriaCalculo", cdMemoriaCalculo)
    								.setParameter("cdGrupoMemoria", cdGrupoMemoria)
    								.getResultList();
            return filhos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			em.close();
		}    	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MemoriaVO> getGrupoMemoriaSql(Integer cdTabela) {
		EntityManager em = emf.createEntityManager();
		
		try {    		
    		String sql = " select " + 
    				"	grupo.cdmemoriacalculo, " + 
    				"	grupo.cdgrupomemoria, " + 
    				"	grupo.degrupomemoria, " + 
    				"	grupo.cdordem, " + 
    				"	mc.cdtabela, " + 
    				"	'descricao da versao do orcamento' as  dememoria, " +
    				"	'GRUPO' as  tptipo " +
    				" from " + 
    				"	emecGrupoMemoria grupo " + 
    				"	join emecMemoriaCalculo mc on grupo.cdmemoriacalculo = mc.cdmemoriacalculo " + 
    				" where " + 
    				"	mc.cdtabela = ?1 " + 
    				"	and coalesce(grupo.cdpai,0) = 0 ";
    		Query query = em.createNativeQuery(sql, MemoriaVO.class);
    		List<MemoriaVO> memoriaCalculo = (List<MemoriaVO>) query.setParameter(1, cdTabela)
    										 					   .getResultList();
            return memoriaCalculo;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			em.close();
		}    	
	}
    
}