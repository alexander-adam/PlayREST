package de.gtt.rest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

import de.gtt.rest.resource.CORSFilter;

public class StartRestServer {
	private static final int HTTP_PORT = 8080;

	private static HttpServer server;

	public static void main(String[] args) throws Exception {
		server = createHttpServer();
		server.start();
		System.out.println("Starting server...");
	}

	public static void stopServer() {
		Runnable r = new Runnable() {
			public void run() {
				try {
					Thread.sleep(2000);
					server.stop(0);
					System.out.println("Server is stopped.");
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t = new Thread(r);
		t.start();

		System.out.println("Stopping server...");
	}

	private static HttpServer createHttpServer() throws IOException {
		ResourceConfig resourceConfig = new PackagesResourceConfig("de.gtt.rest.resource");
		resourceConfig.getContainerResponseFilters().add(new CORSFilter());
		return HttpServerFactory.create(getServerURI(), resourceConfig);
	}

	private static URI getServerURI() {
//		String uri = "http://" + getHostName() + "/rest";
		String uri = "http://localhost:8080/rest";

		return UriBuilder.fromUri(uri).port(HTTP_PORT).build();
	}

	private static String getHostName() {
		String hostName = "localhost";

		try {
			hostName = InetAddress.getLocalHost().getCanonicalHostName();
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return hostName;
	}
}
