package com.opencart.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	 
	public static Properties initializeProperties() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
		
	}
}
