package com.tecnalia.epes.tamoin.util.cmis.utils;

import java.net.URL;
import java.util.Properties;

public class CmisUtils {
	/**
	 * 
	 * @param propsName
	 * @return props
	 * @throws Exception
	 */
	public static Properties load(String propsName) throws Exception {
		Properties props = new Properties();
		URL url = ClassLoader.getSystemResource(propsName);		
		// ClassLoader.getSystemResource(propsName) looks up a resource from the system classloader. 
		// If the url is null, the application is being run in a web environment and the resource
		// should be obtained from the web application context
		if (url == null) {
			url = Thread.currentThread().getContextClassLoader().getResource(propsName);
			//url = CmisUtils.class.getClassLoader().getResource(propsName);
		}
		props.load(url.openStream());
		return props;
	}
}
