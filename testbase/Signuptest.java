package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demoblaze.Signuppage;




public class Signuptest extends BaseClass{

	static WebDriver driver;
	Signuppage SP;
	
	
	@BeforeClass
	public void setUpTest() {
	      SP = new Signuppage(BaseClass.driver); // initialize after driver is ready
	    }
	
	
	@Test(priority = 1)
	void testsignupvisible() {
		// Check if the signup button is visible
        boolean isSignupButtonVisible = SP.isSignupButtonVisible();

        // TestNG assertion to check visibility
        Assert.assertTrue(isSignupButtonVisible, "Sign up button is NOT visible.");
    
	}
	
	@Test(priority = 2)
	public void testSignupButtonClickable() {
        // WebDriverWait to ensure the element is clickable
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
        
        // Wait until the signup button is clickable
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(SP.getSignupButton()));

        // Assert that the signup button is clickable
        Assert.assertNotNull(signupButton, "Sign up button is NOT clickable.");
        System.out.println("Sign up button is clickable.");
    }
	

	
	@Test(priority = 3)
	void testsignup() {
		SP.signup();
		SP.setusername("dempres3905");
		SP.setpassword("12345677");
		SP.clicksignupbutton();
		 
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    String alertText = alert.getText();
	    System.out.println("Alert Text: " + alertText);

	    if (alertText.equals("Sign up successful.")) {
	        alert.accept(); // Click OK
	        System.out.println("Sign up confirmed.");
	    } else {
	        alert.dismiss(); // Click Cancel
	        System.out.println("Sign up failed: Alert dismissed.");
	       
	        
	    }
	    
	    
		
	}
	}

