package estoque.controle.ms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data
public class ConsultaMemoriaDTO implements Serializable{
		
	private static final long serialVersionUID = 5653573443159688609L;

	@Id
	private Integer id;
	private String descricao;
	private Integer ordem;
	private String tipo;
	private Integer quantidade;
	private String unidade;
}