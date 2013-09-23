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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

// limit this class to the logic orchestration
public class EpesDataMinerBase {

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
				
				Node node = doc.getElementsByTagName("content").item(0);				
				 
				String mimeType = ((Element)node).getAttribute("type");
				System.out.println("MimeType: " + mimeType);
				
				if (!mimeType.equals("")) {
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

					if (response.getStatus() != 200 && response.getStatus() != 404 ) {
						throw new RuntimeException("Failed : HTTP error code : "
								+ response.getStatus());
					}

					byteArray = response.getEntity(byte[].class);

					//System.out.println(new String(byteArray) + "\n");

					// save the content as a file depending on mimetype
					if (mimeType.equals("text/html")) {
						Date date= new Date();	
						String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
						//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
						String strFilePath = "data//html//demo-" + timeStamp + ".html";
						try {
							FileOutputStream fos = new FileOutputStream(strFilePath);					

							/*
							 * To write byte array to a file, use void write(byte[]
							 * bArray) method of Java FileOutputStream class.
							 * 
							 * This method writes given byte array to a file.
							 */

							fos.write(byteArray);

							/*
							 * Close FileOutputStream using, void close() method of
							 * Java FileOutputStream class.
							 */

							fos.close();

						} catch (FileNotFoundException ex) {
							System.out.println("FileNotFoundException : " + ex);
						} catch (IOException ioe) {
							System.out.println("IOException : " + ioe);
						}
					} else if (mimeType.equals("application/pdf")) {
						Date date= new Date();	
						String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
						//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
						String strFilePath = "data//pdf//demo-" + timeStamp + ".pdf";
						try {
							FileOutputStream fos = new FileOutputStream(strFilePath);					

							/*
							 * To write byte array to a file, use void write(byte[]
							 * bArray) method of Java FileOutputStream class.
							 * 
							 * This method writes given byte array to a file.
							 */

							fos.write(byteArray);

							/*
							 * Close FileOutputStream using, void close() method of
							 * Java FileOutputStream class.
							 */

							fos.close();

						} catch (FileNotFoundException ex) {
							System.out.println("FileNotFoundException : " + ex);
						} catch (IOException ioe) {
							System.out.println("IOException : " + ioe);
						}						
					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
