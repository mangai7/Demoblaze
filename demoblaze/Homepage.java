package demoblaze;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

	public  Homepage(WebDriver driver) {
		super(driver);
		}
		
	//Locators
	@FindBy(xpath= "//a[@id='nameofuser']")
	WebElement welcomeUser;
	
	 @FindBy(xpath ="//a[@id='itemc']")
	 List<WebElement> categoryItems;
	
	
	 @FindBy(xpath= "//li[@class='nav-item active']//a[@class='nav-link']")
	 WebElement home;
	
	 @FindBy(xpath= "//a[normalize-space()='Contact']")
	 WebElement contact;
	
	 @FindBy(xpath= "//a[normalize-space()='About us']")
	 WebElement aboutus;
	
	 @FindBy(xpath= "//a[@id='cartur']")
	 WebElement cart;
	 
	 @FindBy(xpath= "//a[@id='nava']//img")
	 WebElement logo;
	 
	public boolean isWelcomeUserDisplayed() {
	    return welcomeUser.isDisplayed();
	}
	
	public String getWelcomeUserText() {
	    return welcomeUser.getText();  // Optional: to get "Welcome demo5556"
	}
	
	public boolean areCategoriesDisplayed() {
	    return categoryItems.size() >= 2; // e.g., Phones, Laptops
	    }
	public boolean ishomeDisplayed() {
	    return home.isDisplayed();
	}
	public boolean iscontactDisplayed() {
	    return contact.isDisplayed();
	}
	public boolean isaboutusDisplayed() {
	    return aboutus.isDisplayed();
	}
	
	public boolean iscartDisplayed() {
	    return cart.isDisplayed();
	}
	
	public WebElement getWelcomeUserElement() {
	    return welcomeUser;
	}
	public boolean isLogoDisplayed() {
	    return logo.isDisplayed();
	}
	
	public WebElement getLogoElement() {
	    return logo;
	}
	public void clickhome() {
		home.click();
	}
	
}
