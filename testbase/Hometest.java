package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import demoblaze.Homepage;
import demoblaze.Loginpage;
import demoblaze.Signuppage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Hometest extends BaseClass {
	static WebDriver driver;
	Signuppage SP;
	Loginpage LP;
	Homepage HP;
	
	
    @BeforeClass
	public void setUpTest() throws Exception {
	      SP = new Signuppage(BaseClass.driver); // initialize after driver is ready
	      LP = new Loginpage(BaseClass.driver);
	      HP = new Homepage(BaseClass.driver);
	     
	      //login
	      LP.login();
			//enter the username
		  LP.loginusername("dempres445");
			//enter the password
		  LP.loginpassword("12345677");
		  LP.clickloginbutton();
		  Thread.sleep(3000);
	    }
	
	
	
    @Test(description = "Verify the welcome message is displayed after login", priority=2)
    public void testHomePage()  {
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.textToBePresentInElement(HP.getWelcomeUserElement(), "Welcome dempres445"));

        AssertJUnit.assertEquals(HP.getWelcomeUserText(), "Welcome dempres445", 
            " Expected welcome text not found.");
    }
    

	@Test(description = "Verify that all top menu buttons are displayed on the homepage", priority=1)
	void testdisplayedmenu() {
		Assert.assertTrue(HP.ishomeDisplayed(), "Home button is NOT visible.");
	    Assert.assertTrue(HP.iscontactDisplayed(), "contact button is not visible.");
	    Assert.assertTrue(HP.isaboutusDisplayed(), "aboutus button is not visible.");
	    Assert.assertTrue(HP.iscartDisplayed(), "cart button is not visible.");
	    Assert.assertTrue(LP.isloginButtonVisible(), "login button is not visible.");
	    Assert.assertTrue(SP.isSignupButtonVisible(), "siupbutton button is not visible.");


}

	
	@Test(description = "Verify that all categories are displayed on the homepage", priority=3)
	void testCategoriesDisplayed() {
		
	    Assert.assertTrue(HP.areCategoriesDisplayed(), "Categories are not displayed.");
	    

}
	@Test(description = "Verify the application logo is displayed on the homepage", priority = 4)
	public void testLogoIsDisplayed() {
	    WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(HP.getLogoElement()));

	    Assert.assertTrue(HP.isLogoDisplayed(), "Application logo is not visible.");
	}

	
}
