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

import com.tecnalia.epes.tamoin.WindFarm;
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
		
		// Set the alfresco object factory
		parameter.put(SessionParameter.OBJECT_FACTORY_CLASS, "org.alfresco.cmis.client.impl.AlfrescoObjectFactoryImpl");
		
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

	public void saveGanttChartInVCN (byte[] content, double[] kpis, boolean leverageBC1ContentModel, WindFarm[] windFarms, 
			boolean optimizeCosts, boolean optimizeAvailability, String weekNumber, double fitnessValue) {		
		
		Folder destinationFolder = (Folder) session.getObject(this.folderId);

		String timestamp = (new Timestamp((new java.util.Date()).getTime())).toString();		
		timestamp = timestamp.replaceFirst(":", "h");
		timestamp = timestamp.replaceFirst(":", "m");
		
		String name = "TamoinGanttChart-" + timestamp + "s.jpg";
				
		Map<String, Object> properties = new HashMap<String, Object>();		
		if (leverageBC1ContentModel) {
			properties.put(PropertyIds.OBJECT_TYPE_ID, "D:epesbc1:content,P:epesbc1:knowledge,P:epesbc1:process,P:epesbc1:history");
			properties.put(PropertyIds.NAME, name);
			// aspect epesbc1:knowledge properties 
			properties.put("epesbc1:knowledge_parameter_1", weekNumber);
			properties.put("epesbc1:knowledge_parameter_2", optimizeCosts);
			properties.put("epesbc1:knowledge_parameter_3", optimizeAvailability);
			properties.put("epesbc1:knowledge_parameter_4",
					windFarms[0].getWindSpeedMonday() + ", " +
					windFarms[0].getWindSpeedTuesday() + ", " +
					windFarms[0].getWindSpeedWednesday() + ", " + 
					windFarms[0].getWindSpeedThursday() + ", " +
					windFarms[0].getWindSpeedFriday() + ", ");
			properties.put("epesbc1:knowledge_parameter_5",
					windFarms[1].getWindSpeedMonday() + ", " +
					windFarms[1].getWindSpeedTuesday() + ", " +
					windFarms[1].getWindSpeedWednesday() + ", " + 
					windFarms[1].getWindSpeedThursday() + ", " +
					windFarms[1].getWindSpeedFriday() + ", ");
			properties.put("epesbc1:knowledge_parameter_6",
					windFarms[2].getWindSpeedMonday() + ", " +
					windFarms[2].getWindSpeedTuesday() + ", " +
					windFarms[2].getWindSpeedWednesday() + ", " + 
					windFarms[2].getWindSpeedThursday() + ", " +
					windFarms[2].getWindSpeedFriday() + ", ");
			// aspect epesbc1:process properties 
			properties.put("epesbc1:business_process_1", "TAMOIN maintenance process");
			properties.put("epesbc1:business_process_1", "EPES Service: Short term scheduling (5 days horizont)");
			properties.put("epesbc1:business_process_3", fitnessValue);
			// aspect epesbc1:history properties 			
			properties.put("epesbc1:optimization_result_1", kpis[0]);
			properties.put("epesbc1:optimization_result_2", kpis[1]);
			properties.put("epesbc1:optimization_result_3", kpis[2]);
			properties.put("epesbc1:optimization_result_4", kpis[3]);
			properties.put("epesbc1:optimization_result_5", kpis[4]);
			properties.put("epesbc1:optimization_result_6", kpis[5]);
			properties.put("epesbc1:optimization_result_7", kpis[6]);
			properties.put("epesbc1:optimization_result_8", kpis[7]);
			properties.put("epesbc1:optimization_result_9", kpis[8]);
			properties.put("epesbc1:optimization_result_10", kpis[9]);
			properties.put("epesbc1:optimization_result_11", kpis[10]);
			properties.put("epesbc1:optimization_result_12", kpis[11]);
			properties.put("epesbc1:optimization_result_13", kpis[12]);
			properties.put("epesbc1:optimization_result_14", kpis[13]);
		} else {
			// properties	
			// (minimal set: name and object type id)
			properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document,P:cm:titled");
			properties.put(PropertyIds.NAME, name);
			// description including KPI values
			StringBuffer descriptionProperty = new StringBuffer();
			descriptionProperty.append("Week number to be planned = " + weekNumber + ", ");
			descriptionProperty.append("Cost optimization = " + optimizeCosts + ", ");
			descriptionProperty.append("Availability optimization = " + optimizeAvailability + ", ");
			descriptionProperty.append("Wind farm One forecasted wind speeds (m/s) = " + 
					windFarms[0].getWindSpeedMonday() + ", " +
					windFarms[0].getWindSpeedTuesday() + ", " +
					windFarms[0].getWindSpeedWednesday() + ", " + 
					windFarms[0].getWindSpeedThursday() + ", " +
					windFarms[0].getWindSpeedFriday() + ", ");
			descriptionProperty.append("Wind farm Two forecasted wind speeds (m/s) = " + 
					windFarms[1].getWindSpeedMonday() + ", " +
					windFarms[1].getWindSpeedTuesday() + ", " +
					windFarms[1].getWindSpeedWednesday() + ", " + 
					windFarms[1].getWindSpeedThursday() + ", " +
					windFarms[1].getWindSpeedFriday() + ", ");
			descriptionProperty.append("Wind farm Three forecasted wind speeds (m/s) = " + 
					windFarms[2].getWindSpeedMonday() + ", " +
					windFarms[2].getWindSpeedTuesday() + ", " +
					windFarms[2].getWindSpeedWednesday() + ", " + 
					windFarms[2].getWindSpeedThursday() + ", " +
					windFarms[2].getWindSpeedFriday() + ", ");
			descriptionProperty.append("TAMOIN process name = TAMOIN maintenance process, ");
			descriptionProperty.append("EPES Service = Short term scheduling (5 days horizont), ");
			descriptionProperty.append("Optimization fitness value = " + fitnessValue + ", ");
			descriptionProperty.append("Number of days with planned tasks in wind farm One = " + kpis[0] + ", ");
			descriptionProperty.append("Number of tasks / Number of days with planned tasks in windfarm One = " + kpis[1] + ", ");
			descriptionProperty.append("Number of days with planned tasks in wind farm Two = " + kpis[2] + ", ");
			descriptionProperty.append("Number of tasks / Number of days with planned tasks in windfarm Two = " + kpis[3] + ", ");
			descriptionProperty.append("Number of days with planned tasks in wind farm Three = " + kpis[4] + ", ");
			descriptionProperty.append("Number of tasks / Number of days with planned tasks in windfarm Three = " + kpis[5] + ", ");
			descriptionProperty.append("Number of days with planned tasks in All wind farms = " + kpis[6] + ", ");
			descriptionProperty.append("Number of tasks / Number of days with planned tasks in All wind farms = " + kpis[7] + ", ");
			descriptionProperty.append("Km. travelled by the maintenance teams = " + kpis[8] + ", ");
			descriptionProperty.append("CO2 Emissions (g) = " + kpis[9] + ", ");
			descriptionProperty.append("Average Windfarm One Availability = " + kpis[10] + ", ");
			descriptionProperty.append("Average Windfarm Two Availability = " + kpis[11] + ", ");
			descriptionProperty.append("Average Windfarm Three Availability = " + kpis[12] + ", ");
			descriptionProperty.append("Average Availability = " + kpis[13] + ", ");
			properties.put("cm:description", descriptionProperty.toString());
		}
		
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
