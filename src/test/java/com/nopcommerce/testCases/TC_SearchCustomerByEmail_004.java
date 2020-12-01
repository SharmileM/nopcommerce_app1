package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByEmail_004 extends BaseClass{
	
	@Test(groups = {"regression","master"})
	public void searchCustomerByEmail() throws InterruptedException, IOException {
		
      logger.info("******Starting TC_SearchCustomerByEmail_004******");
		
		driver.get(configPropObj.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("******Providing login details******");
		
		lp.setEmail(configPropObj.getProperty("uname"));
		lp.setPwd(configPropObj.getProperty("pwd"));
		lp.clickLogin();
		logger.info("******Starting Customer Menu******");
		
		AddCustomerPage cp = new AddCustomerPage(driver);
		cp.clickCustomerMenu();
		cp.clickCustomerMenuItem();
	
		//cp.clickCustInfo() ;
		Thread.sleep(3000);
		
		//search customerby email
		
		logger.info("******Searching customer by email******");
		
		SearchCustomerPage scp = new SearchCustomerPage (driver);
		
		scp.srchByEmail("arthur_holmes@nopCommerce.com");
		scp.clickSrch();
		
		if(scp.srchCustomerByEmail("arthur_holmes@nopCommerce.com")) {
			
			logger.info("******Email found and test passed ******");
			Assert.assertTrue(true);
			
		}
		else
		
			{
			logger.info("******Email not found and test failed ******");	
		    captureScreen(driver,"SearchCustomerByEmail");
		
		Assert.assertTrue(false);
			}
		logger.info("******TC_SearchCustomerByEmail_004 finished ******");	
		
		
		
	}
	
	
	
	
	
	

}
