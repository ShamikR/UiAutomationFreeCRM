package com.freecrm.uiAutomation.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReaderUtil {
	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			prop.load(ResourceUtil.getResourceInputStream("src/main/resources/configfile/config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getPropertiesValue(String key) {
		return prop.getProperty(key);
	}
	
}
