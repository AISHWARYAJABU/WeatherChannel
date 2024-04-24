package com.ncs.Pages;

import static org.testng.Assert.assertEquals;
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

public class MoreForecasts extends Base {

	@FindBy(xpath = "//div[@id=\"WxuLocalsuiteNav-header-71dadf79-621d-43ff-9a1a-d99a39f16abe\"]/div/nav/div/div[2]/button/span[1]")
	private WebElement moreForecastsBtn;

	@FindBy(xpath = "//div/nav/div/div[2]/nav/div/div/nav/h3[text()=\"Special Forecasts\"]")
	public WebElement dropDownTitle;

	@FindBy(xpath = "//div[@id='WxuLocalsuiteNav-header-71dadf79-621d-43ff-9a1a-d99a39f16abe']/div/nav/div/div[2]/nav/div/div/nav/div/a[1]/span")
	private WebElement allergyTracker;

	@FindBy(css = "#WxuPollenBreakdown-main-c1dadebb-ed45-4199-a7ab-4a3ca6163a2c > section > div > div > div:nth-child(3)")
	private WebElement allergentItem;

	@FindBy(xpath = "//div[@id='WxuAirQuality-main-7de6dc7e-8c44-46e2-bc70-fc9b603bb596']/div/section[2]/div/div/div[6]")
	private WebElement pollutantListItem;

	@FindBy(css = "#WxuPollenBreakdown-main-c1dadebb-ed45-4199-a7ab-4a3ca6163a2c > section > footer > button")
	private WebElement pollenBreakdownInfo;

	@FindBy(xpath = "//div[@id=\"WxuLocalsuiteNav-header-71dadf79-621d-43ff-9a1a-d99a39f16abe\"]/div/nav/div/div[2]/nav/div/div/nav/div/a[2]/span")
	private WebElement airQuality;

	@FindBy(css = "#allPollutantsFooter > button")
	private WebElement pollutantBreakdownInfo;

	public MoreForecasts(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Click on the More Forecasts button to open the drop down menu
	public void clickMoreForecasts() throws InterruptedException {
		moreForecastsBtn.click();
		Thread.sleep(3000);

//		String getDropDownTitle = dropDownTitle.getText();
		System.out.println("check this "+dropDownTitle.getText().length());
		assertEquals(dropDownTitle.getText(),"SPECIAL FORECASTS");
	}

	// Click on Allergy Tracker link text
	public void openAllergyTracker() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(allergyTracker));

		allergyTracker.click();
		Thread.sleep(1000);

		// Assert if the url for the allergy tracker is correct
		String fetchedURL = driver.getCurrentUrl();
		String actualURL = "https://weather.com/en-IN/forecast/allergy/l/d8957d01281fef701a5fa057bfd5da7f9674a11f991de86e8a482fd0c92480c8";
		assertEquals(fetchedURL, actualURL);

		// Scroll down till this element is visible
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allergentItem);
		Thread.sleep(2000);

		// Click on the info icon - Pollen Breakdown
		pollenBreakdownInfo.click();
		Thread.sleep(1000);

		pollenBreakdownInfo.click();
		Thread.sleep(2000);
	}

	// Click on the Air Quality Forecasts link text
	public void openAirQualityForecasts() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(airQuality));

		airQuality.click();
		Thread.sleep(1000);
		
		String fetchedURL = driver.getCurrentUrl();
		String actualURL = "https://weather.com/en-IN/forecast/air-quality/l/d8957d01281fef701a5fa057bfd5da7f9674a11f991de86e8a482fd0c92480c8";
		assertEquals(fetchedURL, actualURL);

		// Scroll down till this list item is visible
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pollutantListItem);
		Thread.sleep(2000);

		// Click on the info icon - Pollutant Breakdown
		pollutantBreakdownInfo.click();
		Thread.sleep(1000);

		pollutantBreakdownInfo.click();
		Thread.sleep(2000);
	}

}

