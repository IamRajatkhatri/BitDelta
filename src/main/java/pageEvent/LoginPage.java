package pageEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import pageObject.LoginPageElements;
import utils.ElementFetch;

public class LoginPage {
	
	WebDriver driver;
	ElementFetch ele = new ElementFetch();
	JavascriptExecutor js;
	
//	public LoginPage(WebDriver driver) {
//		this.driver = driver;
//	}

	public void VerificationOfLoginFunction() throws InterruptedException {
		Thread.sleep(1000);
		ele.getWebElement("XPATH", LoginPageElements.emailField).sendKeys("aranjan@qamentor.com");
		ele.getWebElement("XPATH", LoginPageElements.passwordField).sendKeys("Qamentor@2024");
		ele.getWebElement("XPATH", LoginPageElements.loginButton).click();
		
	}

//	public void FillOTP() throws InterruptedException {
//		for (int index = 0; index <= 5; index++) {
//
//			// Construct the modified locator
//			String modifiedLocator = "//*[@id=\"pin-input-:Rcrd9mkpf9jda:-" + index + "\"]";
//
//			// WebElement otpField = driver.findElement(By.xpath(modifiedLocator));
//			ele.getWebElement("XPATH", modifiedLocator).sendKeys(Integer.toString(index+1));
//
//		}
//
//	}
	
	public void verifyDropdownOfExplore(WebDriver driver) throws InterruptedException
	{
		WebElement dropdown = ele.getWebElement("CSS", LoginPageElements.ExploreDrop);
		Actions action = new Actions(driver);
		action.moveToElement(dropdown).build().perform();
		Thread.sleep(12000);
		ele.getWebElement("XPATH", LoginPageElements.Staking).click();
		
		WebElement text = ele.getWebElement("XPATH", LoginPageElements.stakeText);
		
		if(text.isDisplayed())
		{
		    System.out.println("page staking");
		}
		else
		{
			System.out.println("page not found");
		}
		
		
	}
	
	public void newStake() throws InterruptedException
	{
		WebElement stakebtn = ele.getWebElement("XPATH", LoginPageElements.stakeNowBtn);
		stakebtn.click();
	
		    // Find the "Lock Amount" text field and enter an amount
		    WebElement lockAmountField = ele.getWebElement("XPATH", LoginPageElements.LockAmountbtn);
		    double amountToStake = 0.03; // Enter the amount you want to stake
		    lockAmountField.sendKeys(String.valueOf(amountToStake));
		    System.out.println("amount entered");

		    // Find the "Available Amount" text in the popup and get the initial available amount
		    WebElement availableAmountText = ele.getWebElement("XPATH", LoginPageElements.AvailableAmount);
		    double initialAvailableAmount = extractBitcoinValue(availableAmountText.getText());
		    System.out.println(initialAvailableAmount);
		    System.out.println("got text");
		    
		    
		    WebElement checkbox = ele.getWebElement("XPATH", LoginPageElements.CheckBox);
		    checkbox.click();
		    System.out.println("checkbox ticked");

		    // Click the "Stake" button in the popup
		    WebElement stakeButton = ele.getWebElement("XPATH", LoginPageElements.StakeEndButton);
		    stakeButton.click();
		    System.out.println("button pressed");
		    Thread.sleep(10000);

		    // Find the "Available Amount" text in the main page and verify it is updated correctly
		    WebElement updatedAvailableAmountText = ele.getWebElement("XPATH", LoginPageElements.AvailableAmount);
		    System.out.println(updatedAvailableAmountText);
		    double expectedAvailableAmount = initialAvailableAmount - amountToStake;
		    System.out.println(expectedAvailableAmount);
		    Assert.assertEquals(Double.parseDouble(updatedAvailableAmountText.getText()), expectedAvailableAmount, 0.01);
		    
		}
	
	
	public static double extractBitcoinValue(String text) {
	    Pattern pattern = Pattern.compile("(\\d+\\.\\d+)");
	    Matcher matcher = pattern.matcher(text);

	    if (matcher.find()) {
	        return Double.parseDouble(matcher.group());
	    } else {
	        throw new IllegalArgumentException("No Bitcoin value found in the text.");
	    }
	}
}
	
	
//	public void drawBorder(WebElement element,WebDriver driver)
//	{
//		js = ((JavascriptExecutor) driver);
//		js.executeScript("argument[0].style.border = '3px solid red'",ele);
//	}
//	
//	public void verifyPasswordIcon()
//	{
//		ele.getWebElement("CSS", LoginPageElements.loginPage).click();
//		 ele.getWebElement("CSS",LoginPageElements.passwordField ).sendKeys("qwer");
//		 WebElement passIcon = ele.getWebElement("CSS", LoginPageElements.passicon);
////		 drawBorder(passIcon);
//		 
//	}

