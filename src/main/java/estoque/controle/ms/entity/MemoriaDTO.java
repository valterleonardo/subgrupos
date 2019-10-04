package estoque.controle.ms.entity;

import java.io.Serializable;
import java.util.List;

public class MemoriaDTO implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	public MemoriaDTO() {}
	public MemoriaDTO(Long id, Long cdTabela, String deMemoria, List<FilhoDTO> filhos) {
		super();
		this.id = id;
		this.cdTabela = cdTabela;
		this.deMemoria = deMemoria;
		this.filhos = filhos;
	}
	
	public MemoriaDTO(Long id, Long cdTabela, String deMemoria) {
		super();
		this.id = id;
		this.cdTabela = cdTabela;
		this.deMemoria = deMemoria;
	}

	
	private Long id;
	private Long cdTabela;
	private String deMemoria;
	private List<FilhoDTO> filhos;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCdTabela() {
		return cdTabela;
	}
	public void setCdTabela(Long cdTabela) {
		this.cdTabela = cdTabela;
	}
	public String getDeMemoria() {
		return deMemoria;
	}
	public void setDeMemoria(String deMemoria) {
		this.deMemoria = deMemoria;
	}
	public List<FilhoDTO> getFilhos() {
		return filhos;
	}
	public void setFilhos(List<FilhoDTO> filhos) {
		this.filhos = filhos;
	}
}