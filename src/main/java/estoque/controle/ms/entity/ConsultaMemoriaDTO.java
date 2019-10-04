package estoque.controle.ms.entity;

import java.io.Serializable;

public class ConsultaMemoriaDTO implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	public ConsultaMemoriaDTO() {}
	public ConsultaMemoriaDTO(Long id, String descricao, Integer ordem, String tipo, Integer quantidade, String unidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ordem = ordem;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.unidade = unidade;
	}

	private Long id;
	private String descricao;
	private Integer ordem;
	private String tipo;
	private Integer quantidade;
	private String unidade;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
}