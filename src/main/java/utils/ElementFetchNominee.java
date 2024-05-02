package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObject.NomineePageElements;

public class ElementFetchNominee implements NomineePageElements {

	WebDriver driver;
	
	@FindBy(xpath = AddNominee)
	WebElement addNominee;
	
	@FindBy(css = Fname)
	WebElement firstName;
	
	@FindBy(css = email)
	WebElement Email;
	
	 public ElementFetchNominee(WebDriver driver) {
	    	this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	public void ClickOnAddNomineeButton()
	{
		addNominee.click();
	}
}
