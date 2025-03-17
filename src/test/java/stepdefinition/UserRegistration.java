package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserFactory;
import pages.UserRegistrationPage;

public class UserRegistration {
	private WebDriver driver;
	private UserRegistrationPage urp;

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		String browser = System.getProperty("browser", "chrome"); // Default to Chrome
		driver = BrowserFactory.getDriver(browser);
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com/login");
		urp = new UserRegistrationPage(driver);
	}

	@When("I enter {string} and {string} in the login form")
	public void i_enter_and_in_the_login_form(String username, String password) {
		WebElement usernameField = driver.findElement(By.id("ctl00_phBody_SignIn_txtEmail"));
		WebElement passwordField = driver.findElement(By.id("ctl00_phBody_SignIn_txtPassword"));

		usernameField.clear();
		usernameField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	@When("I click on the Login button")
	public void i_click_on_the_login_button() {
		WebElement loginButton = driver.findElement(By.id("ctl00_phBody_SignIn_btnLogin"));
		loginButton.click();
	}

	@Then("I should see a homepage address saying {string}")
	public void i_should_see_a_homepage_address_saying(String expectedHomePage) {
		String actualHomePage = driver.getCurrentUrl();
		if(actualHomePage.equals(expectedHomePage)) {
		System.out.println("Logged in successfully!!");
		urp.takeScreenshot("Profile");
		}else {
		System.out.println("Invalid Credentials");
		urp.takeScreenshot("InvalidCred");
		}
	}
	@After
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
