package de.gtt.core.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static EntityManager entityManager = getEntityManager();

	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml.bak"));
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}

			return sessionFactory;
		}
		catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = getSessionFactory().createEntityManager();
		}

		return entityManager;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

	public static <E> List<E> getAll(Class<E> clazz) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(clazz);
		Root<E> rootEntry = cq.from(clazz);
		CriteriaQuery<E> all = cq.select(rootEntry);
		TypedQuery<E> allQuery = getEntityManager().createQuery(all);
		return allQuery.getResultList();
	}
}