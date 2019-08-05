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
		
		
//		// inserindo cliente
//		Cliente cliente = new Cliente();
//		cliente.setNome("Eletro Silva");
//		entityManager.getTransaction().begin();
//		entityManager.persist(cliente);
//		entityManager.getTransaction().commit();
		
		// removendo cliente
//		Cliente cliente = entityManager.find(Cliente.class, 2);
//		entityManager.getTransaction().begin();
//		entityManager.remove(cliente);
//		entityManager.getTransaction().commit();
		
//		Cliente cliente = entityManager.find(Cliente.class, 1);
//		Cliente cliente2 = entityManager.find(Cliente.class, 1);
		
		// objeto gerenciado
//		Cliente cliente = entityManager.find(Cliente.class, 1);
//		entityManager.getTransaction().begin();
//		cliente.setNome(cliente.getNome() + " Alterado");
//		entityManager.getTransaction().commit();
		
		
		// uso do merge para atualizar registros (o merge também cria caso o id não exista).
		Cliente cliente = new Cliente();
//		cliente.setId(1);
		cliente.setNome("Construtora Medeiros");
		
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
