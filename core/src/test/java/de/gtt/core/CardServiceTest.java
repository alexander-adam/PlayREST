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
		System.out.println("Initial: " + cardService.getAll().size());

		Card card = new Card().
				withUnit("Simple words").
				withQuestionText("Frage").
				withQuestionTranscription("Frage").
				withQuestionExample("Das ist keine Frage").
				withQuestionImage("Image 1").
				withQuestionImage("Image 2").
				withQuestionImage("Image 3").
				withAnswerText("Question").
				withAnswerTranscription("Question").
				withAnswerExample("It's not a question").
				withAnswerAudio("Audio 1").
				withAnswerAudio("Audio 2");

		cardService.save(card);

		card.withAnswerImage("Image 1");

		cardService.save(card);

		card = cardService.get(card.getUuid());
		assertNotNull(card);

		card = cardService.get("xxx");
		assertNull(card);

		showAll();
	}
}