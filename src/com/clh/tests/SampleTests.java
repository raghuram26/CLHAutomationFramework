package com.clh.tests;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clh.utilities.ReadExcel;
import com.clh.webdriver.TestConfiguration;
import com.clh.webdriver.WebdriverTestCases;
import com.clh.pageobjects.*;

public class SampleTests extends WebdriverTestCases {

   LoginPage lp = new LoginPage();
   BasePage bp = new BasePage();
   FindCarePage fcp = new FindCarePage();
   String url = "/Users/raghuramp/Projects/Ventana/CLHAutomationFramework/data/user_profiles.xls";
   private String emailId;

   public SampleTests() {
      // TODO Auto-generated constructor stub
   }

   @Test
   public void testLogin() {
      lp.openURL();
      lp.setEmailID(emailId);
      lp.setPassword(TestConfiguration.getInstance().getTestAccountPasswords());
      lp.clickLoginButton();
      if(bp.isNamePresent()){
         Reporter.log("Logged in successfully");
         bp.clickOnFindCare();
         fcp.findAllLinks();
         bp.clickNeedHelp();
         driver.screenShot();
         bp.closeNeedHelp();
         bp.clickOnBookmarks();
      }else{
         Reporter.log("Not logged in");
      }
      
   }

   @Factory(dataProvider = "data")
   public SampleTests(String emailId) {
      this.emailId = emailId;
   }

   @DataProvider(parallel = true)
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
   }

   @DataProvider(parallel = true)
   public static Object[][] data() {
      return new Object[][] { { "msft1_hap1@castlighthealth.com" },
            { "sw_prem_mktret_lab2@castlighthealth.com" },
             };
   }
}
