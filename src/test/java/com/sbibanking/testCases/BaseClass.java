package com.sbibanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.sbibanking.utilities.ReadConfig;

public class BaseClass {
	
	
	ReadConfig config = new ReadConfig();
	
	public String baseURL =config.getApplicationURL();
	
	
	public String username=config.getUsername();
	public String password=config.getPassword();
	

	
	
	
	public static WebDriver webdriver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) 
	{
		
		logger = Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("Log4j.properties");
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + config.chromePath());
		//webdriver= new ChromeDriver();
//		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + config.edgepath());
//		
//
//		EdgeOptions options = new EdgeOptions();
//	    options.setAcceptInsecureCerts(true); // Allow insecure certificates if needed
//	    webdriver = new EdgeDriver(options);

		if(br.equals("chrome"))
		{
			webdriver= new ChromeDriver();
		    webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else
		{
			webdriver= new EdgeDriver();
		    webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		webdriver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		webdriver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	

	@SuppressWarnings("deprecation")
	public String generateRandomAlphabeticString() {
		return RandomStringUtils.randomAlphabetic(8);
	}

	@SuppressWarnings("deprecation")
	public static String randomNum() {
		return RandomStringUtils.randomNumeric(4);
	}

}
