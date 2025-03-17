package stepdefinition;

import io.cucumber.java.After; 
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import pages.FiltersPage;
import utils.BrowserFactory;

public class FiltersSteps {
	private WebDriver driver;
	private FiltersPage filtersPage;

	@Given("I am on the Bookswagon search results page for {string}")
	public void i_am_on_the_bookswagon_search_results_page_for(String searchTerm) {
		// Set up WebDriver and navigate to the search results page
		String browser = System.getProperty("browser", "chrome"); // Default to Chrome
	    driver = BrowserFactory.getDriver(browser);
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com/search-books/harry-potter");

		// Initialize the FiltersPage object
		filtersPage = new FiltersPage(driver);

		// Assert the page is loaded
		// Assert.assertTrue(driver.getTitle().contains(searchTerm), "Search results
		// page not loaded!");
	}

	@When("I click on the price filter {string}")
	public void i_click_on_the_price_filter(String priceRange) throws InterruptedException {
		filtersPage.clickPriceFilter(priceRange);
		Thread.sleep(5000);
	}

	@When("I click on the discount filter {string}")
	public void i_click_on_the_discount_filter(String discountRange) throws InterruptedException {
		filtersPage.clickDiscountFilter(discountRange);
		Thread.sleep(5000);
	}

	@When("I click on the language {string}")

	public void i_click_on_the_language(String language) throws InterruptedException {
		filtersPage.clickLanguageFilter(language);
		Thread.sleep(5000);
	}

	@Then("I should see the search results filtered")
	public void i_should_see_the_search_results_filtered() {
		filtersPage.validateSearchResults();
		filtersPage.takeScreenshot();
	}
	@After
	public void teardown() {
		 if(driver!=null){
			 driver.quit(); }
	}

}
