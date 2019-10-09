package estoque.controle.ms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GrupoDTO implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	@Id
	private Integer id;
	private String deGrupo;
	@Transient
	private List<FilhoVO> filhos;
}