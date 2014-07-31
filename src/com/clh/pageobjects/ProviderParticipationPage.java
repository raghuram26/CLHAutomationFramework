package com.clh.pageobjects;

import org.openqa.selenium.By;
import org.testng.Reporter;

public class ProviderParticipationPage extends BasePage{

   private By PROVIDER_NAME = By.xpath("//*[@id='provider_name']/h1");
   private By PROVIDER_NETWORK = By.xpath("//*[@id='pros']/div[1]/div/span");
   private By PROVIDER_ADDRESS = By.xpath("(.//div[contains(@class,'address_container')])[2]");
   private By PROVIDER_PHONE  = By.xpath("(.//div[contains(@class,'address_container')])[2]/div[3]");
   
   //Verifying that phone number exists and matches
   public void verifyProviderPhoneNumber(String phoneNum){
      if(driver.getText(PROVIDER_PHONE)!= null){
         assertEquals(PROVIDER_PHONE, phoneNum);
      }
   }
   
   //Verifying if provider belongs to In-Network or Not
   public void isProviderInNetwork(){
      if(driver.getText(PROVIDER_NETWORK).equalsIgnoreCase("In-Network")){
         Reporter.log("Provider is In-Network");
      }else{
         Reporter.log("Provider is not In-Network");
      }
   }
   
   //Verifying that Name corresponds to the link clicked
   public void verifyProviderName(String providerName){
      assertEquals(providerName, providerName);
   }
}
