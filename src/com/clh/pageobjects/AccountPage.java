package com.clh.pageobjects;

import org.openqa.selenium.By;

public class AccountPage extends BasePage{
   
   private By ACCOUNT_TITLE = By.xpath(".//*[@id='content_container']/div");
   private By PERSONAL_INFO_EDIT = By.xpath(".//*[@id='personal_information']/h2/a");
   private By PERSONAL_INFO_CANCEL = By.xpath(".//*[@id='personal_information']/h2/a[2]");
   private By FIRST_NAME = By.id("user_first_name");
   private By LAST_NAME = By.id("user_last_name");
   private By USER_DOB_MONTH = By.id("user_dob_month");
   private By USER_DOB_DAY = By.id("user_dob_day");
   private By USER_DOB_YEAR = By.id("user_dob_year");
   private By USER_NEW_EMAIL = By.id("user_new_email");
   private By USER_TIME_ZONE = By.id("user_time_zone");
   private By PERSONAL_INFORMATION_SAVE = By.xpath(".//*[@id='edit_personal_information_form']/div[7]/div");
   private By ACCOUNT_SECURITY = By.id("account_security");
   private By EDIT_PASSWORD = By.xpath(".//*[@id='edit_password']/a");
   private By CANCEL_PASSWORD = By.xpath(".//*[@id='edit_password']/a[2]");
   private By CURRENT_PASSWORD = By.id("auth_password_2");
   private By NEW_PASSWORD = By.id("user_password");
   private By CONFIRM_NEW_PASSWORD = By.id("user_password_confirmation");
   private By PASSWORD_SAVE = By.xpath(".//*[@id='change_password_form']/div[4]/div[4]/div");
   
   private By AA = By.id("user_receive_ask_ventana_emails");
   private By BB = By.id("user_receive_claims_emails");
   private By CC = By.id("user_receive_marketing_emails");
   private By DD = By.id("user_receive_survey_emails");
   private By EMAIL_SUBSCRIPTIONS_SAVE = By.xpath(".//*[@id='email_subscriptions_form']/div[6]");
   private By EMAIL_SUBSCRIPTIONS_EDIT = By.xpath(".//*[@id='email_subscriptions']/div/h2/a");
   private By EMAIL_SUBSCRIPTIONS_CANCEL = By.xpath(".//*[@id='email_subscriptions']/div/h2/a[2]");
   
   
   public void AccountPage(){
   }
   
}
