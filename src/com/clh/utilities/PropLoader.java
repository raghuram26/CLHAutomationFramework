package com.clh.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @version 9/07/2014
 * @author <a href="mailto:vpandugayala@castlighthealth.com">Raghuram</a>
 *
 */

public class PropLoader {
	
	private static final String TEST_PROPERTIES = "/node.props";
	private static Properties test_properties;
	private static Properties file_properties;
	private static Properties stream_properties;

	public static Properties getProperties() {
		if (test_properties == null) {
			test_properties = new Properties();
			try {
				test_properties.load(PropLoader.class
						.getResourceAsStream(TEST_PROPERTIES));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return test_properties;
	}
	
	public static Properties getProperties(String file) {

		file_properties = new Properties();
			try {
				file_properties.load(PropLoader.class
						.getResourceAsStream(file));
			} catch (IOException e) {
			}
	
		return file_properties;
	}
	
	
	public static Properties getPropertiesFromFile(String file)
			throws IOException {

		stream_properties = new Properties();
		File f = new File(file);
		System.out.println("file....." + file);
		FileInputStream is = new FileInputStream(f);
		stream_properties.load(is);
		return stream_properties;
	}

	public static int getPropertyIntvalue(String key){
		
		return Integer.parseInt(test_properties.getProperty(key));
		
	}
}
