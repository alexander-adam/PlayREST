package de.gtt.core;

import java.util.List;

import javax.persistence.EntityManager;

import de.gtt.core.entity.Card;
import de.gtt.core.util.HibernateUtil;

public class CardService {
	public List<Card> getAll() {
		return HibernateUtil.getAll(Card.class);
	}

	public void save(Card card) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(card);
		entityManager.getTransaction().commit();
	}
}
