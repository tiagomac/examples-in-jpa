package github.tiagomac.cadastrocliente.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	private Integer id;
	
	private String nome;

}
