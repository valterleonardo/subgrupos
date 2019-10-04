package estoque.controle.ms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emecgrupomemoria")
public class emecGrupoMemoria implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	public emecGrupoMemoria() {}	
	public emecGrupoMemoria(Long cdGrupoMemoria, Long cdMemoriaCalculo, Long cdOrdem, String deGrupoMemoria, Long cdPai,
			Date dtInclusao, String cdUsuarioInclusao, Date dtAlteracao, String cdUsuarioAlteracao) {
		super();
		this.cdGrupoMemoria = cdGrupoMemoria;
		this.cdMemoriaCalculo = cdMemoriaCalculo;
		this.cdOrdem = cdOrdem;
		this.deGrupoMemoria = deGrupoMemoria;
		this.cdPai = cdPai;
		this.dtInclusao = dtInclusao;
		this.cdUsuarioInclusao = cdUsuarioInclusao;
		this.dtAlteracao = dtAlteracao;
		this.cdUsuarioAlteracao = cdUsuarioAlteracao;
	}

	@Id
	@Column(name="cdgrupomemoria")
	private Long cdGrupoMemoria;
	
	@Column(name="cdmemoriacalculo")
	private Long cdMemoriaCalculo;
	
	@Column(name="cdordem")
	private Long cdOrdem;
	
	@Column(name="degrupomemoria")
	private String deGrupoMemoria;
	
	@Column(name="cdpai")
	private Long cdPai;
	
	@Column(name="dtinclusao")
	private Date dtInclusao;
	
	@Column(name="cdusuarioinclusao")
	private String cdUsuarioInclusao;
	
	@Column(name="dtalteracao")
	private Date dtAlteracao;
	
	@Column(name="cdusuarioalteracao")
	private String cdUsuarioAlteracao;

	
	public Long getCdGrupoMemoria() {
		return cdGrupoMemoria;
	}
	public void setCdGrupoMemoria(Long cdGrupoMemoria) {
		this.cdGrupoMemoria = cdGrupoMemoria;
	}
	public Long getCdMemoriaCalculo() {
		return cdMemoriaCalculo;
	}
	public void setCdMemoriaCalculo(Long cdMemoriaCalculo) {
		this.cdMemoriaCalculo = cdMemoriaCalculo;
	}
	public Long getCdOrdem() {
		return cdOrdem;
	}
	public void setCdOrdem(Long cdOrdem) {
		this.cdOrdem = cdOrdem;
	}
	public String getDeGrupoMemoria() {
		return deGrupoMemoria;
	}
	public void setDeGrupoMemoria(String deGrupoMemoria) {
		this.deGrupoMemoria = deGrupoMemoria;
	}
	public Long getCdPai() {
		return cdPai;
	}
	public void setCdPai(Long cdPai) {
		this.cdPai = cdPai;
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
