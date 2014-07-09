package com.clh.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.castlight.webdriver.TestConfiguration;
import com.castlight.webdriver.WebdriverTestCases;

public class SampleTests extends WebdriverTestCases{

	public SampleTests() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testPrePod(){
		driver.open(TestConfiguration.getInstance().getUrl());
		driver.sendKeys(By.id("email_login"), "tw_basic_1@castlighthealth.com");
		driver.sendKeys(By.id("password_login"), "ShowTheLight685");
		driver.click(By.name("commit"));
		driver.pause("4500");
		driver.screenShot();
	}
}
