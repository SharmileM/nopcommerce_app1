package com.nopcommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	
	public WebDriver driver;
	
	public SearchCustomerPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		}
	
	
	@FindBy(how = How.ID, using ="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	
	@FindBy(how = How.ID, using ="SearchFirstName")
	@CacheLookup
	WebElement txtFName;
	
	@FindBy(how = How.ID, using ="SearchLastName")
	@CacheLookup
	WebElement txtLName;
	
	@FindBy(how = How.ID, using ="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"customers-grid\"]/tbody")
	@CacheLookup
	WebElement wTable;
	
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"customers-grid\"]/tbody/tr")
	@CacheLookup
	List<WebElement > wTableRows;
	
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"customers-grid\"]/tbody/tr[1]/td")
	@CacheLookup
	List<WebElement > wTableCols;
	
	public void srchByEmail(String email) {
		
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
	}

	public void srchByFName(String fname) {
		
		txtFName.clear();
		txtFName.sendKeys(fname);
		
	}
public void srchByLName(String lname) {
		
	    txtLName.clear();
		txtLName.sendKeys(lname);
		
	}

public void clickSrch() {
	
	btnSearch.click();
	
	
}


public int getNoOfRows() {
	
	return wTableRows.size();
}
	
public int getNoOfCols() {
	
	return wTableCols.size();
}




public boolean srchCustomerByEmail(String email) {
	
	boolean flag = false;
	for(int i =1;i<= getNoOfRows();i++) {
		
		
		String emailid = driver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
		
		System.out.println(emailid);
		
		if (emailid.equals(email)) {
			
			flag = true;
			break;
			
		}
		
		
	}
	return flag;
}
	
	public boolean srchCustomerByName(String Name) {
		
		boolean flag = false;
		for(int i =1;i<= getNoOfRows();i++) {
			
			
			String name= driver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]")).getText();
			
			System.out.println(name);
			
			if (name.equals(Name)) {
				
				flag = true;
				break;
				
			}
			
			
		}
		return flag;

}




		
	

}
