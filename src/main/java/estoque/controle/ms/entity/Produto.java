package estoque.controle.ms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable{

	private static final long serialVersionUID = -6913338869810996016L;
	
	public Produto() {}	
	public Produto(Integer id, String descricao, String nome, Date dataEntrada, Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.dataEntrada = dataEntrada;
		this.ativo = ativo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ_ID")
	private Integer id;		
	
	@Column
	private String descricao;
	
	@Column
	private String nome;
	
	@Column(name = "data_entrada")
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	
	@Column
	private Boolean ativo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}