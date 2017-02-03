package de.gtt.core;

import java.util.List;

import org.hibernate.Session;

import de.gtt.core.entity.Card;
import de.gtt.core.util.HibernateUtil;

public class CardService {
	public List<Card> getAll() {
		return HibernateUtil.getAll(Card.class);
	}

	public void save(Card card) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(card);
		session.getTransaction().commit();
		session.close();
	}
}
