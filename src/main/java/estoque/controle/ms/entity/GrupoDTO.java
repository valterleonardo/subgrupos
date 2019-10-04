package estoque.controle.ms.entity;

import java.io.Serializable;
import java.util.List;

public class GrupoDTO implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	public GrupoDTO() {}
	public GrupoDTO(Long id, String deGrupo, List<FilhoDTO> filhos) {
		super();
		this.id = id;
		this.deGrupo = deGrupo;
		this.filhos = filhos;
	}

	private Long id;
	private String deGrupo;
	private List<FilhoDTO> filhos;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public List<FilhoDTO> getFilhos() {
		return filhos;
	}
	public void setFilhos(List<FilhoDTO> filhos) {
		this.filhos = filhos;
	}
	public String getDeGrupo() {
		return deGrupo;
	}
	public void setDeGrupo(String deGrupo) {
		this.deGrupo = deGrupo;
	}
}