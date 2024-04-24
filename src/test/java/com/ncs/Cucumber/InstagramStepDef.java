package com.ncs.Cucumber;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class InstagramStepDef {
	WebDriver driver;
	
	@FindBy(css = "#WxuFooter-footer-5b5ebc4f-6cb5-4bcf-8c09-60524c9ff62d > div > div > div.Footer--socialLogos--qYCPZ > div.Footer--socialContainer--3z8CW > ul > li:nth-child(3) > a")
	private WebElement instagramIcon;
	
	@FindBy(xpath = "//div/div/div[3]/ul/li/a")
	private WebElement dataRightsLink;
	
	public InstagramStepDef() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }
	
	@Given("User navigates to the weather.com site")
	public void navigateToWebsite() {
		driver.get("https://weather.com/");
	}
	
	@When("User clicks on the Instagram icon")
	public void clickOnInstagramIcon() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(instagramIcon));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dataRightsLink);
		Thread.sleep(1000);
		
		instagramIcon.click();
		Thread.sleep(3000);
		
		assertTrue(instagramIcon.isEnabled());
	}
	
	@Then("User should be redirected to the Instagram page")
	public void instagramLoginPage() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		
		assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/weatherchannel/"));
		
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	
}
