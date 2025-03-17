package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationPage {
    private WebDriver driver;

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("ctl00_phBody_SignIn_txtEmail")); 
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("ctl00_phBody_SignIn_txtPassword")); 
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("ctl00_phBody_SignIn_btnLogin"));
    }
    public void takeScreenshot(String path) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
	    File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	    File destFile = new File("C:\\Users\\anjal\\Java_Projects\\BookswagonAutomation\\Screenshots\\"+path+".png");
	    try {
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println("Screenshot captured at: " + destFile.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
