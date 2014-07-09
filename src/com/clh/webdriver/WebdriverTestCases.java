package com.clh.webdriver;

import java.net.URL;

import junit.framework.TestCase;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * 
 * @author <a href="mailto:vpandugayala@castlighthealth.com">Raghuram</a>
 *
 */

public class WebdriverTestCases extends TestCase{

	public static TestRemoteWebdriver driver = new TestRemoteWebdriver(); 
	private RemoteWebDriver rdriver = null;
	private WebdriverConfigurationBean instance = null;
	
	protected String website = null;
	protected boolean isHttps ;
	
	public WebdriverTestCases() {
		super();
	}
	
	public WebdriverTestCases(String name){
		super(name);
	}
	
	@BeforeMethod(groups = { "default", "example" }, alwaysRun = true)
	@Parameters({ "webdriverHost", "webdriverPort", "browser", "webSite","platform","isHttps","version"})
	public void startSession(String webdriverHost, int webdriverPort,
			String browser, String webSite, String platform, boolean isHttps, @Optional("") String version) throws Exception {
		
		org.openqa.selenium.Platform platform1;
		DesiredCapabilities capability = null;
		
		System.out.println("Brower:  " + browser);
		System.out.println("Host : " + webdriverHost);
		System.out.println("Port : " + webdriverPort);
		platform1 = setPlatform(platform);
		capability = setBrowser(browser);
		setBrowserCapabilites(capability, platform1, version);
	
		//rdriver = new RemoteWebDriver(new URL("http://"+ webdriverHost + ":" + webdriverPort + "/wd/hub"),capability);
		rdriver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),capability);
		driver.setFileDetector(new LocalFileDetector());	
		instance = new WebdriverConfigurationBean(webdriverHost, webdriverPort, browser, webSite, isHttps);
		this.website = webSite;
		this.isHttps = isHttps;
		
		driver.setRemoteWebDriver(rdriver);
		driver.setStatusHolderInstance(instance);
	}
	
	/*
	 * @return Platform object
	 */
	public Platform setPlatform(String platform){
		
		if(platform.equalsIgnoreCase("LINUX")){
			return Platform.LINUX;
		}else if(platform.equalsIgnoreCase("WINDOWS")) {
			return Platform.WINDOWS;
		}else if(platform.equalsIgnoreCase("MAC")){
			return Platform.MAC;
		}else if(platform.equalsIgnoreCase("ANDROID")){
			return Platform.ANDROID;
		}else if(platform.equalsIgnoreCase("WIN8")){
			return Platform.WIN8;
		}else if(platform.equalsIgnoreCase("XP")){
			return Platform.XP;
		}else if(platform.equalsIgnoreCase("VISTA")){
			return Platform.VISTA;
		}else if(platform.equalsIgnoreCase("UNIX")){
			return Platform.UNIX;
		}
		return Platform.ANY;
	}
	
	public DesiredCapabilities setBrowser(String browser){
		
		if(browser.equalsIgnoreCase("firefox")) {
			return DesiredCapabilities.firefox();
		}else if(browser.equalsIgnoreCase("chrome")) {
			return DesiredCapabilities.chrome();
		}else if(browser.equalsIgnoreCase("internetExplorer")) {
			return DesiredCapabilities.internetExplorer();
		}else if(browser.equalsIgnoreCase("android")) {
			System.out.println("[Debug] Android.....");
			return DesiredCapabilities.android();
		}else if(browser.equalsIgnoreCase("ipad")) {
			return DesiredCapabilities.ipad();
		}else if(browser.equalsIgnoreCase("iphone")) {
			return DesiredCapabilities.iphone();
		}else if(browser.equalsIgnoreCase("safari")) {
			return DesiredCapabilities.safari();
		}else if(browser.equalsIgnoreCase("opera")) {
			return DesiredCapabilities.opera();
		}else if(browser.equalsIgnoreCase("htmlunit")) {
			return DesiredCapabilities.htmlUnit();
		}
		
		return null;
	}
	
	public void setBrowserCapabilites(DesiredCapabilities capability, Platform platform, String version){

		//capability.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setPlatform(platform);
		capability.setVersion(version);
	}

	@AfterMethod(groups = { "default", "example" }, alwaysRun = true)
	public void tearDown() {
		try {
			if(driver.webdriverThreadLocal.get()!=null)
				driver.webdriverThreadLocal.get().quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
