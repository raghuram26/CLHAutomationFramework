package com.clh.webdriver;

import java.util.Properties;

import com.clh.utilities.PropLoader;

/**
 * @version 9/07/2014
 * @author <a href="mailto:vpandugayala@castlighthealth.com">Raghuram</a>
 *
 */

public class TestConfiguration {

	private static Properties props;
	private static TestConfiguration TestConfiguration = null;
	
	static {

		String testdatafilepath = System.getProperty("local.props.file");
		System.out.println("local.props.file value is " + System.getProperty("local.props.file"));

		try {
			props = PropLoader.getPropertiesFromFile(testdatafilepath);
		} catch (Exception e) {
			throw new AssertionError("Failed to load test data configuration:"
					+ e.getMessage());
		}
	}
	
	public TestConfiguration() {
		// TODO Auto-generated constructor stub
	}
	public static TestConfiguration getInstance() {
		if (TestConfiguration == null) {
	         TestConfiguration = new TestConfiguration();
	     }
		return TestConfiguration;
	}
	
	public String getUrl(){
		return props.getProperty("url");
	}
}
