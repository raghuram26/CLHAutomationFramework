package com.clh.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clh.pageobjects.AccountPage;
import com.clh.pageobjects.HomePage;
import com.clh.pageobjects.LoginPage;
import com.clh.webdriver.TestConfiguration;
import com.clh.webdriver.WebdriverTestCases;

public class YourAccountPageTests extends WebdriverTestCases{
   LoginPage loginPage = new LoginPage();
   HomePage homePage = new HomePage();
   AccountPage accountPage = new AccountPage();
   //String emailId = "calpers_basic_ca_1@castlighthealth.com";
   String emailId = "msft1_hap1@castlighthealth.com";
   
   @BeforeMethod
   public void loginToApplication(){
      loginPage.openURL();
      loginPage.setEmailID(emailId);
      loginPage.setPassword(TestConfiguration.getInstance().getTestAccountPasswords());
      loginPage.clickLoginButton();
      homePage.isLoginSuccessful();
      homePage.clickOnAccount();
   }
   
   @Test
   public void verifyPersonalInformationLabels(){
      accountPage.verifyAccountPageHeader();
      accountPage.verifyFirstNameLabel();
      accountPage.verifyLastNameLabel();
      accountPage.verifyDOBLabel();
      accountPage.verifyEmailAddressLabel();
      accountPage.verifyTimeZoneLabel();
      accountPage.clickOnEditPersonalInformation();
      accountPage.verifyEmailId(emailId);
      accountPage.verifyDOBPattern();
   }
   
   @Test
   public void verifySecuritySection(){
      accountPage.verifySecurityHeader();
      accountPage.verifySecurityPasswordLabel();
   }
   
   @Test
   public void verifyEmailSubscription(){
      accountPage.verifyEmailSubscriptionHeader();
      accountPage.verifyEmailSubscriptionDescription();
      accountPage.verifyVentanaEmailCheckBox();
      accountPage.verifyClaimsEmailCheckBox();
      accountPage.verifySurveyEmailCheckBox();
      accountPage.verifyMarketingEmailCheckBox();
   }
}
