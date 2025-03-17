package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.BrowserFactory;
import pages.CartAutomationPage;

public class HomePageSteps {
	private WebDriver driver;
	private HomePage homePage;

	@Given("I am on the Bookswagon home page")
	public void navigateToHomePage() {
		// Use WebDriverManager to handle driver setup
		String browser = System.getProperty("browser", "chrome"); // Default to Chrome
	     driver = BrowserFactory.getDriver(browser);
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com");

		// Initialize the HomePage object
		homePage = new HomePage(driver);
		System.out.println("Navigated to the Bookswagon homepage");
	}

	@When("I look for the search bar")
	public void i_look_for_the_search_bar() {
		// Check if the search bar element is present
		boolean isSearchBarDisplayed = homePage.getSearchBar().isDisplayed();
		Assert.assertTrue(isSearchBarDisplayed, "Search bar is not displayed on the homepage!");
		System.out.println("Search bar is present on the homepage");
	}

	@Then("the search bar should be visible")
	public void the_search_bar_should_be_visible() {
		// Final validation for search bar visibility
		Assert.assertTrue(homePage.getSearchBar().isDisplayed(), "Search bar visibility check failed!");
		System.out.println("Search bar is visible");
		homePage.takeScreenshot();

	}
	    @After
	    public void teardown() {
	    	if(driver!=null) {
	    		driver.quit();
	    	}
	    }

}
