package de.gtt.core;

import java.util.List;

import de.gtt.core.entity.Card;
import de.gtt.core.util.HibernateUtil;
import junit.framework.TestCase;

public class CardServiceTest extends TestCase {
	private CardService cardService;

	public void setUp() throws Exception {
		super.setUp();
		cardService = new CardService();
	}

	public void tearDown() throws Exception {
		super.tearDown();
		HibernateUtil.shutdown();
	}

	public void testGetAll() throws Exception {
		List<Card> all = cardService.getAll();
		System.out.println("Found " + all.size() + " cards.");
	}

	public void testSave() throws Exception {
		Card card = new Card();
		card.setUnit("Unit 1");
		card.setQuestionText("Q Text");
		card.setAnswerText("A Text");

		cardService.save(card);

		testGetAll();
	}
}