package com.clh.pageobjects;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.clh.webdriver.WebdriverTestCases;

public class BasePage extends WebdriverTestCases {
   
   private By LOGO = By.id("castlight_logo");
   private By NEED_HELP = By.linkText("Need Help?");
   private By BOOKMARKS = By.linkText("Bookmarks");
   private By FULL_NAME = By.id("full_name");
   private By INBOX = By.linkText("Inbox");
   private By YOUR_ACCOUNT = By.linkText("Your Account");
   private By LOG_OUT = By.linkText("Log Out");
   private By VERSION_INFO = By.id("version_info");
   private By FOOTER_COPYRIGHT = By.id("footer_copyright");
   private By OVERVIEW = By.linkText("Overview");
   private By SECURITY = By.linkText("Security");
   private By PRIVACY = By.linkText("Privacy");
   private By TERMS_OF_USE = By.linkText("Terms of use");
   private By FEEDBACK = By.linkText(" Feedback ");
   private By HOME = By.xpath(".//*[@id='tabs_holder']/li[1]/a");
   private By FIND_CARE = By.xpath(".//*[@id='tabs_holder']/li[2]/a"); 
   private By PAST_CARE = By.xpath(".//*[@id='tabs_holder']/li[3]/a");
   private By YOUR_PLAN = By.xpath(".//*[@id='tabs_holder']/li[4]/a");
   private By ZIP_CODE = By.id("address_text");
   private By SEARCH = By.id("search_keyword");
   private By NEED_HELP_CLOSE = By.xpath(".//*[@id='need_help_popup']/div/a");
   
   
   public BasePage(){
      
   }
   
   public Boolean isNamePresent(){
      return driver.isElementPresent(FULL_NAME);
   }
   public void logout(){
      driver.click(FULL_NAME);
      Reporter.log("Clicked on Dropdown");
      driver.click(LOG_OUT);
      Reporter.log("Clicked on Log out");
   }

   public void clickNeedHelp(){
      driver.click(NEED_HELP);
      Reporter.log("Clicked on NeedHelp");
   }
   
   public void clickOnPrivacy(){
      driver.click(PRIVACY);
      Reporter.log("Clicked on Privacy");
   }
   
   public void clickOnOverview(){
      driver.click(OVERVIEW);
      Reporter.log("Clicked on Overview");
   }
   
   public void clickOnSecurity(){
      driver.click(SECURITY);
      Reporter.log("Clicked on Security");
   }
   
   public void clickOnTermsOfUse(){
      driver.click(TERMS_OF_USE);
      Reporter.log("Clicked on Terms of use");
   }
   
   public void clickOnFeedback(){
      driver.click(FEEDBACK);
      Reporter.log("Clicked on Feedback");
   }
   
   public void clickOnFindCare(){
      driver.click(FIND_CARE);
      Reporter.log("Clicked on FindCare");
            
   }
   
   public void closeNeedHelp(){
      driver.click(NEED_HELP_CLOSE);
      Reporter.log("Closed NeedHelp");
   }
   
   public void clickOnBookmarks(){
      driver.click(BOOKMARKS);
      Reporter.log("Clicked on Bookmarks");
   }
}
