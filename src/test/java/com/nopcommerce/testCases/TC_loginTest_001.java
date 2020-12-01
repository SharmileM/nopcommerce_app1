package com.nopcommerce.testCases;

import java.io.IOException;
import java.sql.DriverManager;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_loginTest_001 extends BaseClass {

	
	@Test(groups = {"sanity","regression","master"})
	
	public void loginTest() throws IOException {
		logger.info("******Starting TC_LoginTest_001******");
		
		driver.get(configPropObj.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("******Providing login details******");
		
		lp.setEmail(configPropObj.getProperty("uname"));
		lp.setPwd(configPropObj.getProperty("pwd"));
		lp.clickLogin();
		
		String act_title = "Dashboard / nopCommerce administration";
		String exp_title = driver.getTitle();
		logger.info("******Comparing titles******");
		
		if(exp_title.equals(act_title)) {
			logger.info("******Login Test passed*****");
			Assert.assertTrue(true);
		}
		else {
			logger.error("******Login Test failed*****");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			
		}
		
		
		
		logger.info("*****Finished TC_LoginTest_001******");
		
	}
	
	
	
	
	
	
		
		
		
		
	}
	
	
	


