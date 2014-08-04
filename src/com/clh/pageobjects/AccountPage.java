package com.clh.pageobjects;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class AccountPage extends BasePage{
   
   private By ACCOUNT_TITLE = By.xpath(".//*[@id='content_container']/div/h1");
   private By PERSONAL_INFO_EDIT = By.xpath("(.//a[text()='Edit'])[1]");
   private By PERSONAL_INFO_CANCEL = By.xpath("(.//a[text()='Cancel'])[2]");
   private By FIRST_NAME_LABEL = By.xpath(".//label[contains(@for,'user_first_name')]");
   private By FIRST_NAME = By.id("user_first_name");
   private By LAST_NAME_LABEL = By.xpath(".//label[contains(@for,'user_last_name')]");
   private By LAST_NAME = By.id("user_last_name");
   private By USER_DOB_LABEL = By.xpath(".//label[contains(@for,'user_dob_month')]");
   private By USER_DOB_MONTH = By.id("user_dob_month");
   private By USER_DOB_DAY = By.id("user_dob_day");
   private By USER_DOB_YEAR = By.id("user_dob_year");
   private By EMAIL_ADDRESS_LABEL =By.xpath(".//label[contains(@for,'user_new_email')]");
   private By USER_NEW_EMAIL = By.id("user_new_email");
   private By TIME_ZONE_LABEL = By.xpath(".//label[contains(@for,'user_time_zone')]");
   private By USER_TIME_ZONE = By.id("user_time_zone");
   private By PERSONAL_INFORMATION_SAVE = By.xpath(".//*[@id='edit_personal_information_form']/div[7]/div");
   
   private By ACCOUNT_SECURITY_HEADER = By.xpath("//*[@id='account_security']/h2");
   private By EDIT_PASSWORD = By.xpath(".//*[@id='edit_password']/a");
   private By CANCEL_PASSWORD = By.xpath(".//*[@id='edit_password']/a[2]");
   private By CURRENT_PASSWORD = By.id("auth_password_2");
   private By NEW_PASSWORD = By.id("user_password");
   private By SECURITY_PASSWORD_LABEL = By.xpath("(.//label[contains(@for,'password')])[3]");
   private By CONFIRM_NEW_PASSWORD = By.id("user_password_confirmation");
   private By PASSWORD_SAVE = By.xpath(".//*[@id='change_password_form']/div[4]/div[4]/div");
   
   private By EMAIL_SUBSCRIPTION_HEADER_LABEL = By.xpath(".//div[contains(@class,'account_data_section')]/h2");
   private By EMAIL_SUBSCRIPTION_DESCRIPTION = By.xpath(".//div[contains(@class,'account_data_section')]/p[1]");
   private By VENTANA_EMAILS_CHECKBOX  = By.id("original_receive_ask_ventana_emails");
   private By CLAIMS_EMAILS_CHECKBOX = By.id("original_receive_claims_emails");
   private By MARKETING_EMAIL_CHECKBOX = By.id("original_receive_marketing_emails");
   private By SURVEY_EMAIL_CHECKBOX = By.id("original_receive_survey_emails");
   
   /*private By AA = By.id("user_receive_ask_ventana_emails");
   private By BB = By.id("user_receive_claims_emails");
   private By CC = By.id("user_receive_marketing_emails");
   private By DD = By.id("user_receive_survey_emails");
   private By EMAIL_SUBSCRIPTIONS_SAVE = By.xpath(".//*[@id='email_subscriptions_form']/div[6]");
   private By EMAIL_SUBSCRIPTIONS_EDIT = By.xpath(".//*[@id='email_subscriptions']/div/h2/a");
   private By EMAIL_SUBSCRIPTIONS_CANCEL = By.xpath(".//*[@id='email_subscriptions']/div/h2/a[2]");*/
   
   //Verifying Account page header
   public void verifyAccountPageHeader(){
      if(driver.isElementPresent(ACCOUNT_TITLE)){
         Reporter.log("Account header exists");
         assertEquals(driver.getText(ACCOUNT_TITLE), "Your Account");
      }else{
         Reporter.log("Account header doesn't exist ");
      }
   }
   
   //Verifying First Name Label
   public void verifyFirstNameLabel(){
      if(driver.isElementPresent(FIRST_NAME_LABEL)){
         Reporter.log("First Name Label exists");
         assertEquals(driver.getText(FIRST_NAME_LABEL), "First Name");
      }else{
         Reporter.log("First Name Label doesn't exist ");
      }
   }
   
   //Verifying Last Name Label
   public void verifyLastNameLabel(){
      if(driver.isElementPresent(LAST_NAME_LABEL)){
         Reporter.log("Last Name Label exists");
         assertEquals(driver.getText(LAST_NAME_LABEL), "Last Name");
      }else{
         Reporter.log("Last Name Label doesn't exist ");
      }
   }
   
   public void verifyDOBLabel(){
      if(driver.isElementPresent(USER_DOB_LABEL)){
         Reporter.log("DOB Label exists");
         assertEquals(driver.getText(USER_DOB_LABEL), "Date Of Birth");
      }else{
         Reporter.log("DOB Label doesn't exist ");
      }
   }
   
   public void verifyEmailAddressLabel(){
      if(driver.isElementPresent(EMAIL_ADDRESS_LABEL)){
         Reporter.log("Email Address Label exists");
         assertEquals(driver.getText(EMAIL_ADDRESS_LABEL), "Email Address");
      }else{
         Reporter.log("Email Address Label doesn't exist ");
      }
   }
   
   public void verifyTimeZoneLabel(){
      if(driver.isElementPresent(TIME_ZONE_LABEL)){
         Reporter.log("Time Zone Label exists");
         assertEquals(driver.getText(TIME_ZONE_LABEL), "Time Zone");
      }else{
         Reporter.log("Time Zone Label doesn't exist ");
      }
   }
   
   public void verifySecurityHeader(){
      if(driver.isElementPresent(ACCOUNT_SECURITY_HEADER)){
         Reporter.log("Security header exists");
         assertEquals(driver.getText(ACCOUNT_SECURITY_HEADER), "Security");
      }else{
         Reporter.log("Security header doesn't exist ");
      }
   }
   
   public void verifySecurityPasswordLabel(){
      if(driver.isElementPresent(SECURITY_PASSWORD_LABEL)){
         Reporter.log("Password Label exists");
         assertEquals(driver.getText(SECURITY_PASSWORD_LABEL), "Password");
      }else{
         Reporter.log("Password Label doesn't exist ");
      }
   }
   
   public void verifyEmailSubscriptionHeader(){
      if(driver.isElementPresent(EMAIL_SUBSCRIPTION_HEADER_LABEL)){
         Reporter.log("Email Subscription Header is present");
         assertEquals(driver.getText(EMAIL_SUBSCRIPTION_HEADER_LABEL), "Email Subscriptions Edit");
      }else{
         Reporter.log("Email Subscription Header is not present");
      }
   }
   
   public void verifyEmailSubscriptionDescription(){
      if(driver.isElementPresent(EMAIL_SUBSCRIPTION_DESCRIPTION)){
         Reporter.log("Email Subscription desc is present");
         assertEquals(driver.getText(EMAIL_SUBSCRIPTION_DESCRIPTION), "You currently receive the selected email notifications:");
      }else{
         Reporter.log("Email Subscription desc is not present");
      }
   }
   
   public void verifyVentanaEmailCheckBox(){
      if(driver.isElementPresent(VENTANA_EMAILS_CHECKBOX)){
         Reporter.log("CheckBox Present : New Messages in Your Inbox present");
      }else{
         Reporter.log("CheckBox Not present : New Messages in Your Inbox present");
      }
   }
   
   public void verifyClaimsEmailCheckBox(){
      if(driver.isElementPresent(CLAIMS_EMAILS_CHECKBOX)){
         Reporter.log("CheckBox Present : Your Healthcare Updates and Alerts");
      }else{
         Reporter.log("CheckBox Not present : Your Healthcare Updates and Alerts");
      }
   }
   public void verifyMarketingEmailCheckBox(){
      if(driver.isElementPresent(MARKETING_EMAIL_CHECKBOX)){
         Reporter.log("CheckBox Present : Product Updates and Benefits Education");
      }else{
         Reporter.log("CheckBox Not present : Product Updates and Benefits Education");
      }
   }
   public void verifySurveyEmailCheckBox(){
      if(driver.isElementPresent(SURVEY_EMAIL_CHECKBOX)){
         Reporter.log("CheckBox Present : User Survey Invitations");
      }else{
         Reporter.log("CheckBox Not present : User Survey Invitations");
      }
   }
   
   public void clickOnEditPersonalInformation(){
      driver.click(PERSONAL_INFO_EDIT);
      Reporter.log("Clicked on Edit :: Personal Information");
   }
   
   public void verifyEmailId(String emailId){
      driver.isElementVisible(USER_NEW_EMAIL);
      assertEquals(driver.getAttributeValue(USER_NEW_EMAIL, "value"), emailId);
   }
   
   public void verifyDOBPattern(){
      String DOB = null;
      String dob_regex="[a-zA-Z][a-zA-Z][a-zA-Z]\\s[0-9]?[0-9][0-9][0-9][0-9][0-9]";
      DOB = driver.getSelectValueFromDropDown(USER_DOB_MONTH).getText() +" " + driver.getSelectValueFromDropDown(USER_DOB_DAY).getText() + driver.getSelectValueFromDropDown(USER_DOB_YEAR).getText();
      if(DOB.matches(dob_regex)){
         Reporter.log("Date of birth matches the pattern");
      }else{
         Reporter.log("Date of birth dosen't match the pattern");
      }
   }
}
