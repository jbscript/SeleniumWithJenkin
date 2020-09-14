/**
 * 
 */
package com.rgcb.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author Jabir Jaleel
 *
 */
public class Helper {

	// Screenshot

	public static String captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imgpath=System.getProperty("user.dir") +"/Screenshots//"+getdateTime()+".png";
		try {
			FileHandler.copy(src, new File(imgpath));
			System.out.println("SCREENSHOT CAPTURED");
		} catch (Exception e) {
			System.out.println("UNABLE TO CAPTURE SCREENSHOTS " + e.getMessage());
		}
		return imgpath;

	}
	
	public static String getdateTime() {
		
		DateFormat customFormat= new SimpleDateFormat("yyMM_dd_HHmmss");
		Date currentdate=new Date();
		return customFormat.format(currentdate);
		
		
	}
	
	
	

}
