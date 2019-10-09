package estoque.controle.ms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data
public class MemoriaVO implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
		
	@Id
	private Integer cdgrupomemoria;
	private Integer cdmemoriacalculo;
	private Integer cdordem;
	private Integer cdtabela;
	
	private String dememoria;
	private String tptipo;
	private String degrupomemoria;

}