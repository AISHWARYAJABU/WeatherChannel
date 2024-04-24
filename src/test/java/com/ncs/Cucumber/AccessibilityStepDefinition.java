package com.ncs.Cucumber;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class AccessibilityStepDefinition {
	
	private WebDriver driver;
	
	@Given("User is on the weather.com homepage")
	public void user_is_on_the_weather_com_homepage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.weather.com/");
	}	
	
	
	@When("User checks the accessibility of the page")
	public void user_checks_the_accessibility_of_the_page() throws InterruptedException {
		// Wait for element to be clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement accessibilityLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accessibility Statement")));
		
		// Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accessibilityLink);
	   
	    // Click the element using Actions class to adjust the click position
	    Actions actions = new Actions(driver);
	    actions.moveToElement(accessibilityLink).click().perform();
	   
	    Thread.sleep(10000);
	}
	@Then("Accessibility tests should pass")
	public void accessibility_tests_should_pass() throws InterruptedException {
		
		// Wait for the Accessibility page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.titleContains("Accessibility Statement"));
        WebElement accessibilityLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accessibility Statement")));
        Thread.sleep(2000);
        // Re-locate the element to avoid StaleElementReferenceException
        accessibilityLink = driver.findElement(By.linkText("Accessibility Statement"));
        // Verify that the Accessibility page is displayed
        assertTrue(driver.getTitle().contains("Accessibility Statement"));
        Thread.sleep(2000);
	}
	
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
