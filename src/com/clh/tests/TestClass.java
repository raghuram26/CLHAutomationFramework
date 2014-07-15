package com.clh.tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clh.webdriver.WebdriverTestCases;


public class TestClass extends WebdriverTestCases{
    String s;

    @Factory(dataProvider = "data")
    public TestClass(String s) {
        this.s = s;
    }

    @DataProvider(parallel = true)
    public static Object[][] data() {
        return new Object[][] {
                {"msft1_hap1@castlighthealth.com"}, {"sw_prem_mktret_lab2@castlighthealth.com"}, {"wm_hrahi1@castlighthealth.com"}, {"hon10_cigna@clh.com"}
        };
    }
    
    @Test
    public void testUsers() throws Exception {
        System.out.println("[" + s + "] on thread: " + Thread.currentThread().getId());
        driver.open("http://denqa01.castlighthealth.com/");
        driver.sendKeys(By.id("email_login"), s);
        driver.sendKeys(By.id("password_login"), "monkey55");
        driver.click(By.name("commit"));
        driver.screenShot();
    }
}