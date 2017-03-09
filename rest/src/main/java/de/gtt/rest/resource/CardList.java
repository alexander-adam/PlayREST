package de.gtt.rest.resource;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.gtt.core.entity.Card;

@XmlRootElement(name = "cardList")
public class CardList {
	private List<Card> cards;

	public CardList() {
	}

	public CardList(List<Card> cards) {
		this.cards = cards;
	}

	@XmlElement(name = "cards")
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
