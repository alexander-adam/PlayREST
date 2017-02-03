package de.gtt.core;

import de.gtt.core.entity.Card;
import junit.framework.TestCase;

import java.util.List;

public class CardServiceTest extends TestCase {
	private CardService cardService;

	public void setUp() throws Exception {
		super.setUp();
		cardService = new CardService();
	}

	public void tearDown() throws Exception {
		super.tearDown();
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