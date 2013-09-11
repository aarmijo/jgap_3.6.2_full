package com.tecnalia.epes.tamoin.util.cmis;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ObjectId;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamImpl;

import com.tecnalia.epes.tamoin.util.cmis.utils.CmisUtils;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CMISConnector {

	private Session session;
	private Logger logger;
	private String docId;
	private String folderId;
	
	public CMISConnector() {
		
		// Logger
		this.logger = Logger.getLogger(CMISConnector.class.getName());
		this.logger.setLevel(Level.INFO);
		
		// Read properties from cmis.config.properties
		Properties properties = null;
		try {
			properties = CmisUtils.load("cmis.config.properties");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String host = properties.getProperty("cmis.host", "localhost");
		String port = properties.getProperty("cmis.port", "9090");
		String user = properties.getProperty("cmis.user", "admin");
		String password = properties.getProperty("cmis.password", "admin");
		this.docId = properties.getProperty("cmis.docId");
		this.folderId = properties.getProperty("cmis.folderId");
		
		// default factory implementation
		SessionFactory factory = SessionFactoryImpl.newInstance();
		Map<String, String> parameter = new HashMap<String, String>();
		
		// user credentials
		parameter.put(SessionParameter.USER, user);
		parameter.put(SessionParameter.PASSWORD, password);
		
		// connection settings
		parameter.put(SessionParameter.ATOMPUB_URL, "http://" + host + ":" + port + "/alfresco/service/cmis");
		parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		
		List<Repository> repositories = factory.getRepositories(parameter);
		for (Repository repository : repositories) {
			logger.info("Found VCN repository: " + repository.getName() + 
					", id: "+ repository.getId());
		}
		// get the first repository
		Repository repository = repositories.get(0);		
		parameter.put(SessionParameter.REPOSITORY_ID, repository.getId());
		
		this.session = factory.createSession(parameter);
	}
	
	/**
	 * @return document InputStream
	 */
	public InputStream readXlsFileFromVCN() {
		CmisObject object = session.getObject(session.createObjectId(this.docId));
		Document document = (Document) object;	
		logger.info("Document read: " + document.getName());
		return document.getContentStream().getStream();
	}	

	public void saveGanttChartInVCN (byte[] content) {		
		
		Folder destinationFolder = (Folder) session.getObject(this.folderId);

		String timestamp = (new Timestamp((new java.util.Date()).getTime())).toString();		
		timestamp = timestamp.replaceFirst(":", "h");
		timestamp = timestamp.replaceFirst(":", "m");
		
		String name = "TamoinGanttChart-" + timestamp + "s.jpg";

		// properties
		// (minimal set: name and object type id)
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
		properties.put(PropertyIds.NAME, name);

		// content			
		InputStream stream = new ByteArrayInputStream(content);
		ContentStream contentStream = new ContentStreamImpl(name,
				BigInteger.valueOf(content.length), "image/jpeg", stream);

		// create a major version
		Document newDoc = destinationFolder.createDocument(properties,
				contentStream, VersioningState.MAJOR);
	}
	
	public static void main(String[] args) {
		CMISConnector connector = new CMISConnector();
		//connector.saveGanttChartInVCN();
		InputStream is = connector.readXlsFileFromVCN();		
	}
}
