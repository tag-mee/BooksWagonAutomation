package pages;

import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CartAutomationPage {
	private WebDriver driver;

	// Constructor
	public CartAutomationPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Adds an item to the cart. 
	 * 
	 * @throws InterruptedException
	 */
	public void addItemToCart() throws InterruptedException {
		WebElement atc = driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[1]/div[4]/div[4]/input[1]"));
		WebElement atc2 = driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[2]/div[4]/div[5]/input[1]"));
		atc.click();
		atc2.click();
		//Thread.sleep(5000);
	}

	/**
	 * Opens the cart.
	 */
	public void openCart() {
		WebElement cartIcon = driver
				.findElement(By.xpath("//*[@id=\"aspnetForm\"]/header/div[2]/div/div[3]/ul/li[2]/a"));
		cartIcon.click();
		System.out.println("Clicked the cart icon");
	}

	/**
	 * Removes an item from the cart.
	 * @throws InterruptedException 
	 */
	public void removeItemFromCart() throws InterruptedException {
		
		WebElement remove = driver.findElement(By.xpath("//*[@id=\"ctl00_phBody_BookCart_lvCart_ctrl0_imgDelete\"]"));
		remove.click();
		System.out.println("Removed 1 item");
	}

	/**
	 * Updates the quantity of an item in the cart.
	 *
	 * @param quantity The desired quantity.
	 * @throws InterruptedException
	 */
	public void updateItemQuantity(String quantity) throws InterruptedException {
		WebElement update = driver.findElement(By.xpath("//*[@id=\"ctl00_phBody_BookCart_lvCart_ctrl0_btnPlus\"]"));
		int i = 3;
		while (i < 3) {
			update.click();
			i--;
		}
	}

	/**
	 * Proceeds to checkout.
	 * @throws InterruptedException 
	 */
	public void proceedToCheckout() throws InterruptedException {

		
		By checkoutLocator = By.xpath("//*[@id=\"ctl00_phBody_BookCart_lvCart_imgPayment\"]");
		WebElement checkout = driver.findElement(checkoutLocator);
		checkout.click();
	}

	public void LoginWithCred() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement un = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_phBody_SignIn_txtEmail\"]")));
			un.sendKeys("AdityaJha9665@gmail.com");

			WebElement pass = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_phBody_SignIn_txtPassword\"]")));
			pass.sendKeys("Aditya@9403");

			WebElement loginButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_phBody_SignIn_btnLogin\"]")));
			loginButton.click();
			System.out.println("Login successful");
		} catch (Exception e) {
			System.out.println("Error locating login elements: " + e.getMessage());
		}
	}

	public void takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\anjal\\Java_Projects\\BookswagonAutomation\\Screenshots\\loginPage.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot captured at: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
