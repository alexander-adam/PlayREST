package de.gtt.core;

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
}
