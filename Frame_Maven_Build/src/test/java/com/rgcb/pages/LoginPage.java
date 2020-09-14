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
public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//input[@id='login']") WebElement usernameField ;
	@FindBy(xpath="//input[@id='password']") WebElement passwordField ;
	@FindBy(xpath="//button[@class='btn btn-primary btn-block']") WebElement loginbuttonField;
	
	public void LoginMethod(String user,String pass) {
		
	
		usernameField.sendKeys(user);
		passwordField.sendKeys(pass);
		loginbuttonField.click();
		
	}
	

}
