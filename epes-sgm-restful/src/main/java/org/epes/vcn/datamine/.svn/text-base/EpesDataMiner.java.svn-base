package org.epes.vcn.datamine;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jettison.json.JSONException;

import com.sun.jersey.api.client.UniformInterfaceException;

// limit this class to the logic orchestration
public class EpesDataMiner {

	public static void main(String[] args) 
			throws UniformInterfaceException, JSONException, Exception {

		Logger logger = Logger.getLogger(EpesDataMiner.class.getName());
		logger.setLevel(Level.INFO);
				
		// get the ticket
		Ticket ticket = new Ticket("localhost", "9090", "admin", "admin");
		logger.info(ticket.getTicket());
		
		// get the nodes content, the associated mime type and file name
		ContentExtractor contentExtractor = new ContentExtractor("localhost", "9090", "testtag", ticket.getTicket());
		ArrayList<Content> contentList = contentExtractor.getContentList();
		for (Content content : contentList) {
			//logger.info(content.getMimeType());
			//logger.info(new String(content.getContent()));
			//logger.info(content.getName());			
		}
		// write the content into predefined folders
		FileWriter.write(contentList);
		// write the content into a custom folder
		FileWriter.write(contentList, "D://tmp");
	}

}
