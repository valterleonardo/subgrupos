package estoque.controle.ms.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class MemoriaVO implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	public MemoriaVO() {}
	public MemoriaVO(Long cdmemoriacalculo, Long cdgrupomemoria, String degrupomemoria, Integer cdordem,
			Integer cdtabela, String dememoria) {
		super();
		this.cdmemoriacalculo = cdmemoriacalculo;
		this.cdgrupomemoria = cdgrupomemoria;
		this.degrupomemoria = degrupomemoria;
		this.cdordem = cdordem;
		this.cdtabela = cdtabela;
		this.dememoria = dememoria;
	}
	
	
	private Long cdmemoriacalculo;
	private Long cdgrupomemoria;
	private String degrupomemoria;
	private Integer cdordem;
	private Integer cdtabela;
	private String dememoria;

	
	
	
}