package pageEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObject.NomineePageElements;
import utils.ElementFetch;

public class NomineePage {
	ElementFetch ele = new ElementFetch();

	public void clickOnAddNominee() {
		ele.getWebElement("XPATH", NomineePageElements.AddNominee).click();
	}

	public void FillNomineeForm() throws InterruptedException {
		ele.getWebElement("CSS", NomineePageElements.Fname).sendKeys("Vaibhav");
		ele.getWebElement("CSS", NomineePageElements.email).sendKeys("vpps@yahooo.com");
		//WebElement percentageField = ele.getWebElement("CSS", NomineePageElements.percentage);
		//Thread.sleep(3000);
		//percentageField.clear();
		//Thread.sleep(3000);
		//percentageField.sendKeys("20");

		WebElement relationshipDropdown = ele.getWebElement("CSS", NomineePageElements.relationshipDropdown);
		Select dropdown = new Select(relationshipDropdown);
		dropdown.selectByVisibleText("Father");
		ele.getWebElement("CSS", NomineePageElements.AddButton).click();
	}

	public void FillAutenticatorCode() throws InterruptedException{
		for (int index = 0; index <= 5; index++) {			
			String modifiedLocator = "div.chakra-stack>input:nth-child("+(index+1)+")";
			//pin-input-:r39:-1
			ele.getWebElement("CSS", modifiedLocator).sendKeys(Integer.toString(index+1));

			
		}
	}
}
