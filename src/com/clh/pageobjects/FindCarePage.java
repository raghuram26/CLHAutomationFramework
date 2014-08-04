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

   // Common type of care
   private By PRIMARY_CARE_FOR_ADULTS = By
         .xpath(".//a[text()='Primary care for adults']");
   private By PRIMARY_CARE_FOR_CHILDREN = By
         .xpath(".//a[text()='Primary care for children']");
   private By COLONOSCOPY = By.xpath(".//a[text()='Colonoscopy']");
   private By GASTROENTEROLOGIST_VISIT = By
         .xpath(".//a[text()='Gastroenterologist visit']");
   private By HIP_REPLACEMENT_SURGERY = By
         .xpath(".//a[text()='Hip replacement surgery']");
   private By URINARY_TRACT_INFECTION = By
         .xpath(".//a[text()='Urinary tract infection']");
   private By PREGNANCY = By.xpath(".//a[text()='Pregnancy']");
   private By PINK_EYE = By.xpath(".//a[text()='Pink eye']");

   public FindCarePage() {

   }

   public void clickOnProcedure(String procedureName) {
      switch (procedureName) {
      case "pregnancy":
         driver.click(PREGNANCY);
         break;
      case "pinkeye":
         driver.click(PINK_EYE);
         break;
      case "primarycareforadults":
         driver.click(PRIMARY_CARE_FOR_ADULTS);
         break;
      case "hipreplacementsurgery":
         driver.click(HIP_REPLACEMENT_SURGERY);
         break;
      case "urinarytractinfection":
         driver.click(URINARY_TRACT_INFECTION);
         break;
      default:
         Reporter.log("Procedure is not listed");
         break;
      }
   }

   public void findLinksUnderCommonCareType(){
      WebElement l = driver.findElement(By.xpath(".//div[contains(@class,'span12')]"));
      List<WebElement> ls = l.findElements(By.tagName("a"));
      Reporter.log("Size :: " + ls.size());
      URL url;
      for(int i=0;i< ls.size(); i++){
         String links = ls.get(i).getAttribute("href");
         try {
            url = new URL(links);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            if(http.getResponseCode() > 300){
               Reporter.log("URL :: " + http.toString() + ":: Problem :: " + http.getResponseCode());
            }else{
               Reporter.log("URL is fine");
            }
         } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }catch (IOException e) {
            e.printStackTrace();
         }
        Reporter.log(ls.get(i).getAttribute("href"));
      }
   }
   
   public void findAllLinks() {
      List<WebElement> links = driver.findListOfElements(By.xpath(".//div[contains(@class,'span12')]"));
      Reporter.log("Links--> " + links.size());
      // String [] procedures = new String [] {
      // "Primary+care+for+adults","Primary+care+for+children","Pediatric+surgeon+visit"};
      // System.out.println("Size :: " + links.size());
      for (int i = 0; i < links.size(); i++) {
         WebElement url = links.get(i).findElement(By.tagName("a"));
         Reporter.log(url.getAttribute("href"));
         /*
          * for(int j=0;j<procedures.length;j++){
          * if(url.contains(procedures[j])){ Reporter.log(url);
          * 
          * } 
          */

      }

      /*
       * for (int i = 0; i < links.size(); i++) { String url =
       * links.get(i).getAttribute("href"); //URL urls;
       * if(url.startsWith("https://denqa01.castlighthealth.com/search?q=")){
       * Reporter.log(url); } try { urls = new URL(url); HttpURLConnection http
       * = (HttpURLConnection)urls.openConnection(); Reporter.log("url :: " +
       * url + " :: Response Code :: " + http.getResponseCode()); } catch
       * (MalformedURLException e) { // TODO Auto-generated catch block
       * e.printStackTrace(); }catch (IOException e) { // TODO Auto-generated
       * catch block e.printStackTrace(); } }
       */
   }
}
