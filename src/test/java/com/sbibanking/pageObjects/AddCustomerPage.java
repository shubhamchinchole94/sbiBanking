package com.sbibanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	
	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	
	/*
	 * All locators on add customer page
	 * 
	 */

	@FindBy(xpath = "//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement customerLink;

	@FindBy(xpath = "//input[@name='name']")
	@CacheLookup
	WebElement name;

	@FindBy(name = "rad1")
	@CacheLookup
	WebElement gender;

	@FindBy(name = "dob")
	@CacheLookup
	WebElement dob;

	@FindBy(xpath = "//textarea[@name='addr']")
	@CacheLookup
	WebElement address;

	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	WebElement city;

	@FindBy(xpath = "//input[@name='state']")
	@CacheLookup
	WebElement state;

	@FindBy(xpath = "//input[@name='pinno']")
	@CacheLookup
	WebElement pin;

	@FindBy(xpath = "//input[@name='telephoneno']")
	@CacheLookup
	WebElement phone;

	@FindBy(xpath = "//input[@name='emailid']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//input[@name='sub']")
	@CacheLookup
	WebElement submit;
	
	

	/*
	 * Action method for locators
	 * 
	 * 
	 */
	
	public void newCustomer() {
		customerLink.click();
	}
	
	public void custName(String cName) {
		name.sendKeys(cName);
	}
	
	public void cGender(String Cgender) {
		gender.click();		}
	
	public void datOdBirth(String mm,String dd,String yy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
	}
	public void cuAddress(String Caddress) {
		address.sendKeys(Caddress);
	}
	
	public void cuscity(String ccity) {
		city.sendKeys(ccity);
	}
	public void custate(String cstate) {
		state.sendKeys(cstate);
		}	
	
	public void custpinno(String cpinno) {
		pin.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		phone.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		email.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		password.sendKeys(cpassword);
	}

	public void custsubmit() {
		submit.click();
	}
	
	
}
