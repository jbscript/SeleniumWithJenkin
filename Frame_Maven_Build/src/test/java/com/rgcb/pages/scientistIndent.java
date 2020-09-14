/**
 * 
 */
package com.rgcb.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Jabir Jaleel
 *
 */
public class scientistIndent {
	WebDriver driver;

	public scientistIndent(WebDriver ldriver) {

		this.driver = ldriver;
	}

	//ALL SCIENTIS PAGE ELEMENT LOCATOR
	
	@FindBy(className = "ui-autocomplete-input")
	List<WebElement> allElements;

	@FindBy(name = "section")
	WebElement section;

	@FindBy(name = "point_of_delivery")
	WebElement delivery;

	@FindBy(xpath = "//div[@name='product_id']//input[@class='o_input ui-autocomplete-input']")
	WebElement product;

	@FindBy(xpath = "//span[contains(text(),'Send For Approval')]")
	WebElement Approval;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement save;

	@FindBy(xpath = "//span[@class='oe_topbar_name']")
	WebElement toolbar;

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logout;

	@FindBy(xpath = "//span[@class='o_form_label']")
	WebElement success;

	//SCIENTIST DATA METHOD 
	
	public void IndentData(String IndentType, String FundType, String HeadofAccount, String FundSource, String Section,
			String PointofDelivery, String Product) throws Exception {

		allElements.get(0).clear();
		allElements.get(0).sendKeys(IndentType);
		
		allElements.get(1).clear();
		allElements.get(1).sendKeys(FundType);
		Thread.sleep(1000);
		allElements.get(1).sendKeys(Keys.ENTER);

		allElements.get(2).clear();
		allElements.get(2).sendKeys(HeadofAccount);
		Thread.sleep(1000);
		allElements.get(2).sendKeys(Keys.ENTER);

		allElements.get(3).clear();
		allElements.get(3).sendKeys(FundSource);
		Thread.sleep(2000);
		allElements.get(3).sendKeys(Keys.ENTER);
		
		allElements.get(3).sendKeys(Keys.TAB);
		allElements.get(3).sendKeys(Keys.TAB);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		section.sendKeys(Section);
		delivery.sendKeys(PointofDelivery);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		product.sendKeys(Product);
		product.sendKeys(Keys.ARROW_DOWN);
		product.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Approval.click();
		Thread.sleep(3000);
		save.click();
		WebDriverWait wait=new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Print')]")));
		System.out.println("Success Indent Order");
		//wait.until(ExpectedConditions.titleContains("Inbox - Odoo"));
		//String ac = success.getText();
		//Assert.assertEquals(ac, "Indent Order");
	}
	
	//SCIENTIST LOGOUT METHOD 
	
	public void scientisLogout() {
		toolbar.click();
		logout.click();

	}

}
