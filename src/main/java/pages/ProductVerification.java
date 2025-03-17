package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ProductVerification {
    private WebDriver driver;
    private WebDriverWait wait;
    

    // Locators
    private By searchbar = By.id("inputbar"); 
    private By serachIcon = By.id("btnTopSearch");
    private By product = By.xpath("//*[@id=\"listSearchResult\"]/div[1]/div[3]/div[1]/a");
    private By productTitle = By.id("ctl00_phBody_ProductDetail_lblTitle"); 
    private By productDescription = By.xpath("//*[@id=\"bookdetail\"]"); 
    private By productPrice = By.id("ctl00_phBody_ProductDetail_lblourPrice"); 
    private By productAvailability = By.id("ctl00_phBody_ProductDetail_lblAvailable"); 
    private By addToWishlistButton = By.xpath("//*[@id=\"bordercornerbox\"]/div/a"); 
    private By loginEmailField = By.id("ctl00_phBody_SignIn_txtEmail"); 
    private By loginPasswordField = By.id("ctl00_phBody_SignIn_txtPassword"); 
    private By loginButton = By.id("ctl00_phBody_SignIn_btnLogin"); 
    private By wishlistIcon = By.xpath("//*[@id=\"aspnetForm\"]/nav/div/div/div[2]");

    // Constructor
    public ProductVerification(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void getToRequirement(String s) {
    	WebElement input = driver.findElement(searchbar);
    	input.sendKeys(s);
    	WebElement submit = driver.findElement(serachIcon);
    	submit.click();
    	
    }
    public String getProductTitle() {
        WebElement found = driver.findElement(product);
        found.click();
    	WebElement prodT = driver.findElement(productTitle);
    	String ans = prodT.getText();
    	return ans;
        
    }

    public String getProductDescription() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productDescription)).getText();
    }

    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
    }

    public String getProductAvailability() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productAvailability)).getText();
    }

    public void clickAddToWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButton)).click();
    }
    public void clickWishlistIcon() {
    	WebElement icon = driver.findElement(wishlistIcon);
    	icon.click();
    }

    public void loginWithCredentials(String email, String password) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmailField));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPasswordField));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
    }
    public String getWishlistTitle() {
    	WebElement wTitle = driver.findElement(By.xpath("//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[2]/div/div[3]/ul/li/div/div[2]/div[1]/p/span/strong/a"));
    	return wTitle.getText();
    }
    public void takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
	    File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	    File destFile = new File("C:\\Users\\anjal\\Java_Projects\\BookswagonAutomation\\Screenshots\\ProductVerification.png");
	    try {
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println("Screenshot captured at: " + destFile.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
