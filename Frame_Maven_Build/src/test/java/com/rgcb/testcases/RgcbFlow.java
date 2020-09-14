 /**
 * 
 */
package com.rgcb.testcases;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rgcb.pages.BaseClass;
import com.rgcb.pages.DashBoard;
import com.rgcb.pages.IndentPageClick;
import com.rgcb.pages.LoginPage;
import com.rgcb.pages.scientistIndent;




/**
 * @author Jabir Jaleel
 *
 */
public class RgcbFlow extends BaseClass {
	
	

	@Test
	public void loginTorgcb() {
		
		//LOGGING INFO TO EXTENT REPORT
		
		logger = report.createTest("LOGIN TO RGCB");
		logger.info("STARTING APP | CURRENT URL: "+ driver.getCurrentUrl());
		
		//LOGGING IN USING USER AND PASS FROM EXCEL
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.LoginMethod(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		
		//VALIDATING LOGIN
		
		WebDriverWait wait=new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.titleContains("Inbox - Odoo"));
		String ac= driver.getTitle();
		Assert.assertEquals(ac, "Inbox - Odoo");
		
		
		//DASH-BOARD NAVIGATION
		
		DashBoard dashboard = PageFactory.initElements(driver, DashBoard.class);
		dashboard.ClickIndent();
		
		//Validating To Extend
		logger.pass("LOGIN SUCCESS");
		
	}
	
	@Test(dependsOnMethods = {"loginTorgcb"})
	public void writingIndent() throws Exception {
		
		logger = report.createTest("SCIENTIST WRITING INTEND IN RGCB");
		logger.info("WRITING APP | CURRENT URL: "+ driver.getCurrentUrl());
		
		//CREATING AN INDENT BY SCIENTIST
		
		IndentPageClick indentpage=PageFactory.initElements(driver, IndentPageClick.class);
		indentpage.indentClick();		
		
		//ENTERING DATA BY SCIENTIST
		
		scientistIndent scientist=PageFactory.initElements(driver, scientistIndent.class);
		scientist.IndentData("Indent for Others","Core Grant","GIA - General","GIP_CAP","MSL","Payyanur","[E-COM08] Storage Box");
		
		
		//SCIENTIST LOGOUT
		
		scientist.scientisLogout();	
		
		//Validating To Extend
		logger.pass("WRITING SUCCESS");
			
		
	}
	
	
	
	
	
	
	
	
	
}
