package estoque.controle.ms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estoque.controle.ms.entity.Empresa;
import estoque.controle.ms.repository.service.EmpresaService;

@RestController
@RequestMapping(value="/api/empresa")
@CrossOrigin
public class EmpresaResource {
	
	private final static Logger log = LoggerFactory.getLogger(EmpresaResource.class);
	private EmpresaService empresaService;

	EmpresaResource(EmpresaService empresaService) {
       this.empresaService = empresaService;
	}

	@GetMapping
	public ResponseEntity<List<Empresa>> getEmpresa() {
		log.info("EmpresaResource: iniciando processamento getEmpresa()");
		
		try {
			List<Empresa> empresas = empresaService.getAll();
			return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.OK);
			
		} catch (Exception e) {
			log.info("EmpresaResource: Erro ao executar getEmpresa({})", e.getCause().toString());
			return new ResponseEntity<List<Empresa>>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} finally {
			log.info("EmpresaResource: finalizando processamento getEmpresa()");
		}
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Empresa> getEmpresaPorId(@PathVariable Integer id){
		log.info("EmpresaResource: iniciando processamento getEmpresaPorId(/{})", id);
		try {
			Empresa empresa = empresaService.getById(id);
			if (empresa != null) 
				return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
			else
				return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
						
		} catch (Exception e) {
			log.info("EmpresaResource: Erro ao executar getEmpresaPorId({})", e.getCause().toString());
			return new ResponseEntity<Empresa>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} finally {
			log.info("EmpresaResource: finalizando processamento getEmpresaPorId(/{})", id);
		}
	}	
	
	@PutMapping
	public ResponseEntity<Empresa> putEmpresa(@RequestBody Empresa empresa){
		log.info("EmpresaResource: iniciando processamento putEmpresa()");
		try {
			Empresa novaEmpresa = empresaService.save(empresa);
			return new ResponseEntity<Empresa>(novaEmpresa, HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			log.info("EmpresaResource: Erro ao salvar empresa putEmpresa({})", e.getCause().toString());
			return new ResponseEntity<Empresa>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			log.info("EmpresaResource: finalizando processamento putEmpresa()");
		}
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deleteEmpresa(@PathVariable Integer id){
		log.info("EmpresaResource: iniciando processamento deleteEmpresa({})", id);
		
		try {
			if(empresaService.delete(id))
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			log.info("EmpresaResource: Erro ao deletar empresa deleteEmpresa({})", e.getCause().toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} finally {
			log.info("EmpresaResource: finalizando processamento deleteEmpresa({})", id);
		}
	}
}
