package com.freecrm.uiAutomation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResourceUtil {

	public static String getResourcePath(String path) {
		return System.getProperty("user.dir") + "/" + path;
	}

	public static FileInputStream getResourceInputStream(String path) throws FileNotFoundException {
		return new FileInputStream(getResourcePath(path));
	}

}
