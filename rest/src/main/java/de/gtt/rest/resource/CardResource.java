package de.gtt.rest.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
//	@Path("/card")
	@Produces(MediaType.TEXT_XML)
	public List<Card> getCard() {
		return CardService.getAll();
	}
}
