package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FiltersPage {
	private WebDriver driver;

	// Locators for filters

	// Constructor
	public FiltersPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Clicks on the price filter based on the provided range.
	 *
	 * @param priceRange The range to filter (e.g., "Rs.500 - Rs.1000")
	 */
	public void clickPriceFilter(String priceRange) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> priceFilters = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//*[@id='site-wrapper']/div[1]/div[1]/div[2]/div[1]/ul/li/a")));

		for (WebElement filter : priceFilters) {
			String filterText = filter.getText();
			if (filterText.contains(priceRange)) {
				System.out.println("Clicking on filter: " + filterText);
				filter.click();
				break;
			}
		}
	}
	/**
	 * Clicks on the discount filter based on the provided range.
	 *
	 * @param discountRange The range to filter (e.g., "31% - 40%")
	 */
	public void clickDiscountFilter(String discountRange) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    try {
		        List<WebElement> discountFilters = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		                By.xpath("//*[@id='site-wrapper']/div[1]/div[1]/div[2]/div[1]/ul/li/a")));

		        for (WebElement filter : discountFilters) {
		            if (filter.getText().contains(discountRange)) {
		                System.out.println("Clicking on Discount filter: " + discountRange);
		                filter.click();
		                wait.until(ExpectedConditions.urlContains("filter?sid=")); // Ensure URL is updated
		                break;
		            }
		        }
		    } catch (Exception e) {
		        System.err.println("Error while clicking on Discount filter: " + e.getMessage());
		    }
	}

	/**
	 * Clicks on the language filter and validates the URL update.
	 *
	 * @param language The language to filter by (e.g., "English")
	 */
	public void clickLanguageFilter(String language) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        // Locate all language filter options
	        List<WebElement> languageFilters = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.xpath("//*[@id='site-wrapper']/div[1]/div[1]/div[2]/div[1]/ul/li/a")));
	      

	        for (WebElement filter : languageFilters) {
	            if (filter.getText().contains(language)) {
	                System.out.println("Clicking on Language filter: " + language);
	                // Click the desired language filter
	                filter.click();
	                break;
	            }
	        }
	    } catch (Exception e) {
	        System.err.println("Error while clicking on Language filter: " + e.getMessage());
	    }
	}

	/**
	 * Validates if search results are displayed after applying filters.
	 *
	 * @return true if results are displayed, false otherwise.
	 */
	public boolean validateSearchResults() {
		String resultsCount = driver.findElement(By.xpath("//*[@id=\"site-wrapper\"]/div[1]/div[2]/div[1]/div[1]/div"))
				.getText();
		System.out.println(resultsCount);
		return true;
	}
	public void takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
	    File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	    File destFile = new File("C:\\Users\\anjal\\Java_Projects\\BookswagonAutomation\\Screenshots\\FilterPage.png");
	    try {
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println("Screenshot captured at: " + destFile.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
}
