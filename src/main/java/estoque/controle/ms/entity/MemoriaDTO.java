package estoque.controle.ms.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class MemoriaDTO implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;
	
	private Integer id;
	private Integer cdTabela;
	private String deMemoria;
	private List<FilhoVO> filhos;

}