package com.clh.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class SearchRelatedPage extends BasePage{

   private By EDUCATION_LINK = By.xpath(".//a[contains(@rel,'search_education_link')]");
   private By PROCEDURE_NAME = By.xpath("//*[@id='snapshot']/div/div/div/h1");
   private By SORT_ORDER = By.xpath("(.//div[contains(@class,'filter-option pull-left')])[1]");
   private By SORT_DISTANCE = By.xpath("(.//div[contains(@class,'filter-option pull-left')])[2]");
   private By TYPE_OF_VISIT = By.xpath("(.//div[contains(@class,'filter-option pull-left')])[3]");
   private By SEARCH_RESULTS = By.xpath(".//ul[contains(@id,'provider_search_results')]/li");
   private By PROVIDER_LINKS = By.xpath(".//a[contains(@class,'provider_link')]");
   private By PROVIDER_STREET_ADDRESS = By.xpath(".//div[contains(@class,'street_address')]");
   private By PROVIDER_CITY_ADDRESS = By.xpath(".//div[contains(@class,'city_address')]");
   private By PROVIDER_DISTANCE = By.xpath(".//span[contains(@class,'distance')]");
   private By YOU_PAY_COST = By.xpath("(.//span[contains(@class,'range_price_in_dollars')])");
   private By YOUR_PLAN_LINK = By.xpath(".//a[contains(@class,'where_am_i_policies_link')]");
   
   public void isProvider(){
      Reporter.log("Search results count " + driver.findListOfElements(SEARCH_RESULTS).size());
   }
   
   public void verifyEducationLinkPresent(){
      if(driver.isElementPresent(EDUCATION_LINK)){
         Reporter.log("Education Link Present");
      }else{
         Reporter.log("Education Link not Present");
      }
   }

   public void getProviderLinks(){
      List<WebElement> pr = driver.findListOfElements(PROVIDER_LINKS);
      int listofLinks = driver.findListOfElements(PROVIDER_LINKS).size();
      for(int i=1;i<listofLinks;i++){
         Reporter.log("Provider links ["+ i +"] :: "+ pr.get(i));
      }
   }
   
}
