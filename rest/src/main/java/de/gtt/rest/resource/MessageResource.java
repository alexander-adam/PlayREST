package de.gtt.rest.resource;


import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.gtt.rest.StartRestServer;

@Path("message")
public class MessageResource {
	final GsonBuilder builder = new GsonBuilder();
	final Gson gson = builder.create();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String message() {
		return "Yea! It's " + getCurrentTime();
	}

	@GET @Produces( MediaType.TEXT_PLAIN )
	@Path("user/{user}")
	public String message(@PathParam("user") String user) {
		return String.format("Benutzer = %s", user);
	}

	// http://localhost:8080/rest/message/user/chris/search/kitesurfing
	@GET
	@Produces( MediaType.TEXT_PLAIN )
	@Path("user/{user}/search/{search}")
	public String message(@PathParam("user") String user, @PathParam("search") String search) {
		return String.format("Benutzer = %s, Suchstring = %s", user, search);
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey " + getCurrentTime() + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey " + getCurrentTime() + "</body></h1>" + "</html> ";
	}

	// http://localhost:8080/rest/message/stop
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("stop")
	public String stop() {
		StartRestServer.stopServer();
		return "The server is being stopped...";
	}

	private String getCurrentTime() {
		return new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(new Date());
	}

	@GET
	@Path("serverinfo")
	@Produces(MediaType.TEXT_XML)
	public ServerInfo serverinfo() {
		ServerInfo info = new ServerInfo();
		info.name = System.getProperty("os.name");
		info.version = System.getProperty("os.version");

		return info;
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testJSON() {
		ServerInfo info = new ServerInfo();
		info.name = System.getProperty("os.name");
		info.version = System.getProperty("os.version");

		String json = gson.toJson(info);

		// return HTTP response 200 in case of success
		Response result = Response.status(200).entity(json).build();
		return result;
	}

	String JSON = "{\"friends\": [{\"FirstName\": \"John\",\"LastName\": \"Doe\"},\"FirstName\": \"Ann\",\"LastName\": \"Wellington\"},{\"FirstName\": \"Sabrina\",\"LastName\": \"Burke\"}]}";

//	@GET
//	@Path("/json")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String testJSON() {
//		return JSON;
//	}

	@GET
	@Path("/json2")
	@Produces(MediaType.APPLICATION_JSON)
	public ServerInfo serverinfoAsJSON() {
		ServerInfo info = new ServerInfo();
		info.name = System.getProperty("os.name");
		info.version = System.getProperty("os.version");

		return info;
	}

	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "RESTService Successfully started..";

		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
}