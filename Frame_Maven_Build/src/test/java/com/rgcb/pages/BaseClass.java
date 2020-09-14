/**
 * 
 */
package com.rgcb.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.rgcb.utility.BrowserFactory;
import com.rgcb.utility.ConfigDataProvider;
import com.rgcb.utility.ExcelDataProvider;
import com.rgcb.utility.Helper;

/**
 * @author Jabir Jaleel
 *
 */
public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;

	// 3 CLASS NEEDED TO GENERATE REPORT
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest logger;

	@BeforeSuite
	public void setupExcel() {
		//CREATE DATAPROVIDER OBJECT
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		// 3 CLASS NEEDED TO GENERATE REPORT
		htmlReporter = new ExtentHtmlReporter("./Reports/Report"+Helper.getdateTime()+".html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
		//EXTRA INFO

		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Framework", "Selenium");
		report.setSystemInfo("author", "Jabir Jaleel");

		htmlReporter.config().setDocumentTitle("Automation extent Demo");
		htmlReporter.config().setReportName("jabis report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.StartBrowser(driver, config.Browser(), config.RgcbLoginUrl());
	}

	@AfterTest
	public void tearDown() {
	//	 BrowserFactory.closeBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			String imgpath= Helper.captureScreenshot(driver);
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(imgpath).build());
			
		}
		report.flush();

	}
	
	@AfterSuite
	public void tearDownAll() {
		// BrowserFactory.QuitBrowser(driver);
	}
	
	
	
	

}
