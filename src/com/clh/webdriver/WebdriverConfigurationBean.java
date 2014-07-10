package com.clh.webdriver;

/**
 * @version 9/07/2014
 * @author <a href="mailto:vpandugayala@castlighthealth.com">Raghuram</a>
 *
 */

public class WebdriverConfigurationBean {


	private String webdriverHost;
	private int webdriverPort;
	private String browser;
	private String webSite;
	private boolean isHttps;
	
	
	public WebdriverConfigurationBean(String webdriverHost, int webdriverPort, String browser,
			String webSite,boolean isHttps) {
		this.webdriverHost = webdriverHost;
		this.webdriverPort = webdriverPort;
		this.browser = browser;
		this.webSite = webSite;
		this.isHttps = isHttps;
	}
	
	public WebdriverConfigurationBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the webdriverHost
	 */
	public String getWebdriverHost() {
		return webdriverHost;
	}
	
	/**
	 * @return the webdriverPort
	 */
	public int getWebdriverPort() {
		return webdriverPort;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * @return the isHttps
	 */
	public boolean isHttps() {
		return isHttps;
	}
}
