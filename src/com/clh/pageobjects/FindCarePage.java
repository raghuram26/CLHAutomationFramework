package com.clh.pageobjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class FindCarePage extends BasePage {

   //Common type of care
   private By PRIMARY_CARE_FOR_ADULTS = By.xpath(".//a[text()='Primary care for adults']");
   private By PRIMARY_CARE_FOR_CHILDREN = By.xpath(".//a[text()='Primary care for children']");
   private By COLONOSCOPY = By.xpath(".//a[text()='Colonoscopy']");
   private By GASTROENTEROLOGIST_VISIT  = By.xpath(".//a[text()='Gastroenterologist visit']");

   public FindCarePage() {

   }

   public void findAllLinks() {
      List<WebElement> links = driver.findListOfElement(By.tagName("a"));
      Reporter.log("Links");
      //String [] procedures = new String [] { "Primary+care+for+adults","Primary+care+for+children","Pediatric+surgeon+visit"};
      //System.out.println("Size :: " + links.size());
      for(int i=0;i< links.size(); i++){
         String url = links.get(i).getAttribute("href");
         Reporter.log(url);
        /* for(int j=0;j<procedures.length;j++){
            if(url.contains(procedures[j])){
               Reporter.log(url);
               
            }
         }*/
         
      }
      
      /*for (int i = 0; i < links.size(); i++) {
         String url = links.get(i).getAttribute("href");
         //URL urls;
         if(url.startsWith("https://denqa01.castlighthealth.com/search?q=")){
            Reporter.log(url);
         }
         try {
            urls = new URL(url);
            HttpURLConnection http = (HttpURLConnection)urls.openConnection();
            Reporter.log("url :: " + url + " :: Response Code :: " +  http.getResponseCode());
         } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }*/
   }
}
