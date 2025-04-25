package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demoblaze.AddingToCartPage;
import demoblaze.Homepage;
import demoblaze.Loginpage;
import demoblaze.LogoutPage;

public class LogoutTest extends BaseClass {
	static WebDriver driver;
	Loginpage LP;
	AddingToCartPage AC;
	Homepage HP;
	LogoutPage LOP;
	
    @BeforeClass
	public void setUpTest() throws Exception {
	      LP = new Loginpage(BaseClass.driver);
	      AC = new AddingToCartPage(BaseClass.driver);
	      HP = new Homepage(BaseClass.driver);
	     LOP=new LogoutPage(BaseClass.driver);
	   //login
	      LP.login();
			//enter the username
		  LP.loginusername("dempres445");
			//enter the password
		  LP.loginpassword("12345677");
		  LP.clickloginbutton();
		  Thread.sleep(2000);
		
	}
    @Test
    void logoutpage() throws Exception {
    	Thread.sleep(3000);
    	LOP.logout();
    	
    }
}
