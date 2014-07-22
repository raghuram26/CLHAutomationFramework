package com.clh.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clh.pageobjects.HomePage;
import com.clh.pageobjects.LoginPage;
import com.clh.utilities.ReadExcel;
import com.clh.webdriver.TestConfiguration;
import com.clh.webdriver.WebdriverTestCases;

public class CheckHomePageLinksTests extends WebdriverTestCases {
   LoginPage loginPage = new LoginPage();
   HomePage homePage = new HomePage();
   private String emailId;
   String url = "/Users/raghuramp/Projects/Ventana/CLHAutomationFramework/data/user_profiles.xls";
   
   public CheckHomePageLinksTests(){
      //TODO
	   
   }
   
   @Test
   public void testHeaderLinks(){
      loginPage.openURL();
      loginPage.setEmailID("msft1_hap1@castlighthealth.com");
      loginPage.setPassword(TestConfiguration.getInstance().getTestAccountPasswords());
      loginPage.clickLoginButton();
      homePage.isLoginSuccessful();
      homePage.clickOnAccount();
      homePage.clickOnInbox();
      homePage.clickOnBookmarks();
      homePage.clickNeedHelp();
      homePage.closeNeedHelp();
      homePage.clickOnFindCare();
      homePage.clickOnPastCare();
      homePage.clickOnYourPlan();
      homePage.clickOnFeedback();
      homePage.closeFeedBackForm();
      homePage.clickOnSecurity();
      homePage.clickOnOverview();
      homePage.clickOnPrivacy();
      homePage.clickOnTermsOfUse();
      homePage.logout();
   }
   
  /*@Factory(dataProvider = "userProfiles")
   public CheckHomePageLinksTests(String emailId) {
      this.emailId = emailId;
   }*/

   /*@DataProvider(parallel = true)
   public Object[][] userProfiles() throws Exception {
      int rowCount = ReadExcel.getRowCount(url, "Sheet1");
      int colCount = ReadExcel.getColumnCount(url, "Sheet1");
      System.out.println("rowCount :: " + rowCount);
      Object[][] testObjArray = new String[rowCount][colCount];
      for (int i = 0; i < rowCount; i++) {
         for (int j = 0; j < colCount; j++) {
            testObjArray[i][j] = ReadExcel.getStringCellData(i + 1, j);
            System.out.println(ReadExcel.getStringCellData(i + 1, j));
         }
      }
      return testObjArray;
   }*/
}
