package stepdefinition;

import io.cucumber.java.After; 
import io.cucumber.java.en.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserFactory;
import pages.CartAutomationPage;

public class CartSteps {
	WebDriver driver;
	CartAutomationPage cPage;
	

	@Given("I am on the Bookswagon website")
	public void i_am_on_the_bookswagon_website() {
		
		 String browser = System.getProperty("browser", "chrome"); // Default to Chrome
	     driver = BrowserFactory.getDriver(browser);
		
		driver.get("https://www.bookswagon.com/search-books/harry-potter");
		
		driver.manage().window().maximize();
		
		cPage = new CartAutomationPage(driver);

	}

	@When("I add an item to the cart")
	public void i_add_an_item_to_the_cart() throws InterruptedException {
//		Thread.sleep(5000);
		cPage.addItemToCart();
	}

	@When("I open the cart")
	public void i_open_the_cart() {
		cPage.openCart();
	}

	@When("I update the quantity to {string}")
	public void i_update_the_quantity_to(String quantity) throws InterruptedException {
		cPage.updateItemQuantity(quantity);
	}

	@When("I remove an item from the cart")
	public void i_remove_an_item_from_the_cart() throws InterruptedException {
		cPage.removeItemFromCart();
		
	}

	@Then("I should proceed to checkout")
	public void i_should_proceed_to_checkout() throws InterruptedException {
		
	    // Define explicit wait with a timeout of 5 seconds
		Thread.sleep(4000);//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	    
//	    // Wait until the checkout button is clickable
//	    
//	    By checkoutButton = By.xpath("//*[@id=\"ctl00_phBody_BookCart_lvCart_imgPayment\"]");
//	    wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)); 
	    
	    // Replace "checkoutButton" with the actual locator
	    
	    // Now proceed to checkout
	    
	    cPage.proceedToCheckout();
	}

	@Then("I login with valid credentials for checkout")
		public void I_login_with_valid_credentials_for_checkout() throws InterruptedException {
		
		cPage.LoginWithCred();
		System.out.println("Book Purchased");
		cPage.takeScreenshot(); 
		
		}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
