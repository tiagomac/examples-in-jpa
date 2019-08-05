package github.tiagomac.cadastrocliente.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Configuracao {

	@Id
	private Integer id;

	@MapsId
	@OneToOne
	@ToString.Exclude
	private Usuario usuario;

	private boolean receberNotificacoes;

	private boolean encerrarSessaoAutomaticamente;

}
