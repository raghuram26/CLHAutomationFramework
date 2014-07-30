package com.clh.pageobjects;

import org.openqa.selenium.By;

public class HelpPopupPage extends BasePage{
   
   private By ASK_QUESTION = By.id("question_pane_ask");
   private By ASK_QUESTION_TEXT_AREA = By.id("inquiry_initial_message_text");
   private By SEND = By.xpath("(.//input[contains(@name,'commit')])[1]");

   
}
