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
@Table(name = "EMPRESA")
public class Empresa implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	public Empresa() {}
	public Empresa(Integer id, String nomeFantasia, String razaoSocial, String cnpj, Date dataEntrada, Boolean ativo) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.dataEntrada = dataEntrada;
		this.ativo = ativo == null ? false : ativo;
	}	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPRESA_SEQ_ID")
	private Integer id;		
	
	@Column(nullable = false)
	private String nomeFantasia;
	
	@Column
	private String razaoSocial;
	
	@Column
	private String cnpj;
	
	@Column(name = "data_entrada", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	
	@Column(nullable = false)
	private Boolean ativo;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
