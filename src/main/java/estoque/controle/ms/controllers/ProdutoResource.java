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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import estoque.controle.ms.entity.Produto;
import estoque.controle.ms.repository.service.ProdutoService;

@RestController
@RequestMapping(value="/api/produto")
@CrossOrigin
public class ProdutoResource {
	
	private final static Logger log = LoggerFactory.getLogger(ProdutoResource.class);
	private ProdutoService produtoService;

	ProdutoResource(ProdutoService produtoService) {
       this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<Produto>> getProduto() {
		log.info("ProdutoResource: iniciando processamento getProduto()");
		
		try {
			List<Produto> produtos = produtoService.getAll();
			return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
			
		} catch (Exception e) {
			log.info("ProdutoResource: Erro ao executar getProduto({})", e.getCause().toString());
			return new ResponseEntity<List<Produto>>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} finally {
			log.info("ProdutoResource: finalizando processamento getProduto()");
		}
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Produto> getProdutoPorId(@PathVariable Integer id){
		log.info("ProdutoResource: iniciando processamento getProdutoPorId(/{})", id);
		try {
			Produto produto = produtoService.getById(id);
			if (produto != null) 
				return new ResponseEntity<Produto>(produto, HttpStatus.OK);
			else
				return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
						
		} catch (Exception e) {
			log.info("ProdutoResource: Erro ao executar getProdutoPorId({})", e.getCause().toString());
			return new ResponseEntity<Produto>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} finally {
			log.info("ProdutoResource: finalizando processamento getProdutoPorId(/{})", id);
		}
	}	
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto){
		log.info("ProdutoResource: iniciando processamento putProduto()");
		try {
			Produto novoProduto = produtoService.save(produto);
			return new ResponseEntity<Produto>(novoProduto, HttpStatus.CREATED);
			
		} catch (Exception e) {
			log.info("ProdutoResource: Erro ao salvar produto putProduto({})", e.getCause().toString());
			return new ResponseEntity<Produto>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			log.info("ProdutoResource: finalizando processamento putProduto()");
		}
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deleteProduto(@PathVariable Integer id){
		log.info("ProdutoResource: iniciando processamento deleteProduto({})", id);
		
		try {
			if(produtoService.delete(id))
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			log.info("ProdutoResource: Erro ao deletar produto deleteProduto({})", e.getCause().toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} finally {
			log.info("ProdutoResource: finalizando processamento deleteProduto({})", id);
		}
	}
}
