package de.gtt.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import de.gtt.core.entity.Card;
import de.gtt.core.util.HibernateUtil;

public class CardService {
	public static List<Card> getAll() {
		return HibernateUtil.
				getEntityManager().
				createNamedQuery("findAll").
				getResultList();
//		return HibernateUtil.getAll(Card.class);
	}

	public static Card save(Card card) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		entityManager.getTransaction().begin();
		card = entityManager.merge(card);
		entityManager.getTransaction().commit();

		return card;
	}

	public static List<Card> save(List<Card> cards) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		entityManager.getTransaction().begin();

		List<Card> savedCards = new ArrayList<Card>(cards.size());

		for (Card card : cards) {
			card = entityManager.merge(card);
			savedCards.add(card);
		}

		entityManager.getTransaction().commit();

		return savedCards;
	}

	public static Card get(String uuid) {
		List cards = HibernateUtil.
				getEntityManager().
				createNamedQuery("findByUUID").
				setParameter("uuid", uuid).
				getResultList();

		if (cards.size() == 1) {
			return (Card) cards.get(0);
		}
		else if (cards.isEmpty()) {
			return null;
		}
		else {
			throw new IllegalStateException("More than one card found for uuid: " + uuid);
		}
	}

	public static boolean delete(String uuid) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		entityManager.getTransaction().begin();

		int deleted = entityManager.
				createNamedQuery("deleteByUUID").
				setParameter("uuid", uuid).
				executeUpdate();

		entityManager.getTransaction().commit();

		return deleted == 1;
	}

	public static int deleteAll() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		entityManager.getTransaction().begin();

		int deleted = entityManager.
				createNamedQuery("deleteAll").
				executeUpdate();

		entityManager.getTransaction().commit();

		return deleted;
	}
}
