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
public class IndentPageClick {
	WebDriver driver;
	public IndentPageClick(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//span[@class='d-none d-sm-inline'][contains(text(),'Create')]") WebElement createIndent ;
	
	
	public void indentClick() {

		createIndent.click();
		
	}
	

}
