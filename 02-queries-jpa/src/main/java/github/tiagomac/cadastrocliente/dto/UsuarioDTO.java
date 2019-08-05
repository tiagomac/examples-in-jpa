package github.tiagomac.cadastrocliente.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class UsuarioDTO {
	
	private Integer id;

	private String login;

	private String nome;

	public UsuarioDTO(Integer id, String login, String nome) {
		this.id = id;
		this.login = login;
		this.nome = nome;
	}
	
}
