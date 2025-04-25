package demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signuppage extends BasePage{
	
	public Signuppage(WebDriver driver) {
		super(driver);
		
		
	}
	
	
	//Locators
	@FindBy(xpath= "//a[@id='signin2']")
	WebElement txt_signup;
	@FindBy(xpath= "//input[@id='sign-username']")
	WebElement txt_username;
	@FindBy(xpath= "//input[@id='sign-password']")
	WebElement txt_password;
	@FindBy(xpath= "//button[normalize-space()='Sign up']")
	WebElement button_signup;
	
	
	//Action method
	public boolean isSignupButtonVisible() {
	    return txt_signup.isDisplayed();
	}
	public WebElement getSignupButton() {
	    return txt_signup;
	}
	public void signup() {
	txt_signup.click();
	}
	public void setusername(String user) {
	txt_username.sendKeys(user);
	}
	public void setpassword(String password) {
	txt_password.sendKeys(password);
	}
	public void clicksignupbutton() {
		button_signup.click();
	}
	
	}

