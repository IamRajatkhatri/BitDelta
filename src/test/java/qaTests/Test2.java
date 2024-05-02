package qaTests;

import java.time.Duration;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvent.LoginPage;
import pageEvent.NomineePage;
import utils.ElementFetch2;
import utils.ElementFetchNominee;

public class Test2 extends BaseTest {
	
	ElementFetch2 ele;
	ElementFetchNominee nominee;
	

	@Test
	public void VerificationofAddNomineeButton() throws InterruptedException {
		ele = new ElementFetch2(driver); 
		nominee = new ElementFetchNominee(driver);// Initialize ele with driver after it's properly initialized
		nominee.ClickOnAddNomineeButton();
		ele.enterEmail("aranjan@qamentor.com");
		ele.enterPassword("Qamentor@2024");
		ele.clickLoginButton();
		Thread.sleep(12000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	}


	
	@Test
	public void VerificationWhetherTheEnteredAmountIsSubtractedFromAvailableAmount() throws InterruptedException
	{
		ele = new ElementFetch2(driver);
		nominee = new ElementFetchNominee(driver);// Initialize ele with driver after it's properly initialized
		nominee.ClickOnAddNomineeButton();
		ele.enterEmail("aranjan@qamentor.com");
		ele.enterPassword("Qamentor@2024");
		ele.clickLoginButton();
		Thread.sleep(14000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		ele.exploringDropDrown();
		ele.newStake();
	}

}
