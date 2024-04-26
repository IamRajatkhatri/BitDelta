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
		login.FillOTP();
		Thread.sleep(5000);
		nominee.clickOnAddNominee();
		nominee.FillNomineeForm();
		nominee.FillAutenticatorCode();
		
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
