package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	//locations
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPwd;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div/div/ul/li[3]/a")
	@CacheLookup
	WebElement btnlogout;
	
	//ACTIONS
	
	
	public void setEmail(String user) {
		txtEmail.clear();
		txtEmail.sendKeys(user);
		
	}
	public void setPwd(String pwd) {
		txtPwd.clear();
		txtPwd.sendKeys(pwd);
		
	}
	
	
	public void clickLogin () {
		
		btnlogin.click();
	}
   public void clickLogout () {
		
		btnlogout.click();
	}
	
	
	
	

}
