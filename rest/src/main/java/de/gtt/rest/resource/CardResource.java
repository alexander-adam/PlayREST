package de.gtt.rest.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.gtt.core.CardService;
import de.gtt.core.entity.Card;

@Path("card")
public class CardResource {
	@GET
	@Path("/{uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Card getCard(@PathParam("uuid") String uuid) {
		return CardService.get(uuid);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CardList getCards() {
		List<Card> cards = CardService.getAll();
		return new CardList(cards);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	public void save(CardList cardList) {
		List<Card> cards = cardList.getCards();
		List<Card> updatedCards = new ArrayList<Card>();

		for (long i = 0; i < cards.size(); i++) {
			Card card = cards.get((int) i);

			if (card.getPosition() != i) {
				card.setPosition(i);
				updatedCards.add(card);
			}
		}

		if (!updatedCards.isEmpty()) {
			CardService.save(updatedCards);
		}

//		return cardList;
	}
}
