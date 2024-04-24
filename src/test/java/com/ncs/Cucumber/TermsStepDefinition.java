package com.ncs.Cucumber;

import static org.testng.Assert.assertFalse;
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
import org.testng.annotations.BeforeClass;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.reactivex.rxjava3.functions.Action;
public class TermsStepDefinition {
	
	private WebDriver driver;
	@Given("I am on the weather.com homepage")
	public void i_am_on_the_weather_com_homepage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.weather.com/");
	}
	@Then("I should see the Terms of Use link")
	public void i_should_see_the_terms_of_use_link() throws InterruptedException {
		
		// Wait for element to be clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement termsOfUseLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Terms of Use")));
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsOfUseLink);
		
		Thread.sleep(2000);
		// Click the element
		termsOfUseLink.click();
		Thread.sleep(2000);
		
		// Re-locate the element to avoid StaleElementReferenceException
		termsOfUseLink = driver.findElement(By.linkText("Terms of Use"));
		
		// Check if element is displayed
        assertTrue(termsOfUseLink.isDisplayed());
	}
	@When("I click on the Terms of Use link")
	public void i_click_on_the_terms_of_use_link() throws InterruptedException {
		// Wait for element to be clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement termsOfUseLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Terms of Use")));
		// Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsOfUseLink);
		
	    // Click the element using Actions class to adjust the click position
	    Actions actions = new Actions(driver);
	    actions.moveToElement(termsOfUseLink).click().perform();
	   
	}
	@Then("I should be on the Terms of Use page")
	public void i_should_be_on_the_terms_of_use_page() throws InterruptedException {
		// Wait for the Terms of Use page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.titleContains("Terms of Use"));
        // Verify that the Privacy Policy page is displayed
        assertTrue(driver.getTitle().contains("Terms of Use"));
	}
	
//	@BeforeClass
//    public void init() {
//     i_am_on_the_weather_com_homepage();
//     driver.manage().window().maximize();
//	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
	
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
