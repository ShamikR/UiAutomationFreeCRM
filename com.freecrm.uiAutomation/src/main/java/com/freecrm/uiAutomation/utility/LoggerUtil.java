package com.freecrm.uiAutomation.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {
	private static boolean root = false;

	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clz) {
		if (root) {
			return Logger.getLogger(clz);
		} else {
			PropertyConfigurator
					.configure(ResourceUtil.getResourcePath("src/main/resources/configfile/log4j.properties"));
			root = true;
			return Logger.getLogger(clz);
		}
	}

}
