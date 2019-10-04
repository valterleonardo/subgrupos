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

import estoque.controle.ms.controllers.EstoqueResource;
import estoque.controle.ms.dict.StatusEstoque;
import estoque.controle.ms.entity.Empresa;
import estoque.controle.ms.entity.Estoque;
import estoque.controle.ms.entity.Produto;
import estoque.controle.ms.repository.service.EstoqueService;

public class EstoqueResourceTest extends MsControleEstoqueApplicationTests{

	private MockMvc mockMvc;
	
	@Autowired
	private EstoqueResource estoqueResource;
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(estoqueResource).build();
	}
	
	@Test
	public void testGetAllEstoque() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/estoque"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGetOneEstoque() throws Exception {
		List<Estoque> estoque = estoqueService.getAll();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/estoque/" + estoque.get(0).getId()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGetOneEstoquePorEmpresa() throws Exception {
		List<Estoque> estoque = estoqueService.getAll();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/estoque/empresa/"+estoque.get(0).getEmpresa().getId()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGetOneEstoquePorProduto() throws Exception {
		List<Estoque> estoque = estoqueService.getAll();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/estoque/produto/" + estoque.get(0).getProduto().getId()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGetOneEstoquePorEmpresaProduto() throws Exception {
		List<Estoque> estoque = estoqueService.getAll();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/estoque/"+estoque.get(0).getEmpresa().getId()+"/"+estoque.get(0).getProduto().getId()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testSaveEstoque() throws Exception{
		estoqueService.save(
				new Estoque(
						new Empresa(1,null,null,null,null,null), 
						StatusEstoque.DISPONIVEL, 
						new Produto(1,null,null,null,null), 
						21, 
						new Date(), 
						true));
	}
	
	@Test
	public void testDeleteEstoque() throws Exception{
		List<Estoque> estoque = estoqueService.getAll();
		if(!estoqueService.delete(estoque.get(0)))
			throw new Exception();
	}
	
	@Test
	public void testEditEstoque() throws Exception{
		List<Estoque> estoque = estoqueService.getAll();
		estoque.get(0).setDataEntrada(new Date());	
		estoqueService.save(estoque.get(0));
			
	}
}
