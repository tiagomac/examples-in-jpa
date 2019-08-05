package github.tiagomac.cadastrocliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import github.tiagomac.cadastrocliente.dto.UsuarioDTO;
import github.tiagomac.cadastrocliente.model.Dominio;
import github.tiagomac.cadastrocliente.model.Usuario;

public class ConsultasComJPQL {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
//		primeiraConsulta(entityManager);
//		escolhendoRetorno(entityManager);
//		fazendoProjecoes(entityManager);
		passandoParametros(entityManager);
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void passandoParametros(EntityManager entityManager) {
		String jpql = "select u from Usuario u where u.id = :idUsuario";
		TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
		typedQuery.setParameter("idUsuario", 1);
		Usuario usuario = typedQuery.getSingleResult();
		System.out.println(usuario);
	}
	
	public static void fazendoProjecoes(EntityManager entityManager) {
		String jpqlArr = "select id, login, nome from Usuario";
		TypedQuery<Object[]> typedQueryArr = entityManager.createQuery(jpqlArr, Object[].class);
		List<Object[]> listaArr = typedQueryArr.getResultList();
		listaArr.forEach(arr -> System.out.println(String.format("%s, %s, %s", arr)));
		
		String jpqlDto = "select new github.tiagomac.cadastrocliente.dto.UsuarioDTO(id, login, nome) from Usuario";
		TypedQuery<UsuarioDTO> typedQueryDto = entityManager.createQuery(jpqlDto, UsuarioDTO.class);
		List<UsuarioDTO> listaDto = typedQueryDto.getResultList();
		listaDto.forEach(dto -> System.out.println(dto));
	}
	
	public static void escolhendoRetorno(EntityManager entityManager) {
		String jpql = "select u.dominio from Usuario u where u.id = 1";
		TypedQuery<Dominio> typedQuery = entityManager.createQuery(jpql, Dominio.class);
		Dominio dominio = typedQuery.getSingleResult();
		System.out.println(dominio);
		
		String jpqlNom = "select u.nome from Usuario u";
		TypedQuery<String> typedQueryNom = entityManager.createQuery(jpqlNom, String.class);
		List<String> listaNom = typedQueryNom.getResultList();
		listaNom.forEach(u -> System.out.println(u));
	}
	
	public static void primeiraConsulta(EntityManager entityManager) {
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
		List<Usuario> lista = typedQuery.getResultList();
		lista.forEach(u -> System.out.println(u));
		
		String jpqlSingle = "select u from Usuario u where u.id = 1";
		TypedQuery<Usuario> typedQuerySingle = entityManager.createQuery(jpqlSingle, Usuario.class);
		Usuario usuario = typedQuerySingle.getSingleResult();
		System.out.println(usuario);
		
		String jpqlCast = "select u from Usuario u where u.id = 1";
		Query query = entityManager.createQuery(jpqlCast);
		Usuario usuario2 = (Usuario) query.getSingleResult();
		System.out.println(usuario2);
	}

}
