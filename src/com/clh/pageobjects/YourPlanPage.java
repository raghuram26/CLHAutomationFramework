package com.clh.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

public class YourPlanPage extends BasePage{

   private By YOUR_PLAN_HEADER = By.xpath("//*[@id='my_insurance']/div/div/h1") ;
   
   //Participant spending
   //IN-NETWORK
   private By IN_NETWORK_PHASE= By.xpath(".//div[contains(@class,'phase_description')]");
   private By IN_NETWORK_SPENT_TO_DATE = By.xpath("(.//div[contains(@class,'spend_amount')])[1]");
   private By IN_NETWORK_TO_COINSURANCE = By.xpath("(.//div[contains(@class,'spend_amount')])[2]");
   private By IN_NETWORK_TO_COVERED = By.xpath("(.//div[contains(@class,'spend_amount')])[3]");
   private By IN_NETWORK_ALERT = By.xpath(".//div[contains(@class,'alert row')]");
   //private By IN_NETWORK = By.xpath("(.//span[contains(@class,'title_text')])[1]");
   private By IN_NETWORK = By.xpath("(.//i[contains(@class,'icon accordion')])[1]");
   private By IN_NETWORK_SPENDING_LIMITS_POPUP = By.xpath(".//table[contains(@class,'spendings_limits_popup')]");
   private By IN_NETWORK_INFO = By.xpath("(.//i[contains(@class,'icon info_i dark')])[1]");
   private By IN_NETWORK_PLAN_PARTICIPANT = By.xpath("(.//div[contains(@class,'participant')])[2]");
   
   
   //OUT-OF-NETWORK
   private By OUT_OF_NETWORK_INFO = By.xpath("(.//i[contains(@class,'icon info_i dark')])[2]");
   //private By OUT_OF_NETWORK = By.xpath("(.//span[contains(@class,'title_text')])[2]");
   private By OUT_OF_NETWORK = By.xpath("(.//i[contains(@class,'icon accordion')])[2]");
   private By OUT_OF_NETWORK_PLAN_PARTICIPANT = By.xpath("(.//div[contains(@class,'participant')])[2]");
   private By OUT_OF_NETWORK_SPENT_TO_DATE = By.xpath("(.//div[contains(@class,'spend_amount')])[4]");
   private By OUT_OF_NETWORK_TO_COINSURANCE = By.xpath("(.//div[contains(@class,'spend_amount')])[5]");
   
   //Benefits summary
   private By IN_NETWORK_BENEFITS_DETIALS = By.xpath(".//div[contains(@class,'detail_section')]");
   private By DEDUCTIBLE = By.xpath("//*[@id='deductible']");
   private By COINSURANCE = By.xpath("//*[@id='coinsurance']");
   private By COVERED = By.xpath("//*[@id='covered']");
   private By EMPLOYER_DEDUCTIBLE_BENEFIT_INFO_TITLE = By.xpath("(.//div[contains(@class,'benefit_info_title')])[1]");
   private By EMPLOYEE_DEDUCTIBLE_BENEFIT_INFO_TITLE = By.xpath("(.//div[contains(@class,'benefit_info_title')])[2]");
   private By EMPLOYER_DEDUCTIBLE_BENEFIT_INFO = By.xpath("(.//div[contains(@class,'benefit_info_list_item')])[1]");
   private By EMPLOYEE_DEDUCTIBLE_BENEFIT_INFO = By.xpath("(.//div[contains(@class,'benefit_info_list_item')])[2]");
   
   private By EMPLOYER_COINSURANCE_BENEFIT_INFO_TITLE = By.xpath("(.//div[contains(@class,'benefit_info_title')])[3]");
   private By EMPLOYEE_COINSURANCE_BENEFIT_INFO_TITLE = By.xpath("(.//div[contains(@class,'benefit_info_title')])[4]");
   private By EMPLOYER_COINSURANCE_BENEFIT_INFO = By.xpath("(.//div[contains(@class,'benefit_info_list_item')])[3]");
   private By EMPLOYEE_COINSURANCE_BENEFIT_INFO = By.xpath("(.//div[contains(@class,'benefit_info_list_item')])[4]");
   
   private By EMPLOYER_COVERED_BENEFIT_INFO_TITLE = By.xpath("(.//div[contains(@class,'benefit_info_title')])[5]");
   private By EMPLOYEE_COVERED_BENEFIT_INFO_TITLE = By.xpath("(.//div[contains(@class,'benefit_info_title')])[6]");
   private By EMPLOYER_COVERED_BENEFIT_INFO = By.xpath("(.//div[contains(@class,'benefit_info_list_item')])[5]");
   private By EMPLOYEE_COVERED_BENEFIT_INFO = By.xpath("(.//div[contains(@class,'benefit_info_list_item')])[6]");
   
   //Coverage Details
   private By COVERAGE_DETAILS_TITLE = By.id("coverage_details");
   private By PREVENTIVE_SERVICES = By.xpath(".//span[text()='Preventive Services']");
   private By PREVENTIVE_SERVICES_INFO = By.xpath("(.//div[contains(@class,'accordion_content print_show row')])[2]");
   private By COMMON_MEDICAL_SERVICES = By.xpath(".//span[text()='Common Medical Services']");
   private By COMMON_MEDICAL_SERVICES_DETAILS = By.xpath("(.//div[contains(@class,'common_medical_services_detail')])[1]");
   private By EMERGENCY_AND_URGENT_CARE = By.xpath(".//span[text()='Emergency and Urgent Care']");
   private By EMERGENCY_AND_URGENT_CARE_DETAILS = By.xpath("(.//div[contains(@class,'common_medical_services_detail')])[2]");
   private By HOSPITAL_SERVICES = By.xpath(".//span[text()='Hospital Services']");
   private By HOSPITAL_SERVICES_DETAILS = By.xpath("(.//div[contains(@class,'common_medical_services_detail')])[3]");
   private By OTHER_SERVICES = By.xpath(".//span[text()='Other Services']");
   private By OTHER_SERVICES_DETAILS = By.xpath("(.//div[contains(@class,'common_medical_services_detail')])[4]");
   
   public void clickOnOutOfNetwork(){
      driver.screenShot();
      driver.click(OUT_OF_NETWORK);
      Reporter.log("Clicked on Out-OF-Network");
   }
   
   public void clickOnPreventiveServices(){
      driver.click(PREVENTIVE_SERVICES);
      Reporter.log("Clicked on preventive services");
     /* if(driver.isElementVisible(PREVENTIVE_SERVICES_INFO)){
         Reporter.log("detials present");
      }else{
         driver.screenShot();
         Reporter.log("No details ");
      }*/
   }
   
   public void clickOnCommonMedicalServices(){
      driver.click(COMMON_MEDICAL_SERVICES);
      Reporter.log("Clicked on common Medical services");
   }
   
   public void clickOnEmergencyAndUrgentCare(){
      driver.click(EMERGENCY_AND_URGENT_CARE);
      Reporter.log("Clicked on Emergency and Urgent care");
   }
   
   public void clickOnHospitalServices(){
      driver.click(HOSPITAL_SERVICES);
      Reporter.log("Clicked on Hospital services");
   }
   
   public void clickOnOtherServices(){
      System.out.println("-- > " + driver.isElementVisible(OTHER_SERVICES));
      /*if(driver.findElements(OTHER_SERVICES).size()!=0){
         driver.click(OTHER_SERVICES);
      }else{   
         Reporter.log("Other Service is not present");
      }*/
   }

   public void clickOnDeductible(){
      driver.click(DEDUCTIBLE);
   }
   
   public void clickOnCoinsurance(){
      driver.click(COINSURANCE);
   }
   
   public void clickOnCovered(){
      driver.click(COVERED);
   }
   
   public void getDeductibleText(){
      String employer_Title = driver.getText(EMPLOYER_DEDUCTIBLE_BENEFIT_INFO_TITLE);
      String employee_Title = driver.getText(EMPLOYEE_DEDUCTIBLE_BENEFIT_INFO_TITLE);
      String employer_info = driver.getText(EMPLOYER_DEDUCTIBLE_BENEFIT_INFO);
      String employee_info = driver.getText(EMPLOYEE_DEDUCTIBLE_BENEFIT_INFO);
      Reporter.log("Ded text :: " + employer_Title + employer_info + "\n"+ employee_Title + employee_info);
   }
   
   public void getCoinsuranceText(){
      String employer_Title = driver.getText(EMPLOYER_COINSURANCE_BENEFIT_INFO_TITLE);
      String employee_Title = driver.getText(EMPLOYEE_COINSURANCE_BENEFIT_INFO_TITLE);
      String employer_info = driver.getText(EMPLOYER_COINSURANCE_BENEFIT_INFO);
      String employee_info = driver.getText(EMPLOYEE_COINSURANCE_BENEFIT_INFO);
      Reporter.log("Coinsurance text :: " + employer_Title + employer_info + "\n" + employee_Title + employee_info);
   }
   
   public void getCoveredText(){
      String employer_Title = driver.getText(EMPLOYER_COVERED_BENEFIT_INFO_TITLE);
      String employee_Title = driver.getText(EMPLOYEE_COVERED_BENEFIT_INFO_TITLE);
      String employer_info = driver.getText(EMPLOYER_COVERED_BENEFIT_INFO);
      String employee_info = driver.getText(EMPLOYEE_COVERED_BENEFIT_INFO);
      Reporter.log("Covered text :: " + employer_Title + employer_info + "\n"+ employee_Title + employee_info);
   }
   public void verifyBenefitsDetials(){
      String s1="Your CalPERS plan is structured into three cost sharing phases: deductible, coinsurance, and covered. At the beginning of the plan year, you are responsible for paying most costs, but as you move from phase to phase, CalPERS pays more of the costs. Click on a phase to view a summary of in-network benefits during that phase NOTE: Out-of-network care is subject to different coverage. See below for details.";
      String s2 = driver.findElement(IN_NETWORK_BENEFITS_DETIALS).getText().replace("\n", " ");
      //Assert.assertEquals(s1,s2);
   }
   
   
}
