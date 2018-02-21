package io.github.cepr0.demo;

import io.github.cepr0.demo.model.Child;
import io.github.cepr0.demo.model.Parent;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static java.util.Arrays.asList;

@Slf4j
public class Application {

//	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		LOG.info("App started.");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-unit");
		EntityManager em = emf.createEntityManager();

		Child child1 = new Child("child1");
		Child child2 = new Child("child2");

		Parent parent1 = new Parent("parent1", asList(child1, child2));
		em.persist(parent1);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
//		emf.close();
		LOG.info("App stopped.");
	}
}
