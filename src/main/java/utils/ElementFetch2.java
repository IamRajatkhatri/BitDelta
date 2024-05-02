package utils;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObject.LoginPageElements;

public class ElementFetch2 implements LoginPageElements {
	
	 WebDriver driver;
	
    @FindBy(xpath = emailField)
    WebElement emailInput;

    @FindBy(xpath = passwordField)
    WebElement passwordInput;

    @FindBy(xpath = loginButton)
    WebElement loginBtn;
    
    @FindBy(css = ExploreDrop)
    WebElement exploreDrop;
    
    @FindBy(xpath = Staking)
    WebElement staking;
    
    @FindBy(xpath = stakeNowBtn)
    WebElement stakeButton;
    
    @FindBy(xpath = LockAmountbtn)
    WebElement lockBtn;
    
    @FindBy(xpath = AvailableAmount)
    WebElement availAmount;
    
    @FindBy(xpath = CheckBox)
    WebElement check;
    
    @FindBy(xpath = StakeEndButton)
    WebElement stakeEndBtn;

    public ElementFetch2(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }
    
    
    public void exploringDropDrown() throws InterruptedException {
    	Actions action = new Actions(driver);
    	action.moveToElement(exploreDrop).build().perform();
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    	Thread.sleep(12000);
    	staking.click();
    }
    
    public void newStake() throws InterruptedException
    {
    	stakeButton.click();
    	double amountToStake = 0.03;
    	lockBtn.sendKeys(String.valueOf(amountToStake));
    	System.out.println("amount entered");
    	double initialAvailableAmount = extractBitcoinValue(availAmount.getText());
    	 System.out.println(initialAvailableAmount);
		 System.out.println("got text");
    	
    	check.click();
    	 System.out.println("checkbox ticked");
    	stakeEndBtn.click();
    	System.out.println("button pressed");
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    	Thread.sleep(7000);
    	 WebElement updatedAvailableAmountText = availAmount;
    	double expectedAvailableAmount = initialAvailableAmount - amountToStake;
    	System.out.println(expectedAvailableAmount);
    	Assert.assertEquals(extractBitcoinValue(updatedAvailableAmountText.getText()), expectedAvailableAmount, 0.01);
    	
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