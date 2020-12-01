package com.nopcommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.DriverManager;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_AddCustomerTest_003  extends BaseClass{
	
	
@Test(groups = {"sanity","regression","master"})

public void addCustomer() throws InterruptedException, IOException	{
	 
	 logger.info("******Starting TC_AddCustomerTest_003 ******");
	
	driver.get(configPropObj.getProperty("url"));
	
	LoginPage lp = new LoginPage(driver);
	
	logger.info("******Providing login details******");
	
	lp.setEmail(configPropObj.getProperty("uname"));
	lp.setPwd(configPropObj.getProperty("pwd"));
	lp.clickLogin();
	Thread.sleep(3000);
	
	
	logger.info("******Starting Customer Menu******");
	
	AddCustomerPage cp = new AddCustomerPage(driver);
	cp.clickCustomerMenu();
	cp.clickCustomerMenuItem();
	cp.clickAddNew();
	//cp.clickCustInfo() ;
	Thread.sleep(3000);
	
	logger.info("***************  Providing customer details  *********** ");
	cp.setEmail(randomestring()+"@gmail.com");
	cp.setPwd("test123");
	cp.setFName("Sam")	;
	cp.setLName("Tom")	;
	cp.selectGender("Male");
	cp.setDOfBirth("12/04/1990");
	cp.setCompName("scrt");
	cp.setCustomerRoles("Guests") ;
	Thread.sleep(3000);
	cp.SelectCompanyVendor("Vendor 2");
	cp.SetAdminComment("test message..");
	

	
	
	cp.ClickSave() ;
	Thread.sleep(3000);
	logger.info("moving to next page*****************");
	
	
	
	//validation
	
	if(cp.txtMessage()) {
		
		logger.info("***************  Customer added succesfully *********** ");
		Assert.assertTrue(true);
		
	}
	else {
		logger.error("*************** Customer Not added succesfully *********** ");
		captureScreen(driver,"addCustomer");
		Assert.assertTrue(false);
		
		
	}

	logger.info("***************   TC_AddCustomerTest_003 Finished  *********** ");
	}




	
}






