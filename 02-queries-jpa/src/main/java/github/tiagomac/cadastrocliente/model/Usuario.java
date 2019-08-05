package github.tiagomac.cadastrocliente.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Usuario {

	@Id
	private Integer id;

	private String login;

	private String senha;

	private String nome;

	private LocalDateTime ultimoAcesso;

	@ManyToOne
	@ToString.Exclude
	private Dominio dominio;
	//
//	    @OneToOne(mappedBy = "usuario")
//	    private Configuracao configuracao;

//	    public Configuracao getConfiguracao() {
//	        return configuracao;
//	    }
	//
//	    public void setConfiguracao(Configuracao configuracao) {
//	        this.configuracao = configuracao;
//	    }

}
