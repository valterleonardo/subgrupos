package estoque.controle.ms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import estoque.controle.ms.entity.FilhoVO;
import estoque.controle.ms.entity.MemoriaDTO;
import estoque.controle.ms.entity.MemoriaVO;
import estoque.controle.ms.entity.emecMemoriaCalculo;
import estoque.controle.ms.repository.service.MemoriaCalculoService;

@RestController
@RequestMapping(value="/api")
@JsonInclude(content = Include.NON_NULL)
public class ConsultaGruposResource {
	
	private final static Logger log = LoggerFactory.getLogger(ConsultaGruposResource.class);
	private MemoriaCalculoService memoriaCalculoService;

	ConsultaGruposResource(MemoriaCalculoService memoriaCalculoService) {
       this.memoriaCalculoService = memoriaCalculoService;
	}

	@GetMapping(path = {"/memoria/{id}"})
	public ResponseEntity<emecMemoriaCalculo> getMemoria(@PathVariable Integer id) {
		log.info("ConsultaGruposResource: iniciando processamento getMemoria()");
		
		try {
			emecMemoriaCalculo memoria = memoriaCalculoService.getMemorias(id);
			return new ResponseEntity<emecMemoriaCalculo>(memoria, HttpStatus.OK);
			
		} catch (Exception e) {
			log.info("ConsultaGruposResource: Erro ao executar"
					+ " getMemoria({})", e.getCause().toString());
			return new ResponseEntity<emecMemoriaCalculo>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} finally {
			log.info("ConsultaGruposResource: finalizando processamento getMemoria()");
		}
	}
	
	/*
	 * @GetMapping(path = {"/mock/memoria/{cdMemoriaCalculo}"}) public
	 * ResponseEntity<MemoriaDTO> getMockMem(@PathVariable Integer cdMemoriaCalculo)
	 * {
	 * 
	 * Long aux = 0L; List<FilhoVO> filhos = new ArrayList<FilhoVO>(); while (aux <=
	 * 8) { aux ++; filhos.add(new FilhoVO(aux, "Grupo 0" + aux.toString(),
	 * aux.intValue(), "GRUPO", null, null)); }
	 * 
	 * MemoriaDTO memoria = new MemoriaDTO(1L, 5400001L,
	 * "Orcamento 5400 versao 001", filhos); return new
	 * ResponseEntity<MemoriaDTO>(memoria, HttpStatus.OK);
	 * 
	 * }
	 */
	
	/*
	 * @GetMapping(path = {"/mock/grupo/{cdGrupoMemoria}"}) public
	 * ResponseEntity<GrupoDTO> getMockGrupo(@PathVariable Integer cdGrupoMemoria) {
	 * 
	 * Long aux = 0L; List<FilhoVO> filhos = new ArrayList<FilhoVO>(); while (aux <=
	 * 4) { aux ++; filhos.add(new FilhoVO(aux, "Servico 0" + aux.toString(),
	 * aux.intValue(), "GRUPO", 10, "m3")); } aux = 0L; while (aux <= 4) { aux ++;
	 * filhos.add(new FilhoVO(aux, "Grupo 0" + aux.toString(), aux.intValue(),
	 * "SERVICO", null, null)); }
	 * 
	 * GrupoDTO grupo = new GrupoDTO(1L, "Grupo 01", filhos); return new
	 * ResponseEntity<GrupoDTO>(grupo, HttpStatus.OK);
	 * 
	 * }
	 */
	
	@GetMapping(path = {"/sql/memoria/{cdTabela}"})
	public ResponseEntity<MemoriaDTO> getSqlMem(@PathVariable Integer cdTabela) {
		log.info("ConsultaGruposResource: iniciando processamento getSqlMem()");
		
		List<MemoriaVO> memoriasEGrupos = memoriaCalculoService.getGrupoMemoriaSql(cdTabela);
		List<FilhoVO> filhos = new ArrayList<FilhoVO>();
		
		for (MemoriaVO memoria : memoriasEGrupos) {
			filhos.add(new FilhoVO(memoria.getCdgrupomemoria(), memoria.getDegrupomemoria(), memoria.getCdordem(), memoria.getTptipo() ,null, null));
		}
		
		MemoriaDTO memoriaDto = new MemoriaDTO(
								memoriasEGrupos.get(0).getCdmemoriacalculo(),
								memoriasEGrupos.get(0).getCdtabela(),
								memoriasEGrupos.get(0).getDememoria(),
								filhos);
		
		log.info("ConsultaGruposResource: finalizando processamento getSqlMem()");
		return new ResponseEntity<MemoriaDTO>(memoriaDto, HttpStatus.OK);
		
	}
	
	@GetMapping(path = {"/sql/grupo/{cdMemoriaCalculo}/{cdGrupoMemoria}"})
	public ResponseEntity<List<FilhoVO>> getSqlGrupo(@PathVariable Long cdMemoriaCalculo, @PathVariable Long cdGrupoMemoria) {
		log.info("ConsultaGruposResource: iniciando processamento getSqlGrupo()");
		
		List<FilhoVO> filhos = memoriaCalculoService.getSubGrupoServicoSql(cdMemoriaCalculo, cdGrupoMemoria);
				
		log.info("ConsultaGruposResource: finalizando processamento getSqlGrupo()");
		return new ResponseEntity<List<FilhoVO>>(filhos, HttpStatus.OK);
		
	}
}
