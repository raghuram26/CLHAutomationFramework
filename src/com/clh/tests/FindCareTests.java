package com.clh.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clh.pageobjects.AccountPage;
import com.clh.pageobjects.FindCarePage;
import com.clh.pageobjects.HomePage;
import com.clh.pageobjects.LoginPage;
import com.clh.webdriver.TestConfiguration;
import com.clh.webdriver.WebdriverTestCases;

public class FindCareTests extends WebdriverTestCases{
   
   LoginPage loginPage = new LoginPage();
   HomePage homePage = new HomePage();
   AccountPage accountPage = new AccountPage();
   FindCarePage findCarePage = new FindCarePage();
   //String emailId = "calpers_basic_ca_1@castlighthealth.com";
   String emailId = "msft1_hap1@castlighthealth.com";

   @BeforeMethod
   public void loginToFindCarePage(){
      loginPage.openURL();
      loginPage.setEmailID(emailId);
      loginPage.setPassword(TestConfiguration.getInstance().getTestAccountPasswords());
      loginPage.clickLoginButton();
      homePage.isLoginSuccessful();
      homePage.clickOnFindCare();
   }
   
   @Test
   public void verifyLinksUnderCommonCareType(){
      findCarePage.findLinksUnderCommonCareType();
   }
}
