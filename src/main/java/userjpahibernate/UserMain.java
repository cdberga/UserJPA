package userjpahibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserMain {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersDB");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		User newUser = new User();
		newUser.setEmail("bill@email.com");
		newUser.setFullname("Bill");
		newUser.setPassword("hardPass");
		
		entityManager.persist(newUser);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		
		System.out.println(newUser);
	}
}
