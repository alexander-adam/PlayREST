package de.gtt.core.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class HibernateUtil {
	private static final String PERSISTENCE_UNIT_NAME = "PlayRESTUnit";

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static <E> List<E> getAll(Class<E> clazz) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(clazz);
		Root<E> rootEntry = cq.from(clazz);
		CriteriaQuery<E> all = cq.select(rootEntry);
		TypedQuery<E> allQuery = getEntityManager().createQuery(cq);
		return allQuery.getResultList();
	}
}