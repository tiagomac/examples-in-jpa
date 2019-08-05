package github.tiagomac.cadastrocliente.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Dominio {

	@Id
	private Integer id;

	private String nome;

	@OneToMany(mappedBy = "dominio")
	@ToString.Exclude
	private List<Usuario> usuarios;

}
