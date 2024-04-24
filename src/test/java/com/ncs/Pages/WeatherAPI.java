package com.ncs.Pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ncs.CapstoneProject_Weather.Base;

public class WeatherAPI extends Base{
	
	@FindBy(xpath = "//div[@id='WxuFooter-footer-5b5ebc4f-6cb5-4bcf-8c09-60524c9ff62d']/div/div/ul[1]")
	private WebElement footerArea;
	
	@FindBy(css = ".Footer--corporateLinks--3FrYQ > li:nth-child(2) > .LinkList--Link--34-VU")
	private WebElement apiLinkText;
	
	public WeatherAPI(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void scrollToFooter() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(apiLinkText));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", apiLinkText);
		Thread.sleep(1000);
	}
	
	public void navToWeatherAPI() throws InterruptedException {
		
		apiLinkText.click();
		Thread.sleep(4000);
		
//		String data = apiLinkText.getText();
//		assertTrue(data.contains("Weather API"));
	}

}

