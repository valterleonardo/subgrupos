package estoque.controle.ms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import estoque.controle.ms.dict.StatusEstoque;

@Entity
@Table(name = "ESTOQUE")
public class Estoque implements Serializable {

	private static final long serialVersionUID = -5204253362209154861L;
	
	public Estoque() {}
	public Estoque(Empresa empresa, StatusEstoque status, Produto produto, Integer quantidade,
			Date dataEntrada, Boolean ativo) {
		super();
		this.empresa = empresa;
		this.status = status;
		this.produto = produto;
		this.quantidade = quantidade;
		this.dataEntrada = dataEntrada;
		this.ativo = ativo == null ? false : ativo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTOQUE_SEQ_ID")
	private Integer id;		
	
	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false)
	private Empresa empresa;
	
	@Enumerated
	@Column(nullable = false)
	private StatusEstoque status;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@Column(nullable = false)
	private Integer quantidade;	
	
	@Column(name = "data_entrada", nullable = false)
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public StatusEstoque getStatus() {
		return status;
	}

	public void setStatus(StatusEstoque status) {
		this.status = status;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Boolean getAtivo() {
		return ativo == null ? false : ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo == null ? false : ativo;
	}
}