package com.clh.webdriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


/**
 * @author <a href="mailto:vpandugayala@castlighthealth.com">Raghuram</a>
 */

public class TestRemoteWebdriver extends RemoteWebDriver {
	
	public TestRemoteWebdriver() {
		// TODO Auto-generated constructor stub
	}

	public ThreadLocal<RemoteWebDriver> webdriverThreadLocal = new ThreadLocal<RemoteWebDriver>();
	private ThreadLocal<WebdriverConfigurationBean> statusThreadLocal = new ThreadLocal<WebdriverConfigurationBean>();
	protected static final Logger logger = Logger.getLogger(RemoteWebDriver.class);
	
	
	public WebdriverConfigurationBean getStatusHolderInstance() {
		return this.statusThreadLocal.get();
	}

	public void setStatusHolderInstance(WebdriverConfigurationBean handler_ref) {
		this.statusThreadLocal.set(handler_ref);
	} 
	
	public void setRemoteWebDriver(RemoteWebDriver driver) {
		this.webdriverThreadLocal.set(driver);
	}
	
	/**
	 * Opens webpage
	 * @param arg0
	 */
	public void open(String arg0) {
		webdriverThreadLocal.get().get(arg0);
	}
	
	public void click(By by){
		webdriverThreadLocal.get().findElement(by).click();
	}
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param by
	 */
	public void isElementClickable(By by){
		(new WebDriverWait(webdriverThreadLocal.get(), 60, 1000)).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	/**
	 * Screenshot
	 */
	public void screenShot() {
		
		String timeStamp = getDateTime();
		if(statusThreadLocal.get() != null && webdriverThreadLocal.get()!= null){
			String browserName=statusThreadLocal.get().getBrowser();
			String imageName = "screenshot_"+browserName+"_"+timeStamp + ".png";
			String imagePath = new File("").getAbsolutePath()+File.separator+"../"+"report"+File.separator+imageName;
			WebDriver augmentedDriver = new Augmenter().augment((webdriverThreadLocal.get()));
			if(augmentedDriver != null){
				File scrFile = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
				System.out.println("The Source file : "+ scrFile);
				try {
					FileUtils.copyFile(scrFile, new File(imagePath));
				} catch (IOException e) {
					e.printStackTrace();
				}
		        System.out.println("Captured screenshot");
		        Reporter.log("<a href=\""+imageName+"\">screenshot_"+browserName+"</a>");
		        String str = "home/raghuram/workspace/akshu/report/";
		        Reporter.log("<img src=\"file:///" + str + imageName + "\" alt=\"\"/><br />");
			}
		}
	}
	
	
	public static String getDateTime() {
		// Milliseconds are requiredto keep file names unique as Selenium runs
		// can be very fast.
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	
	public void isAlertPresent(int timeoutInSec){
		(new WebDriverWait(webdriverThreadLocal.get(), timeoutInSec, 1000)).until(ExpectedConditions.alertIsPresent());
	}
	

	/**
	 * Waits for specified page element to load. Timeout and sleep time needs to
	 * be specified
	 * 
	 * @param webElementLocator
	 *            locator of web element to wait for to load
	 * @param timeOutInSeconds
	 *            wait time out in seconds
	 * @param sleepInMillis
	 *            sleep time in ms
	 */
	public  void waitForPageElementToLoad(final By by, int timeoutInSec) {
		(new WebDriverWait(webdriverThreadLocal.get(), timeoutInSec, 1000))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						WebElement element = null;
						try {
							element = findElement(by);
						} catch (NoSuchElementException e) {
							 Reporter.log("Elemetn  is not present "+by+":: Retrying....." );
						}
						return (element != null);
					}
				});
	}
	
	
	public void pause(String arg0) {

		try {
			int milisec = Integer.parseInt(arg0);
			Thread.sleep(milisec);
		} catch (Exception e) {
			System.err.println();
		}
	}
	
	public void navigateBack(){
		webdriverThreadLocal.get().navigate().back();
	}
	
	public void waitForElementToLoad(By by) {
		waitForPageElementToLoad(by, 60);
	}
	
	public void sendKeys(By by, String str){
		waitForElementToLoad(by);
		webdriverThreadLocal.get().findElement(by).sendKeys(str);
	}
	
	public Boolean isElementPresent(By by){
		if(findElement(by) != null){
			return true;
		}else{
			return false;
		}
	}
	
	public WebElement findElement(By by){
		//waitForElementToLoad(by);
		return webdriverThreadLocal.get().findElement(by);
	}
	
	public void selectFromDropDown(By by,String value){
		WebElement select = findElement(by);
		org.openqa.selenium.support.ui.Select  dropDown = new org.openqa.selenium.support.ui.Select(select);      
		dropDown.selectByValue(value);
	}
	
	public void switchToFrame(){
		WebElement frameName = findElement(By.cssSelector("div#pagelet_app_runner>iframe"));
		webdriverThreadLocal.get().switchTo().frame(frameName);
	}
	
	public WebElement framName(By by){
		 return webdriverThreadLocal.get().findElement(by);
	}
}
