package com.sbibanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sbibanking.pageObjects.AddCustomerPage;
import com.sbibanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		LoginPage lp = new LoginPage(webdriver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword name is provided");

		lp.clickSubmit();
		
		Thread.sleep(3000);
		logger.info("customer details providing");

		
		AddCustomerPage addcust = new AddCustomerPage(webdriver);
		
		addcust.newCustomer();
		addcust.custName("Pawanppp");
		addcust.cGender("male");
		addcust.datOdBirth("11", "12", "1998");
		Thread.sleep(4000);
		addcust.cuAddress("Pune");
		addcust.cuscity("Pune");
		addcust.custate("Maharashtra");
		addcust.custpinno("422009");
		addcust.custtelephoneno("1234567");
		String mail = generateRandomAlphabeticString() + "@gmail.com";
		addcust.custemailid(mail);
		addcust.custpassword("abcefq");
		addcust.custsubmit();
		Thread.sleep(5000);
        
		logger.info("validation started....");
		WebDriver webDriver;
		boolean res = webdriver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Testcase is passed");

		} else {
			logger.info("Testcase is failed");
			captureScreen(webdriver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
		
	
}
