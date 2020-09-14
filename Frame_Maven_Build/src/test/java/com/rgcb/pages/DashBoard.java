/**
 * 
 */
package com.rgcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Jabir Jaleel
 *
 */
public class DashBoard {
	WebDriver driver;
	public DashBoard(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//li[2]//a[1]//img[1]") WebElement IndentButton ;

	
	public void ClickIndent() {
		
		IndentButton.click();
		
	}
	

}
