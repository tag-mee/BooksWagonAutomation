package stepdefinition;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ProductVerification;
import utils.BrowserFactory;

public class ProductVerificationSteps {
	private WebDriver driver;
	private ProductVerification product;

	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
		String browser = System.getProperty("browser", "firefox"); // Default to Chrome
	    driver = BrowserFactory.getDriver(browser);
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com/login");
		product = new ProductVerification(driver);
	}
	@Then("I log in with valid credentials {string} and {string}")
	public void i_log_in_with_valid_credentials_and(String string, String string2) {
		product.loginWithCredentials(string, string2);
	}
	@Then("I navigate to search for {string}")
	public void i_navigate_to_search_for(String string) {
		product.getToRequirement(string);
	}

	@Then("I should see the product title as {string}")
	public void i_should_see_the_product_title_as(String string) {
		Assert.assertEquals(string, product.getProductTitle(), "The Title does not matches and Exist");
		System.out.println("The title matches");
	}

	@Then("I should see the product description")
	public void i_should_see_the_product_description() {
		System.out.println(product.getProductDescription());

	}

	@Then("I should see the product price as {string}")
	public void i_should_see_the_product_price_as(String string) {
		String price = product.getProductPrice();
		Assert.assertEquals(string, price, "The Price doesnt match");
		System.out.println("The price matches and it is :" + price);
	}

	@Then("I should see that the product is available")
	public void i_should_see_that_the_product_is_available() {
		String avail = product.getProductAvailability();
		Assert.assertEquals("Available", avail, "The product is Not Available");
		System.out.println("The Product is Available");
	}

	@Then("I add product to wishlist")
	public void i_add_product_to_wishlist() {
		product.clickAddToWishlist();
		System.out.println("Product is added to wishlist");
	}


	@When("I click on the {string} button")
	public void i_click_on_the_button(String string) {
		driver.navigate().to("https://www.bookswagon.com/wishlist.aspx");
	}

	@Then("the product should be added to my wishlist")
	public void the_product_should_be_added_to_my_wishlist() {
		String title = product.getWishlistTitle();
		String Expected = "Adventures of Sherlock Holmes";
		Assert.assertEquals(Expected, title,"THe product is not added to wishlist");
		System.out.println("The Product is Succesfully Verifed in the wishlist!!");
		
	}
	@After
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
