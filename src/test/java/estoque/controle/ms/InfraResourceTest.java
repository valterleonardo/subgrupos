package estoque.controle.ms;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import estoque.controle.ms.controllers.InfraResource;

public class InfraResourceTest extends MsControleEstoqueApplicationTests{

	private MockMvc mockMvc;
	
	@Autowired
	private InfraResource infraResource;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(infraResource).build();
	}
	
	@Test
	public void testGetPong() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/infra/ping"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}