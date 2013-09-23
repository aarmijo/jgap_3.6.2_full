package org.epes.sgm.client;

import org.codehaus.jettison.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EpesClientGet {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/epes-sgm-restful/rest/optimize/get?o1=1");

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

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