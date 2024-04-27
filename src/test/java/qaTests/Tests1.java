package qaTests;


import org.testng.annotations.Test;

import base.BaseTest;
import pageEvent.LoginPage;
import pageEvent.NomineePage;

import utils.ElementFetch;

public class Tests1 extends BaseTest {
	ElementFetch ele = new ElementFetch();
	NomineePage nominee = new NomineePage();
	LoginPage login = new LoginPage();
	
	@Test
	public void VerificationOfAddNomineeButton () throws InterruptedException {
		
		nominee.clickOnAddNominee();
		login.VerificationOfLoginFunction();
		Thread.sleep(12000);
		Thread.sleep(5000);

		
	}
	
	@Test
	public void VerificationOfExploreDropdown() throws InterruptedException
	{
		nominee.clickOnAddNominee();
		login.VerificationOfLoginFunction();
		Thread.sleep(14000);
		login.verifyDropdownOfExplore(driver);
		
		
	}
	
	@Test
	public void VerificationWhetherTheEnteredAmountIsSubtractedFromAvailableAmount() throws InterruptedException
	{
		nominee.clickOnAddNominee();
		login.VerificationOfLoginFunction();
		Thread.sleep(14000);
		login.verifyDropdownOfExplore(driver);
		login.newStake();
	}
	
	
//	@Test
//	public void VerificationOfLoginButton() throws InterruptedException {
//		nominee.clickOnAddNominee();
//		login.VerificationOfLoginFunction();
//		//login.addWait();
//		//Thread.sleep(11000);
//		
//	}

}
