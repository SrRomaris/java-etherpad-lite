package net.gjerull.etherpad.client;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * A class for easily executing an HTTP GET request.<br />
 * <br />
 * Example:<br />
 * <br />
 * <code>
 * Request req = new GETRequest(url_object);<br />
 * String resp = req.send();<br />
 * </code>
 */
public class GETRequest implements Request {

	/** The url. */
	private final URL url;

	/**
	 * Instantiates a new GETRequest.
	 *
	 * @param url the URL object
	 */
	public GETRequest(final URL url) {
		this.url = url;
	}

	/**
	 * Sends the request and returns the response.
	 *
	 * @return String
	 * @throws Exception the exception
	 */
	public String send() throws Exception {
		final BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream(), StandardCharsets.UTF_8));
		final StringBuilder response = new StringBuilder();
		String buffer;
		while ((buffer = in.readLine()) != null) {
			response.append(buffer);
		}
		in.close();
		return response.toString();
	}
}
