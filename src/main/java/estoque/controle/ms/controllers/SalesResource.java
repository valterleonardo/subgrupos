package estoque.controle.ms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estoque.controle.ms.entity.Transacao;
import estoque.controle.ms.repository.service.TransacaoService;

@RestController
@RequestMapping(value="/api/comercial")
public class SalesResource {
	
	private final static Logger log = LoggerFactory.getLogger(SalesResource.class);
	private TransacaoService transacaoService;

	SalesResource(TransacaoService transacaoService) {
       this.transacaoService = transacaoService;
	}

	@GetMapping
	public ResponseEntity<List<Transacao>> getTransacao() {
		log.info("TransacaoResource: iniciando processamento getTransacao()");
		
		try {
			List<Transacao> transacoes = transacaoService.getAll();
			return new ResponseEntity<List<Transacao>>(transacoes, HttpStatus.OK);
			
		} catch (Exception e) {
			log.info("TransResource: Erro ao executar getTransacao({})", e.getCause().toString());
			return new ResponseEntity<List<Transacao>>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} finally {
			log.info("TransacaoResource: finalizando processamento getTransacao()");
		}
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Transacao> getTransacaoPorId(@PathVariable Integer id){
		log.info("TransacaoResource: iniciando processamento getTransacaoPorId(/{})", id);
		try {
			Transacao transacao = transacaoService.getById(id);
			if (transacao != null) 
				return new ResponseEntity<Transacao>(transacao, HttpStatus.OK);
			else
				return new ResponseEntity<Transacao>(HttpStatus.NOT_FOUND);
						
		} catch (Exception e) {
			log.info("TransacaoResource: Erro ao executar getTransacaoPorId({})", e.getCause().toString());
			return new ResponseEntity<Transacao>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} finally {
			log.info("TransacaoResource: finalizando processamento getTransacaoPorId(/{})", id);
		}
	}	
	
	@PutMapping
	public ResponseEntity<Transacao> putTransacao(@RequestBody Transacao transacao){
		log.info("TransacaoResource: iniciando processamento putTransacao()");
		try {
			Transacao novaTransacao = transacaoService.save(transacao);
			return new ResponseEntity<Transacao>(novaTransacao, HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			log.info("TransacaoResource: Erro ao salvar Transacao putTransacao({})", e.getCause().toString());
			return new ResponseEntity<Transacao>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			log.info("TransacaoResource: finalizando processamento putTransacao()");
		}
	}
}
