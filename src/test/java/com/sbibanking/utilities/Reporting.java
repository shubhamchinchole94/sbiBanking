
package com.sbibanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentSparkReporter extentSparkReporter; // UI of report
	public ExtentReports extentReports; // common info
	public ExtentTest extentTest;     //test case entries (pass,fail,skip,flush)
	
	
	public void onStart(ITestContext context) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timestamp+".html";
		
		extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		try {
			extentSparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/listener-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Host name","localhost");
		extentReports.setSystemInfo("Environment","QA");
		extentReports.setSystemInfo("user","Shubham");
		
		extentSparkReporter.config().setDocumentTitle("SBI Banking Test Project");
		extentSparkReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		extentSparkReporter.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr) {
		extentTest=extentReports.createTest(tr.getName());// create new entry in report
		extentTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted

	}
	
	public void onTestFailure(ITestResult tr) {
		extentTest=extentReports.createTest(tr.getName());// create new entry in report
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // failed info in RED
        
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
        
		File f = new File(screenshotPath); 
		
		 if (f.exists()) {
	            extentTest.fail("Screenshot is below:").addScreenCaptureFromPath(screenshotPath);
		}

	}
	public void onTestSkipped(ITestResult tr)
	{
		extentTest=extentReports.createTest(tr.getName()); // create new entry in the report
		extentTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
        extentReports.flush(); // flush all reports
	}
	
	

}
