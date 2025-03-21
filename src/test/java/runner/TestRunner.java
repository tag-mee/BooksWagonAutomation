package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests; 
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/Allcombined",
glue = "stepdefinition",
plugin = { "pretty","json:target/cucumber-reports-json/Cucumber.json" }
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
} 
