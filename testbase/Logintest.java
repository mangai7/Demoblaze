package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import demoblaze.Loginpage;
import demoblaze.Signuppage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logintest extends BaseClass {
	static WebDriver driver;
	Signuppage SP;
	Loginpage LP;
	
	
    @BeforeClass
	public void setUpTest() {
	      SP = new Signuppage(BaseClass.driver); // initialize after driver is ready
	      LP = new Loginpage(BaseClass.driver);
	    }
	
	@Test(priority = 1)
	void loginbuttonvissible() {
		boolean isloginButtonVisible = LP.isloginButtonVisible();

        // TestNG assertion to check visibility
        Assert.assertTrue(isloginButtonVisible, "login button is NOT visible.");
	
	}
	
	@Test(priority = 2)
	void loginbuttonclickable() {
		//check whether login buttton clickable
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
	    
	    try {
	        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(LP.getloginButton()));
	        Assert.assertTrue(loginBtn.isDisplayed() && loginBtn.isEnabled(), "Login button is not clickable.");
	        System.out.println("Login button is clickable.");
	    } catch (Exception e) {
	        Assert.fail("Login button was not clickable within timeout.");
	    }
	}
	

	
	@Test(priority = 3)
	void testlogin() throws Exception {
		Thread.sleep(2000);
		
		//click login button to enter on login page
		LP.login();
		//enter the username
		LP.loginusername("dempres445");
		//enter the password
		LP.loginpassword("12345677");
		//click login buttuon for login
		Assert.assertTrue(LP.clickloginbutton(), "not clicked");
		
		

}
	
	
	
	
}

