package github.tiagomac.cadastrocliente.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Cliente {

	private Integer id;
	private String nome;
	
	
}
