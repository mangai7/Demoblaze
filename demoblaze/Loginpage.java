package demoblaze;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Loginpage extends BasePage {
	public Loginpage(WebDriver driver) {
		super(driver);
		
		
	}
		
	//Locators
		@FindBy(xpath= "//a[@id='login2']")
		WebElement txt_login;
		@FindBy(xpath= "//input[@id='loginusername']")
		WebElement txt_loginusername;
		@FindBy(xpath= "//input[@id='loginpassword']")
		WebElement txt_loginpassword;
		
		@FindBy(xpath= "//button[normalize-space()='Log in']")
		WebElement button_login;
		
		
		@FindBy(xpath= "//a[@id='logout2']")
		WebElement button_logout;

		//Action method
		public boolean isloginButtonVisible() {
		    return txt_login.isDisplayed();
		}
		public WebElement getloginButton() {
		    return txt_login;
		}
		public void login() {
			txt_login.click();
			}
		public void loginusername(String user) {
			txt_loginusername.sendKeys(user);
			}
		public void loginpassword(String password) {
			txt_loginpassword.sendKeys(password);
			}
		
		public boolean clickloginbutton() {
			//button_login.click();
			try {
				button_login.click(); // your WebElement
		        return true;
		    } catch (Exception e) {
		        return false;
		    }
		}
		public boolean logout() {
			try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.elementToBeClickable(button_logout));
		        button_logout.click();
		        return true;
		    } catch (Exception e) {
		        System.out.println("Logout failed: " + e.getMessage());
		        return false;
		    }
		}
		
}
