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
		props.load(url.openStream());
		return props;
	}
}
