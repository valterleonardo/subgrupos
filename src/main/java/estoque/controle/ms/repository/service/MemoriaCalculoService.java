package estoque.controle.ms.repository.service;

import java.util.List;

import estoque.controle.ms.entity.MemoriaVO;
import estoque.controle.ms.entity.emecGrupoMemoria;
import estoque.controle.ms.entity.emecMemoriaCalculo;

public interface MemoriaCalculoService {

	emecMemoriaCalculo getMemorias(Integer id);
	List<emecGrupoMemoria> getGrupoMemoria(Integer id);
	List<MemoriaVO> getGrupoMemoriaSql(Integer cdMemoriaCalculo); 
}