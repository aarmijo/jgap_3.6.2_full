package org.epes.vcn.datamine.test;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.ByteArrayInputStream;


public class EpesDataMiner {

	public static void main(String[] args) {

		try {

			// get the ticket
			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:9090/alfresco/service/api/login");

			JSONObject input = new JSONObject();
			input.put("username", "admin");
			input.put("password", "admin");

			ClientResponse response = webResource.type("application/json")
					.accept("application/json")
					.post(ClientResponse.class, input.toString());

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			JSONObject output = new JSONObject(response.getEntity(String.class));

			String ticket = (String) output.getJSONObject("data").get("ticket");

			System.out.println(ticket);

			client.destroy();

			// get the nodes that contain a particular tag
			client = Client.create();

			webResource = client
					.resource("http://localhost:9090/alfresco/service/api/tags/workspace/SpacesStore/testtag/nodes"
							+ "?alf_ticket=" + ticket);

			response = webResource.accept("application/json").get(
					ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			JSONArray outputArray = new JSONArray(
					response.getEntity(String.class));

			// process the nodes
			for (int i = 0; i < outputArray.length(); i++) {
				output = outputArray.getJSONObject(i);
				System.out.println("NodeRef " + i + " = "
						+ output.get("nodeRef"));

				// get the properties of the node as xml
				client = Client.create();
				webResource = client
						.resource("http://localhost:9090/alfresco/service/api/node/workspace/SpacesStore/"
								+ output.get("nodeRef").toString()
										.substring(24)
								+ "?alf_ticket="
								+ ticket);
				response = webResource.accept(MediaType.APPLICATION_ATOM_XML).get(
						ClientResponse.class);

				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus());
				}

				byte[] byteArray = response.getEntity(byte[].class);
				//System.out.println(new String(byteArray));
				
				// get the content Mimetype
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(new ByteArrayInputStream(byteArray));
				
				doc.getDocumentElement().normalize();
				
				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				NodeList nList = doc.getElementsByTagName("cmis:propertyString");
				 
				//System.out.println("----------------------------");
			 
				for (int temp = 0; temp < nList.getLength(); temp++) {
			 
					Node nNode = nList.item(temp);
			 
					//System.out.println("\nCurrent Element :" + nNode.getNodeName());
			 
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element) nNode;			 
						if (eElement.getAttribute("propertyDefinitionId").equals("cmis:contentStreamMimeType")) {
							System.out.println("Mimetipe : " + eElement.getElementsByTagName("cmis:value").item(0).getTextContent());	
							break;
						}
					}
				}
				
				// get the content of the node
				client = Client.create();
				webResource = client
						.resource("http://localhost:9090/alfresco/service/api/node/contentcm:content/workspace/SpacesStore/"
								+ output.get("nodeRef").toString()
										.substring(24)
								+ "?alf_ticket="
								+ ticket);
				response = webResource.accept(MediaType.APPLICATION_OCTET_STREAM).get(
						ClientResponse.class);

				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus());
				}

				byteArray = response.getEntity(byte[].class);

				//System.out.println(new String(byteArray) + "\n");
				
				// TODO save the content as a file
				// http://www.java-examples.com/write-byte-array-file-using-fileoutputstream

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
