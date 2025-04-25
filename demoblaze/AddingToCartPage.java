package demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddingToCartPage extends BasePage {
	public  AddingToCartPage(WebDriver driver) {
		super(driver);
		}
	
	//Locators
		@FindBy(xpath= "//a[normalize-space()='Samsung galaxy s6']")
		WebElement txt_item1;
		
		@FindBy(xpath= "//h2[normalize-space()='Samsung galaxy s6']")
		WebElement txt_itemname;
		
		@FindBy(xpath= "//h3[@class='price-container']")
		WebElement txt_itemprice;
		
		@FindBy(xpath= "//p[contains(text(),'The Samsung Galaxy S6 is powered by 1.5GHz octa-co')]")
		WebElement txt_itemdescription;
		
		
		@FindBy(xpath= "//a[normalize-space()='Add to cart']")
		WebElement txt_addtocart;
		
		
		@FindBy(xpath= "//a[@id='cartur']")
		WebElement txt_carticon;
		
		
		@FindBy(xpath= "//tr[@class='success'][1]/td[2]")
		WebElement txt_cartitem;
		
		
		@FindBy(xpath= "//a[normalize-space()='Delete']")
		WebElement txt_deletebutton;
		
		@FindBy(xpath= "//button[normalize-space()='Place Order']")
		WebElement txt_placeorder;
		
		
		@FindBy(xpath= "//input[@id='name']")
		WebElement txt_name;
		
		
		@FindBy(xpath= "//input[@id='country']")
		WebElement txt_country;
		
		@FindBy(xpath= "//input[@id='city']")
		WebElement txt_city;
		
		
		@FindBy(xpath= "//button[normalize-space()='Purchase']")
		WebElement txt_purchase;
		
		
		@FindBy(xpath= "//input[@id='card']")
		WebElement txt_card;
		
		
		@FindBy(xpath= "//input[@id='month']")
		WebElement txt_month;
		
		@FindBy(xpath= "//input[@id='year']")
		WebElement txt_year;
		
		
		@FindBy(xpath= "//h2[normalize-space()='Thank you for your purchase!']")
		WebElement txt_confirm;
		
		
		@FindBy(xpath= "//button[normalize-space()='OK']")
		WebElement txt_ok;
		
		public void clickitem() {
			txt_item1.click();
		}
		
		public String getitemname() {
	        return txt_itemname.getText().trim();
	    }
		
		public String getitemprice() {
	        return txt_itemprice.getText().trim().split(" ")[0];  // Removes "includes tax"
	    }
		public String getItemDescription() {
	        return txt_itemdescription.getText().trim();
	    }
		public boolean addtocart() {
			try {
			txt_addtocart.click();
			return true;
			}
			catch(Exception e){
				return false;
			}
		}
		public void carticon() {
			txt_carticon.click();
		}
		public String getcartitem() {
			return txt_cartitem.getText().trim();
		}
		
		public boolean deleteitemfromCart() {
		    try {
		        txt_deletebutton.click();
		        return true;
		    } catch (Exception e) {
		        System.out.println("Delete button not found or not clickable: " + e.getMessage());
		        return false;
		    }
		} 
		
		
		public void placeorder() {
			txt_placeorder.click();
		}
		public void name(String user) {
			txt_name.sendKeys(user);
			}
		public void country(String country) {
			txt_country.sendKeys(country);
			}
		public void city(String city) {
			txt_country.sendKeys(city);
			}
		
		public void card(String card) {
			txt_card.sendKeys(card);
			}
		public void month(String month) {
			txt_month.sendKeys(month);
			}
		public void year(String year) {
			txt_year.sendKeys(year);
			}
		public void purchase() {
			txt_purchase.click();
		}
		public String confirm() {
			return txt_confirm.getText();
			}
		public void ok() {
			txt_ok.click();
		}
}
