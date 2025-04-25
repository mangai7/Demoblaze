package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import demoblaze.AddingToCartPage;
import demoblaze.Homepage;
import demoblaze.Loginpage;

public class AddingToCartTest extends BaseClass {
	static WebDriver driver;
	Loginpage LP;
	AddingToCartPage AC;
	Homepage HP;
	
    @BeforeClass
	public void setUpTest() throws Exception {
	      LP = new Loginpage(BaseClass.driver);
	      AC = new AddingToCartPage(BaseClass.driver);
	      HP = new Homepage(BaseClass.driver);
	      
		
	}
    @Test(priority = 1)
	void testitemname() throws Exception {
		AC.clickitem();
		Thread.sleep(2000);
		String expectedname = "Samsung galaxy s6";
		String itemname = AC.getitemname();
		Assert.assertEquals(itemname, expectedname);
	}
	
    @Test(priority = 2)
	void testdisplayeddetails() {
		String price=AC.getitemprice();
		String expected="$360";
		Assert.assertEquals(price.toLowerCase(), expected.toLowerCase(), "Price does not match (ignoring case)");
		String description=AC.getItemDescription();
		String excepted ="The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.";
		Assert.assertEquals(description.toLowerCase(), excepted.toLowerCase(), "Price does not match (ignoring case)");
		
	}
	
	@Test(priority = 3)
	void testAddToCart() {
		// Step 1: Click "Add to cart"
	    boolean result = AC.addtocart();
	    Assert.assertTrue(result, "Add to cart button click failed");

	    // Step 2: Wait and handle alert confirmation
	    WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    String alertText = alert.getText();
	    alert.accept();

	    // Step 3: Assert alert message
	    Assert.assertEquals(alertText.trim(), "Product added", "Cart confirmation alert did not match.");

	    System.out.println("Item added to cart successfully.");
	}
	
	@Test(priority = 4)
	void testproductadd() {
	    // Step 1: Click cart icon to go to cart page
	    AC.carticon();

	    // Step 2: Get actual item name in cart
	    String actual = AC.getcartitem();

	    // Step 3: Define expected item
	    String expected = "Samsung galaxy s6";

	    // Step 4: Assertion (case-insensitive)
	    Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase(), "Cart item mismatch");

	    System.out.println("Cart item verification passed: " + actual);
	}
	
	@Test(priority = 5)
	void testdeleteitemfromCart() throws InterruptedException {
	    
		HP.clickhome();
		
		
		AC.carticon(); // Navigate to cart
	    boolean deleted = AC.deleteitemfromCart();
	    Assert.assertTrue(deleted, "Failed to click delete");

	    Thread.sleep(1500); // Use WebDriverWait for production

	    List<WebElement> items = BaseClass.driver.findElements(By.xpath("//tr[@class='success']"));
	    Assert.assertEquals(items.size(), 0, "Cart still has items after deletion");
	    
	}

	@Test(priority = 6)
	void testpurchase() throws Exception {
		HP.clickhome();
		AC.clickitem();
		AC.addtocart();
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    alert.accept();
		AC.carticon();
		AC.placeorder();
		AC.name("sheela");
		AC.country("India");
		Thread.sleep(500);
		AC.city("chennai");
		AC.card("1234567");
		AC.month("feb");
		AC.year("2025");
		AC.purchase();
		
		  String result=AC.confirm();

	    // Step 3: Assert alert message
	    Assert.assertEquals(result, "Thank you for your purchase!", "not purchased");

	    System.out.println("Purchased successfully.");
	    
	    
	    
	
	
	}
	

}
