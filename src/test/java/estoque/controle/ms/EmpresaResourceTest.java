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

import estoque.controle.ms.controllers.EmpresaResource;
import estoque.controle.ms.entity.Empresa;
import estoque.controle.ms.repository.service.EmpresaService;

public class EmpresaResourceTest extends MsControleEstoqueApplicationTests{

	private MockMvc mockMvc;
	
	@Autowired
	private EmpresaResource empresaResource;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(empresaResource).build();
	}
	
	@Test
	public void testGetAllEmpresa() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/empresa"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGetOneEmpresa() throws Exception {
		List<Empresa> empresa = empresaService.getAll();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/empresa/" + empresa.get(1).getId()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testSaveEmpresa() throws Exception{
		empresaService.save(
				new Empresa(null,"empresa 1","empresa empresa 1","213412323434",new Date(), true));
	}
	
	@Test
	public void testDeleteEmpresa() throws Exception{
		List<Empresa> empresa = empresaService.getAll();
		if(!empresaService.delete(empresa.get(1).getId()))
			throw new Exception();
	}
	
	@Test
	public void testEditEmpresa() throws Exception{
		List<Empresa> empresa = empresaService.getAll();
		empresa.get(1).setDataEntrada(new Date());	
		empresaService.save(empresa.get(1));
			
	}
}
