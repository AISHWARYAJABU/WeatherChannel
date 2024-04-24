package com.ncs.Cucumber;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class PrivacyPolicyStepDefinition {
	
	private WebDriver driver;
	
	@Given("User is on the weather.com Privacy Policy homepage")
	public void user_is_on_the_privacy_policy_page_on_weather_com() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.weather.com/");
	}
	@When("User clicks on the Privacy Policy link")
	public void user_clicks_on_the_privacy_policy_link() throws InterruptedException {
		// Click on the Privacy Policy link
        //WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		WebElement privacyPolicyLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Privacy Policy")));
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicyLink);
				
		Thread.sleep(5000);
	    // Click the element
		privacyPolicyLink.click();
		Thread.sleep(2000);
				
		// Re-locate the element to avoid StaleElementReferenceException
		privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
				
		 // Check if element is displayed
		 assertTrue(privacyPolicyLink.isDisplayed());
	}
	@Then("User should be on the Privacy Policy page")
	public void user_should_be_on_the_privacy_policy_page() {
		// Wait for the Privacy Policy page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.titleContains("Privacy Policy"));
        // Verify that the Privacy Policy page is displayed
        assertTrue(driver.getTitle().contains("Privacy Policy"));
	}
	
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
