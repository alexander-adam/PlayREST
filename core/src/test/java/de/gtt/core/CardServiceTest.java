package de.gtt.core;

import de.gtt.core.entity.Card;
import de.gtt.core.util.HibernateUtil;
import junit.framework.TestCase;

import java.util.List;

public class CardServiceTest extends TestCase {
	private CardService cardService;

	public void setUp() throws Exception {
		super.setUp();
		cardService = new CardService();
//		int deleted = cardService.deleteAll();
//		System.out.println("Deleted " + deleted + " cards.");
	}

	public void tearDown() throws Exception {
		HibernateUtil.close();
		super.tearDown();
	}

	private void showAll() throws Exception {
		List<Card> all = cardService.getAll();
		System.out.println("Found " + all.size() + " cards.");

		for (Card card : all) {
			System.out.println(card);
		}
	}

//	public void testSave() throws Exception {
//		Card card = new Card();
//		card.setUnit("Unit 1");
//		card.setQuestionText("Q Text");
//		card.setAnswerText("A Text");
//
//		cardService.save(card);
//
//		showAll();
//	}

	public void testFluentInterface() throws Exception {
		long position = 0;
		List<Card> cards = cardService.getAll();

		if (!cards.isEmpty()) {
			System.out.println("Initial: " + cards.size());
			position = cards.get(cards.size() - 1).getPosition() + 1;
		}

		Card card = new Card().
				withPosition(position).
				withUnit("Simple words").
				withQuestionText("Frage " + position).
				withQuestionTranscription("Frage " + position).
				withQuestionExample("Das ist keine Frage " + position).
				withQuestionImage("Image 1").
				withQuestionImage("Image 2").
				withQuestionImage("Image 3").
				withAnswerText("Question " + position).
				withAnswerTranscription("Question " + position).
				withAnswerExample("It's not a question " + position).
				withAnswerAudio("Audio 1").
				withAnswerAudio("Audio 2");

		card = cardService.save(card);

		card.withAnswerImage("Image 1");

		card = cardService.save(card);

		card = cardService.get(card.getUuid());
		assertNotNull(card);

		card = cardService.get("xxx");
		assertNull(card);

		showAll();
	}
}