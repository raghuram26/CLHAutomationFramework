package com.clh.pageobjects;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.clh.webdriver.TestConfiguration;
import com.clh.webdriver.WebdriverTestCases;

/**
 * @version 9/07/2014
 * @author <a href="mailto:vpandugayala@castlighthealth.com">Raghuram</a>
 *
 */

public class LoginPage extends WebdriverTestCases {
	
   private By EMAIL_ID = By.id("email_login");
   private By PASSWORD = By.id("password_login");
   private By LOGIN_BUTTON = By.name("commit");
   
	public LoginPage() {
	}
   
	public void openURL(){
	   driver.open(TestConfiguration.getInstance().getUrl());
	   Reporter.log("Opend URL :: " + TestConfiguration.getInstance().getUrl() + "\n");
	}
	//Setting Email id
	public void setEmailID(String emailID){
	   driver.sendKeys(EMAIL_ID, emailID);
	   Reporter.log("Entered Email id :: "  + emailID);
	}
	
	//Setting password
	public void setPassword(String password){
	   driver.sendKeys(PASSWORD, password);
	   Reporter.log("Entered password :: "+ password);
	}
	
	//clickingon login button
	public void clickLoginButton(){
	   driver.click(LOGIN_BUTTON);
	   Reporter.log("Clicked on Login button\n");
	}
	
}
