package com.sbibanking.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sbibanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException 
	{
		
		
		webdriver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(webdriver);
		lp.setUserName(username);
		logger.info("Enter username");

		lp.setPassword(password);
		logger.info("Enter password");

		lp.clickSubmit();
		
		if(webdriver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");

		}
		else
		{
			captureScreen(webdriver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test ");

		}
		
	}
	
	

}
