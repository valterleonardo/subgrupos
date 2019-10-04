package estoque.controle.ms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emecmemoriacalculo")
public class emecMemoriaCalculo implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	public emecMemoriaCalculo() {}
	public emecMemoriaCalculo(Long cdMemoriaCalculo, Long cdTabela, Date dtGeracao, Date dtInclusao,
			String cdUsuarioInclusao) {
		super();
		this.cdMemoriaCalculo = cdMemoriaCalculo;
		this.cdTabela = cdTabela;
		this.dtGeracao = dtGeracao;
		this.dtInclusao = dtInclusao;
		this.cdUsuarioInclusao = cdUsuarioInclusao;
	}

	@Id
	@Column(name="cdmemoriacalculo")
	private Long cdMemoriaCalculo;
	
	@Column(name="cdtabela")
	private Long cdTabela;
	
	@Column(name="dtgeracao")
	private Date dtGeracao;
	
	@Column(name="dtinclusao")
	private Date dtInclusao;
	
	@Column(name="cdusuarioinclusao")
	private String cdUsuarioInclusao;
	
	@Column(name="dtalteracao")
	private Date dtAlteracao;
	
	@Column(name="cdusuarioalteracao")
	private String cdUsuarioAlteracao;
	

	public Long getCdMemoriaCalculo() {
		return cdMemoriaCalculo;
	}
	public void setCdMemoriaCalculo(Long cdMemoriaCalculo) {
		this.cdMemoriaCalculo = cdMemoriaCalculo;
	}
	public Long getCdTabela() {
		return cdTabela;
	}
	public void setCdTabela(Long cdTabela) {
		this.cdTabela = cdTabela;
	}
	public Date getDtGeracao() {
		return dtGeracao;
	}
	public void setDtGeracao(Date dtGeracao) {
		this.dtGeracao = dtGeracao;
	}
	public Date getDtInclusao() {
		return dtInclusao;
	}
	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}
	public String getCdUsuarioInclusao() {
		return cdUsuarioInclusao;
	}
	public void setCdUsuarioInclusao(String cdUsuarioInclusao) {
		this.cdUsuarioInclusao = cdUsuarioInclusao;
	}
	public Date getDtAlteracao() {
		return dtAlteracao;
	}
	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}
	public String getCdUsuarioAlteracao() {
		return cdUsuarioAlteracao;
	}
	public void setCdUsuarioAlteracao(String cdUsuarioAlteracao) {
		this.cdUsuarioAlteracao = cdUsuarioAlteracao;
	}
}
