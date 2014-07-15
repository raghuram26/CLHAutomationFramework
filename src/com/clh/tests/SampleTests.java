package com.clh.tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clh.utilities.ReadExcel;
import com.clh.webdriver.TestConfiguration;
import com.clh.webdriver.WebdriverTestCases;
import com.clh.pageobjects.*;


public class SampleTests extends WebdriverTestCases{

   LoginPage lp = null;
   String url="/Users/raghuramp/Projects/Ventana/CLHAutomationFramework/data/user_profiles.xls";
   private String e;
	public SampleTests() {
		// TODO Auto-generated constructor stub
	   lp = new LoginPage();
	}

	@Test
	public void testLogin(){
	   System.out.println("e::" + e);
	   driver.open(TestConfiguration.getInstance().getUrl());
		driver.sendKeys(By.id("email_login"), e);
		driver.sendKeys(By.id("password_login"), "monkey55");
		driver.click(By.name("commit"));
		driver.screenShot();
	}
	
	
	@Factory(dataProvider="userProfiles")
	public SampleTests(String e){
	   this.e=e;
	}

	@DataProvider (parallel = true)
	public Object [][] userProfiles() throws Exception{
	   int rowCount = ReadExcel.getRowCount(url, "Sheet1");
	   int colCount = ReadExcel.getColumnCount(url, "Sheet1");
	   Object [][] testObjArray = new String[rowCount][colCount];
	   for(int i=0;i<rowCount;i++){
	      for(int j=0;j<colCount;j++){
	         testObjArray[i][j]= ReadExcel.getStringCellData(i+1, j);
	         System.out.println(ReadExcel.getStringCellData(i+1, j));
	      }
	   }
	   return testObjArray;
	}
	
	@DataProvider(parallel = true)
   public static Object[][] data() {
       return new Object[][] {
               {"msft1_hap1@castlighthealth.com"}, {"sw_prem_mktret_lab2@castlighthealth.com"}, {"wm_hrahi1@castlighthealth.com"}
       };
   }
}
