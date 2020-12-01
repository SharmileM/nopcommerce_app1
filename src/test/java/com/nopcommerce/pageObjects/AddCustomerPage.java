package com.nopcommerce.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	WebDriver driver;
	WebElement listitem;
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//location
	
	By lnkCustomers_menu = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a/span");
	By lnkCustomers_menuitem = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a/span");
	By btnAddNewCustomer = By.xpath("/html/body/div[3]/div[3]/div/form[1]/div[1]/div/a");
	By txtEmail  = By.id("Email");

	By txtPwd = By.id("Password");

	By txtFName = By.id("FirstName");
	By txtLName = By.id("LastName");

	By rbMale = By.id("Gender_Male");
	 By rbFemale = By.id("Gender_Female");

	


	By txtDOfBirth = By.id("DateOfBirth");

	By txtCompName = By.id("Company");

	By ckBoxTaxExempt = By.id("IsTaxExempt");

	

	/*By CustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[10]/div[2]/div/div[1]/div");

	By lstRegistered = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");

	By lstAdministrators = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");

	By lstForumModerators = By.xpath(
			"//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");


	By lstGuests = By.xpath("//*[@id=\"d5697bc4-bca0-4851-a0b4-44ac21aee3ff\"]");

	By lstVendors = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");*/
	
	

By CustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
 By txtcustomerRolesDefaultItem = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");

By lstAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstVendors=By.xpath("//li[contains(text(),'Vendors')]");
	By lstForumModerators = By.xpath(
			"//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");
	
	By drpdownmOfVendor = By.id("VendorId");
	
	By txtAdminComment = By.id("AdminComment");
	
	By btnSave = By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/button[1]");
	//By txtmsg=By.xpath("//div[@class='alert alert-success alert-dismissable']");
	
	By txtmsg = By.xpath("/html/body/div[3]/div[3]/div[1]");
			
	
	 By btncustinfo = By.xpath("//*[@id=\"customer-info\"]/div[1]/span");
	
	//Actions methods
	
	public void clickCustomerMenu() {
		
		driver.findElement(lnkCustomers_menu).click();
		
	}
public void clickCustomerMenuItem() {
		
		driver.findElement(lnkCustomers_menuitem).click();
		
	}
public void clickAddNew() {
	
	driver.findElement(btnAddNewCustomer).click();
	
}

public void clickCustInfo() {
	
	driver.findElement(btncustinfo).click();
	
}
	
	public void setEmail(String email) {
		
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPwd(String pwd) {
		
		driver.findElement(txtPwd).sendKeys(pwd);
	}
	
public void setFName(String fname) {
		
		driver.findElement(txtFName).sendKeys(fname);
	}
public void setLName(String lname) {
	
	driver.findElement(txtLName).sendKeys(lname);
}
public void setDOfBirth(String dob) {
	
	driver.findElement(txtDOfBirth).sendKeys(dob);
}
public void setCompName(String compName) {
	
	driver.findElement(txtCompName).sendKeys(compName);
}
public void ClickTaxExempt() {
	
	driver.findElement(ckBoxTaxExempt).click();
	
}	
public void SetAdminComment(String message) {
	
	driver.findElement(txtAdminComment).sendKeys(message);
	
}	



public void selectGender(String value) {
	
if(value.equals("Male")) {
		driver.findElement(rbMale).click();
	}
	else if (value.equals("Female")) {
		driver.findElement(rbMale).click();
	}
   else {
	driver.findElement(rbMale).click();}
	
}


public void setCustomerRoles(String role) throws InterruptedException

{                      

            driver.findElement(CustomerRoles).click();



            if(role.equals( "Guests"))

            {

           

                        //driver.findElement(txtcustomerRolesDefaultItem).click();
                        
                        
                      WebElement lsregister =  driver.findElement(lstRegistered);
                      JavascriptExecutor js = (JavascriptExecutor)driver;
                  	js.executeScript("arguments[0].click();", lsregister);
                  	
                  	Thread.sleep(3000);
                        
                        
                       // driver.findElement(CustomerRoles).click();
                        
                        

                  	 WebElement lsguest =  driver.findElement(lstGuests);
                  	 // JavascriptExecutor js = (JavascriptExecutor)driver;
                    	js.executeScript("arguments[0].click();", lsguest);
                  	 
                  	 

                       }
            
            else if(role.equals( "Vendors"))

            {

                       WebElement  lsvendors =  driver.findElement(lstVendors);
                        JavascriptExecutor js = (JavascriptExecutor)driver;
                    	js.executeScript("arguments[0].click();", lsvendors);

                       
            }
            
            else if(role.equals( "Administrators"))


            {

                        driver.findElement(lstAdministrators).click();
            }      
            
            else if(role.equals("Forum Moderators"))

         

                        driver.findElement(lstForumModerators).click();

            else

                        System.out.println("Default option is Registered role");   

            }









	
	public void SelectCompanyVendor(String text) {
		
		WebElement slctVendor = driver.findElement(drpdownmOfVendor);
		
		Select drp = new Select(slctVendor);
		drp.selectByVisibleText(text);
		
	}


public void ClickSave() {
	
	driver.findElement(btnSave).click();
}
public Boolean txtMessage() {
	
	String act_msg = driver.findElement(txtmsg).getText();
	if (act_msg.contains("The new customer has been added successfully")) {
		
		
		return true;
	}
	else {
		return false;
	}
}
	
	
	

	
}
