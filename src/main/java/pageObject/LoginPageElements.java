package pageObject;

public interface LoginPageElements {

	
	String emailField = "//input[@placeholder='Email']";
	String passwordField = "//input[@placeholder='Password']";
	String loginButton="//button[normalize-space()='Log In']";
	String OTPField = "(//div[@class=\"css-uyzd6l\"]//input)[]";  //*[@id="pin-input-:Rcrd9mkpf9jda:-0"]
	String Text = "/html/body/div[2]/div/div/p";
	String ExploreDrop = "body > div.css-ejeobc > div > div.css-zntmzz > div:nth-child(1)";
	String Staking = "(//p[contains(text(),'Staking')])[1]";
	String stakeNowBtn = "//button[normalize-space()='Stake Now']";                      
	String LockAmountbtn = "/html/body/div[7]/div[3]/div/section/div/div[3]/div[1]/input";
//	String AvailableAmount = "/html/body/div[7]/div[3]/div/section/div/div[4]/p"; 
	String AvailableAmount = "//div[@class='css-rp047g']/p";
	String stakeText ="/html/body/div[2]/div[2]/div/div/div[1]/h2";
	String CheckBox = "/html/body/div[7]/div[3]/div/section/div/div[7]/label/span[1]";
	String StakeEndButton = "/html/body/div[7]/div[3]/div/section/div/div[8]/button";
	String mt5button = "accordion-button-:r39:";
	String loginPage = "#chakra-modal--body-\\:Rnaapf9jda\\: > div.css-1jagptf > button.chakra-button.css-nys2f1";
	
}


//lockamount css = /html/body/div[7]/div[3]/div/section/div/div[3]/div[1]/input