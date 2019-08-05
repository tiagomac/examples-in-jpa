package github.tiagomac.cadastrocliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import github.tiagomac.cadastrocliente.model.Cliente;

public class Exemplo {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// recuperar cliente
//		Cliente cliente = entityManager.find(Cliente.class, 1);
//		System.out.println(cliente);
		
		
		Cliente cliente = new Cliente();
		cliente.setId(2);
		cliente.setNome("Autopeças Estrada");
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
