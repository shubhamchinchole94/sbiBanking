package com.sbibanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sbibanking.pageObjects.LoginPage;
import com.sbibanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{

	@Test(dataProvider = "LoginData")
	public void loginDDt(String user,String pwd) throws InterruptedException
	{
		
		LoginPage page = new LoginPage(webdriver);

		page.setUserName(user);
		logger.info("username entered");
		page.setPassword(pwd);
		logger.info("password entered");
		page.clickSubmit();
		Thread.sleep(3000);
		
		/*
		 * Method for invalid case
		 */

		if (alertCheck() == true) {
		    webdriver.switchTo().alert().accept();
		    webdriver.switchTo().defaultContent();
		    Assert.assertTrue(false);  // Mark the test as failed
		    logger.warn("Login failed");
		} else {
		    Assert.assertTrue(true);   // Mark the test as passed
		    logger.warn("Login passed");
		    page.logout();
		    Thread.sleep(3000);
		    webdriver.switchTo().alert().accept();
		    webdriver.switchTo().defaultContent();
		}

		
	}
	
	/*
	 * Checking alert after fail username
	 */
	public boolean alertCheck() {
		try {
			webdriver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	
	/*
	 * Get the data from excel store in two dimensional array and return to testCase
	 */

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException, InterruptedException
	{
		Thread.sleep(50);
		String path = "D:\\Testing\\Selenium_ OrangeHRM_Project\\SBI_Banking_Project\\src\\test\\java\\com\\sbibanking\\testData\\LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int cocount= XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][cocount];
		
		for(int i=1;i<=rownum;i++)
		{
			
			for(int j=0;j<cocount;j++)
			{
				
				logindata[i - 1][j] = XLUtils.getCellData(path, "sheet1", i, j);
				
			}
		}
		return logindata;
		
	}
	
}
