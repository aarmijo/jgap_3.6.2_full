package org.epes.sgm.client;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EpesClientPost {

	public static void main(String[] args) {

		try {			
			
			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/epes-sgm-restful/rest/optimize/post");

			JSONObject input = new JSONObject();
			input.put("o1", "1");
			input.put("i1", "null");
			input.put("i2", "null");
			input.put("i3", "null");
			input.put("o2", "null");
			
			ClientResponse response = webResource.type("application/json").accept("application/json")
					.post(ClientResponse.class, input.toString());

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);
			
			JSONObject optimizationResult = new JSONObject(output);
			
			System.out.println("EPES service was executed. The optimization parameter, " +
					"o1=" + optimizationResult.getString("o1") + " led to the next optimization results:");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
