package qaTests;

import java.time.Duration;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvent.LoginPage;
import pageEvent.NomineePage;
import utils.ElementFetch2;

public class Test2 extends BaseTest {
	
	ElementFetch2 ele;
	NomineePage nominee = new NomineePage();
	LoginPage login = new LoginPage();


	@Test
	public void VerificationofAddNomineeButton() throws InterruptedException {
		ele = new ElementFetch2(driver); // Initialize ele with driver after it's properly initialized
		nominee.clickOnAddNominee();
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
		nominee.clickOnAddNominee();
		ele.enterEmail("aranjan@qamentor.com");
		ele.enterPassword("Qamentor@2024");
		ele.clickLoginButton();
		Thread.sleep(14000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		ele.exploringDropDrown();
		ele.newStake();
	}

}
