package org.epes.vcn.datamine;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

// this class represents a ticket for further calls to the Alfresco RESTFul API
// http://wiki.alfresco.com/wiki/Repository_RESTful_API_Reference
public class Ticket {

	private String ticket;

	private String host, port, username, password;

	public Ticket(String host, String port, String username, String password) 
			throws Exception, UniformInterfaceException, JSONException {
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		retrieveTicket();
	}

	public String getTicket() {
		return ticket;
	}

	public void retrieveTicket() throws ClientHandlerException,
			UniformInterfaceException, JSONException {

		Client client = Client.create();
		
		WebResource webResource = client.resource("http://" + host + ":" + port
				+ "/alfresco/service/api/login");

		JSONObject input = new JSONObject();
		input.put("username", username);
		input.put("password", password);

		ClientResponse response = webResource.type("application/json")
				.accept("application/json")
				.post(ClientResponse.class, input.toString());
	
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		JSONObject output = new JSONObject(response.getEntity(String.class));

		String ticket = (String) output.getJSONObject("data").get("ticket");

		this.ticket = ticket;

		client.destroy();
	}

}
