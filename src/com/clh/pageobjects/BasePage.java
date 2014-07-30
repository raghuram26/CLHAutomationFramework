package com.clh.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.clh.webdriver.WebdriverTestCases;

public class BasePage extends WebdriverTestCases {

   private By LOGO = By.id("castlight_logo");
   private By NEED_HELP = By.linkText("Need Help?");
   private By BOOKMARKS = By.linkText("Bookmarks");
   private By FULL_NAME = By.id("full_name");
   private By INBOX = By.linkText("Inbox");
   private By YOUR_ACCOUNT = By.xpath(".//*[@id='user_menu']/div[2]/ul/li[2]");
   // By.linkText("Your Account");
   //private By LOG_OUT = By.linkText("Log Out");
   private By LOG_OUT = By.xpath(".//*[@id='logout_link']");
   private By VERSION_INFO = By.id("version_info");
   private By FOOTER_COPYRIGHT = By.id("footer_copyright");
   
   private By OVERVIEW = By.xpath(".//a[text()='Overview']");
   private By SECURITY = By.xpath(".//a[text()='Security']");
   private By PRIVACY = By.xpath(".//a[text()='Privacy']");
   private By TERMS_OF_USE = By.xpath(".//a[text()='Terms of use']");
   private By FEEDBACK = By.xpath(".//a[text()=' Feedback ']");
   
   private By HOME = By.xpath(".//*[@id='tabs_holder']/li[1]/a");
   private By FIND_CARE = By.xpath(".//*[@id='tabs_holder']/li[2]/a");
   private By PAST_CARE = By.xpath(".//*[@id='tabs_holder']/li[3]/a");
   private By YOUR_PLAN = By.xpath(".//*[@id='tabs_holder']/li[4]/a");
   private By ZIP_CODE = By.id("address_text");
   private By SEARCH = By.id("search_keyword");
   private By NEED_HELP_CLOSE = By.xpath(".//*[@id='need_help_popup']/div/a");
   private By FEEDBACK_CLOSE = By.xpath(".//*[@id='feedback_form']/a");
   private By INBOX_PAGE = By.id("inbox");
   private By BOOKMARKS_PAGE = By.xpath(".//*[@id='content_container']/div/h1");

   public BasePage() {

   }

   public Boolean isNamePresent() {
      return driver.isElementPresent(FULL_NAME);
   }

   public void logout() {
      clickOnName();
      driver.isElementClickable(LOG_OUT);
      driver.click(LOG_OUT);
      Reporter.log("Clicked on Log out");
   }

   public void clickNeedHelp() {
      driver.click(NEED_HELP);
      Reporter.log("Clicked on NeedHelp");
   }

   public void clickOnPrivacy() {
      driver.click(PRIVACY);
      Reporter.log("Clicked on Privacy");
   }

   public void clickOnOverview() {
      driver.click(OVERVIEW);
      Reporter.log("Clicked on Overview");
   }

   public void clickOnSecurity() {
      driver.click(SECURITY);
      Reporter.log("Clicked on Security");
   }

   public void clickOnTermsOfUse() {
      driver.click(TERMS_OF_USE);
      Reporter.log("Clicked on Terms of use");
   }

   public void clickOnFeedback() {
      driver.click(FEEDBACK);
      Reporter.log("Clicked on Feedback");
   }

   public void clickOnFindCare() {
      driver.click(FIND_CARE);
      Reporter.log("Clicked on FindCare");
   }

   public void clickOnPastCare(){
      driver.click(PAST_CARE);
      Reporter.log("Clicked on PastCare");
   }
   
   public void clickOnYourPlan(){
      driver.click(YOUR_PLAN);
      Reporter.log("Click on YourPlan");
   }
   
   public void closeNeedHelp() {
      driver.click(NEED_HELP_CLOSE);
      Reporter.log("Closed NeedHelp");
   }

   public void clickOnBookmarks() {
      driver.click(BOOKMARKS);
      Reporter.log("Clicked on Bookmarks");
   }

   public void clickOnInbox() {
      clickOnName();
      driver.click(INBOX);
      Reporter.log("Clicked on Inbox");
      if (driver.isElementPresent(INBOX_PAGE)) {
         Reporter.log("Inbox Opened");
      } else {
         Reporter.log("Inbox not opened");
      }
   }

   public void clickOnAccount() {
      clickOnName();
      driver.click(YOUR_ACCOUNT);
      Reporter.log("Clicked on YourAccount");
   }

   public void clickOnName() {
      driver.click(FULL_NAME);
      Reporter.log("Clicked on Name");
   }

   public void isLoginSuccessful() {
      if (driver.isElementPresent(FULL_NAME)) {
         Reporter.log("Logged in Successfully");
      } else {
         Reporter.log("Not Logged in");
      }
   }
   
   public void closeFeedBackForm(){
      driver.click(FEEDBACK_CLOSE);
      Reporter.log("Closed Feedback form");
   }
   
   public void enterProcedureName(String procedureName){
      driver.sendKeys(SEARCH, procedureName);
   }
}