package demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
	public  LogoutPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath= "//a[@id='logout2']")
	WebElement txt_logout;
	
	public void logout() {
		txt_logout.click();
	}
}


