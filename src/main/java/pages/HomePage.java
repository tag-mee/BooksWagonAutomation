package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    // Locator for the search bar
    private By searchBar = By.xpath("//*[@id=\"inputbar\"]"); // Ensure this locator matches the actual search bar ID

    // Constructor
    public HomePage(WebDriver driver) { 
        this.driver = driver;
    }

    // Method to retrieve the search bar WebElement
    public WebElement getSearchBar() {
        return driver.findElement(searchBar);
    }
    public void takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
	    File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	    File destFile = new File("C:\\Users\\anjal\\Java_Projects\\BookswagonAutomation\\Screenshots\\HomePage.png");
	    try {
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println("Screenshot captured at: " + destFile.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
