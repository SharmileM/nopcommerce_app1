package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;



import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByName_005 extends BaseClass{
	
	
	@Test(groups= {"master"})
	public void searchCustomerByName() throws InterruptedException, IOException {
		
      logger.info("******Starting TC_SearchCustomerByName_005******");
		
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
		
		logger.info("******Searching customer by name******");
		SearchCustomerPage scp = new SearchCustomerPage (driver);
		
		scp.srchByFName("Arthur");
		scp.srchByFName("Holmes");
		
		if(scp.srchCustomerByName("Arthur Holmes")) {
			
			logger.info("******Name found and test passed ******");
			Assert.assertTrue(true);
			
			
		}
		
		else {
			
				logger.info("******Name  not found and test failed ******");	
			    captureScreen(driver,"SearchCustomerByName");
			
			Assert.assertTrue(false);
				}
			logger.info("******TC_SearchCustomerByName_005 finished ******");	
			
			
			
		}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	

