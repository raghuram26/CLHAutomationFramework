package com.clh.pageobjects;

import org.openqa.selenium.By;
import org.testng.Reporter;

public class FeedBackPage extends BasePage{

   private By FEEDBACK_TEXT = By.xpath("(.//div[contains(@class,'preamble')])[1]");
   private By FEEDBACK_TEXTAREA = By.xpath("(.//textarea[contains(@class,'pane_feedback')])[1]");
   private By SEND_FEEDBACK = By.xpath("(.//input[contains(@value,'Send Feedback')])[1]");
   
   public void enterFeedbackText(String feedbackText){
      driver.sendKeys(FEEDBACK_TEXTAREA, feedbackText);
      Reporter.log("Entered Feedback text :: " + feedbackText);
   }
   
   public void clickOnSendFeedbackButton(){
      driver.isElementClickable(SEND_FEEDBACK);
      driver.click(SEND_FEEDBACK);
   }
   
   public void verifyFeebbackText(){
      
   }
}
