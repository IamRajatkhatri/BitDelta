package pageEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObject.LoginPageElements;
import utils.ElementFetch;

public class LoginPage {
	WebDriver driver;
	ElementFetch ele = new ElementFetch();

	public void VerificationOfLoginFunction() throws InterruptedException {
		Thread.sleep(1000);
		ele.getWebElement("XPATH", LoginPageElements.emailField).sendKeys("ashedge@qamentor.com");
		ele.getWebElement("XPATH", LoginPageElements.passwordField).sendKeys("Qamentor@2024");
		ele.getWebElement("XPATH", LoginPageElements.loginButton).click();
	}

	public void FillOTP() throws InterruptedException {
		for (int index = 0; index <= 5; index++) {

			// Construct the modified locator
			String modifiedLocator = "//*[@id=\"pin-input-:Rcrd9mkpf9jda:-" + index + "\"]";

			// WebElement otpField = driver.findElement(By.xpath(modifiedLocator));
			ele.getWebElement("XPATH", modifiedLocator).sendKeys(Integer.toString(index+1));

		}

	}

}
