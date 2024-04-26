package pageObject;

public interface LoginPageElements {

	
	String emailField = "//input[@placeholder='Email']";
	String passwordField = "//input[@placeholder='Password']";
	String loginButton="//button[normalize-space()='Log In']";
	String OTPField = "(//div[@class=\"css-uyzd6l\"]//input)[]";  //*[@id="pin-input-:Rcrd9mkpf9jda:-0"]
	String Text = "/html/body/div[2]/div/div/p";
}
