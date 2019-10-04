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

import estoque.controle.ms.dict.SituacaoTransacao;

@Entity
@Table(name = "TRANSACAO")
public class Transacao implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	public Transacao() {}
	public Transacao(Integer id, Estoque estoque, Date dataEntrada, SituacaoTransacao situacao, Integer quantidade) {
		super();
		this.id = id;
		this.estoque = estoque;
		this.dataTransacao = dataEntrada;
		this.situacao = situacao;
		this.quantidade = quantidade;
	}	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACAO_SEQ_ID")
	private Integer id;		
	
	@ManyToOne
	@JoinColumn(name = "estoque_id", nullable = false)
	private Estoque estoque;
	
	@Column(name = "data_transacao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTransacao;
	
	@Enumerated
	@Column(nullable = false)
	private SituacaoTransacao situacao;
	
	@Column
	private Integer quantidade;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return dataTransacao;
	}
	
	public void setDataEntrada(Date dataEntrada) {
		this.dataTransacao = dataEntrada;
	}
	
	public Estoque getEstoque() {
		return estoque;
	}
	
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public SituacaoTransacao getSituacao() {
		return situacao;
	}
	
	public void setSituacao(SituacaoTransacao situacao) {
		this.situacao = situacao;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
