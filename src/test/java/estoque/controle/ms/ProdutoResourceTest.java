package estoque.controle.ms;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import estoque.controle.ms.controllers.ProdutoResource;
import estoque.controle.ms.entity.Produto;
import estoque.controle.ms.repository.service.ProdutoService;

public class ProdutoResourceTest extends MsControleEstoqueApplicationTests{

	private MockMvc mockMvc;
	
	@Autowired
	private ProdutoResource produtoResource;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(produtoResource).build();
	}
	
	@Test
	public void testGetAllProduto() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/produto"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGetOneProduto() throws Exception {
		List<Produto> produto = produtoService.getAll();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/produto/" + produto.get(1).getId()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testSaveProduto() throws Exception{
		produtoService.save(
				new Produto(52,"Produto 1","Produto produto 1",new Date(), true));
	}
	
	@Test
	public void testDeleteProduto() throws Exception{
		List<Produto> produto = produtoService.getAll();
		if(!produtoService.delete(produto.get(1).getId()))
			throw new Exception();
	}
	
	@Test
	public void testEditProduto() throws Exception{
		List<Produto> produto = produtoService.getAll();
		produto.get(1).setDataEntrada(new Date());	
		produtoService.save(produto.get(1));
			
	}
}
