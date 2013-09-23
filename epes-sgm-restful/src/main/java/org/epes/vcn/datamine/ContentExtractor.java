package org.epes.vcn.datamine;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class ContentExtractor {

	private String tagName;
	private ArrayList<Content> contentList;

	public ArrayList<Content> getContentList() {
		return contentList;
	}

	private String host, port, ticket;

	public ContentExtractor(String host, String port, String tagName, String ticket) 
			throws ClientHandlerException, UniformInterfaceException, JSONException, 
			ParserConfigurationException, SAXException, IOException {
		this.host = host;
		this.port = port;
		this.tagName = tagName;
		this.ticket = ticket;
		contentList = new ArrayList<Content>();
		retrieveNodes();
	}

	public void retrieveNodes() throws ClientHandlerException,
			UniformInterfaceException, JSONException,
			ParserConfigurationException, SAXException, IOException {

		Logger logger = Logger.getLogger(ContentExtractor.class.getName());
		logger.setLevel(Level.INFO);
		
		// get the nodes that contain a particular tag
		Client client = Client.create();

		WebResource webResource = client.resource("http://" + host + ":" + port
				+ "/alfresco/service/api/tags/workspace/SpacesStore/" + tagName
				+ "/nodes" + "?alf_ticket=" + ticket);

		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		JSONArray outputArray = new JSONArray(response.getEntity(String.class));

		client.destroy();

		// process the nodes
		for (int i = 0; i < outputArray.length(); i++) {
			JSONObject output = outputArray.getJSONObject(i);
			logger.info("NodeRef " + i + " = " + output.get("nodeRef"));
			
			// get the properties of the node as xml
			client = Client.create();
			webResource = client.resource("http://" + host + ":" + port
					+ "/alfresco/service/api/node/workspace/SpacesStore/"
					+ output.get("nodeRef").toString().substring(24)
					+ "?alf_ticket=" + ticket);
			response = webResource.accept(MediaType.APPLICATION_ATOM_XML).get(
					ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			// the content properties
			byte[] byteArray = response.getEntity(byte[].class);
			//System.out.println(new String(byteArray));

			// get the content Mimetype
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new ByteArrayInputStream(byteArray));

			doc.getDocumentElement().normalize();

			Node node = doc.getElementsByTagName("content").item(0);

			// the mimeType
			String mimeType = ((Element) node).getAttribute("type");
			logger.info("Mimetype " + i + " = " + mimeType);
			
			// get the content name			
			node = doc.getElementsByTagName("title").item(0);
			// the content file name
			String name = ((Element) node).getTextContent();
			
			client.destroy();

			if (!mimeType.equals("")) {
				// get the content of the node
				client = Client.create();
				webResource = client.resource("http://" + host + ":" + port
						+ "/alfresco/service/api/node/contentcm:"
						+ "content/workspace/SpacesStore/"
						+ output.get("nodeRef").toString().substring(24)
						+ "?alf_ticket=" + ticket);
				response = webResource.accept(
						MediaType.APPLICATION_OCTET_STREAM).get(
						ClientResponse.class);

				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus());
				}

				byteArray = response.getEntity(byte[].class);

				// add the mimeType, content and name to the content list
				contentList
						.add(new Content(mimeType, byteArray, name));
			}
		}
		client.destroy();
	}
}
