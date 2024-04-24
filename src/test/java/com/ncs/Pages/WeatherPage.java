package com.ncs.Pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
 
public class WeatherPage {
	// Declares a variable named driver to handle WebDriver operations.
		private WebDriver driver;
		// Base Url
		public static final String BaseURL = "https://weather.com/";
		// Constructor 
		public WeatherPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
		public void getweatherlink() {
			driver.navigate().to(BaseURL);
		}
	 
		// Locators and method for "Solapur" input
		@FindBy(xpath = "//input[@class='SearchInput--InputField--1UoCv Search--inputClass--1FEhl']")
		private WebElement SearchCity;
		@FindBy(css = "#LocationSearch_listbox-b72e8333c8558f6c914080a4a55a730f4744fd5c540d76d48c49a0e3f204c145")
		private WebElement Searchbtn;
	 
		public void searchForCity(String searchCity) throws InterruptedException {
//			// "Solapur" city passed 
//			SearchCity.sendKeys(searchCity);
//			Thread.sleep(2000); 
//			// Select the "Solapur" city
//			Searchbtn.click();
//			Thread.sleep(2000);
			SearchCity.sendKeys(searchCity);
			Thread.sleep(2000);
			SearchCity.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			SearchCity.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}
	 
//		@FindBy(xpath = "//input[@class='SearchInput--InputField--1UoCv Search--inputClass--1FEhl']")
//		private WebElement SearchCityclr;
	 
//		@FindBy(xpath = "//input[@id='LocationSearch_input']")
//		private WebElement searchInput;
	 
		// Locators and method for "XYZ123" wrong input
		@FindBy(id = "LocationSearch_input")
		private WebElement SearchCitybtn;
		@FindBy(xpath = "//input[@class='SearchInput--InputField--1UoCv Search--inputClass--1FEhl']")
		private WebElement SearchCity2;
		@FindBy(id = "id=LocationSearch_listbox-a496cfcba367ffae60ccfdc94e31bcf3d0a12ac6515336dbd274f381a932abbc")
		private WebElement Searchbtn2;
	 
		public void searchForCityWithSpecialChar(String searchCity2) throws InterruptedException {
			// Button click for searching city name
			SearchCitybtn.click();
			//"XYZ123" city passed
			SearchCity2.sendKeys(searchCity2);
			Thread.sleep(2000);
			// Click on city name
			Searchbtn2.click();
			Thread.sleep(2000);
		}
	 
		@FindBy(xpath = "//input[@class='SearchInput--InputField--1UoCv Search--inputClass--1FEhl']")
		private WebElement SearchCity3;
	 
		
	 
//		public void clearSearch() {
//			SearchCityclr.click();
//			searchInput.clear();
//		}
	 
		// Assert for Solapur
		@FindBy(xpath = "//h1[@class='CurrentConditions--location--1YWj_']")
		private WebElement cityNameElement;
	 
		public String getCityName() {
			return cityNameElement.getText();
		}
	 
		// Assert for NeW_yORk
		@FindBy(xpath = "//h1[contains(@class, 'CurrentConditions--location--1YWj_')]")
		private WebElement cityNameElement2;
	 
		public String getCityName2() {
			return cityNameElement2.getText();
		}
	 
		// For invalid Inputs
		@FindBy(xpath = "//div[@class='SearchedLocations--NoResults--J1dSn']")
		private WebElement noResultsMessage;
	 
		public void searchForCityWithInvalidInput(String searchCity3) throws InterruptedException {
			SearchCitybtn.click();
			SearchCity2.sendKeys(searchCity3);
			Thread.sleep(3000);
		}
	 
		public boolean isCityNameDisplayed(String searchCity32) {
			return !noResultsMessage.isDisplayed();
		}
	 
		// Today
		@FindBy(xpath = "//div/nav/div/div[1]/a[1]/span")
		private WebElement todayTab;
		@FindBy(xpath = "//h2[text()='Today\\'s Weather']")
		private WebElement weatherDetails;
	 
		public void clickTodayTab() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(todayTab));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", todayTab);
			Thread.sleep(500);
			todayTab.click();
			Thread.sleep(500);
	 
			// Verify that the Weekend tab is selected
			Assert.assertFalse(isTodayTabSelected(), "Today tab is not selected");
	 
		}
	 
		public boolean isTodayTabSelected() {
			return todayTab.getAttribute("class").contains("Selected");
		}
	 
		// Hourly Tab
		@FindBy(linkText = "Hourly")
		private WebElement hourTab;
		@FindBy(xpath = "//details[@id='detailIndex7']/summary/div/div/div/span")
		private WebElement downArrowHr;
		@FindBy(xpath = "//details[@id='detailIndex7']/summary/div/div/div/span")
		private WebElement upArrowHr;
	 
		public void clickHourlyTab() throws InterruptedException {
	 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(hourTab));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hourTab);
			Thread.sleep(500);
			hourTab.click();
			Thread.sleep(500);
	 
			wait.until(ExpectedConditions.elementToBeClickable(downArrowHr));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downArrowHr);
			Thread.sleep(500);
			downArrowHr.click();
			Thread.sleep(5000);
			upArrowHr.click();
			Thread.sleep(5000);
			// Verify that the Weekend tab is selected
			Assert.assertFalse(isHourlyTabSelected(), "Hourly tab is not selected");
		}
	 
		public boolean isHourlyTabSelected() {
			return hourTab.getAttribute("class").contains("Selected");
		}
	 
		// 10 Day Tab
		@FindBy(linkText = "10 Day")
		private WebElement tenDayTab;
		@FindBy(xpath = "//details[@id='detailIndex8']/summary")
		private WebElement downArrowDay;
		@FindBy(xpath = "//details[@id='detailIndex8']/summary")
		private WebElement upArrowDay;
	 
		public void click10DayTab() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(tenDayTab));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenDayTab);
			Thread.sleep(3000);
			tenDayTab.click();
			Thread.sleep(3000);
	 
			wait.until(ExpectedConditions.elementToBeClickable(downArrowDay));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downArrowDay);
			Thread.sleep(2000);
			downArrowDay.click();
			Thread.sleep(5000);
			upArrowDay.click();
			Thread.sleep(5000);
	 
			// Verify that the Weekend tab is selected
			Assert.assertFalse(is10DayTabSelected(), "10 Day tab is not selected");
	 
		}
	 
		public boolean is10DayTabSelected() {
			return tenDayTab.getAttribute("class").contains("Selected");
		}
	 
		// Weekend Weather Tab
		@FindBy(xpath = "//a[4]/span")
		private WebElement weekendTab;
		@FindBy(xpath = "//details[2]/summary/div/div/div/span")
		private WebElement downArrowweekend;
		// @FindBy(xpath = "//summary/div/div/div/span")
		// private WebElement upArrowweekend;
	 
		public void clickWeekendTab() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(weekendTab));
	 
			// Scroll to the weekendTab
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", weekendTab);
			Thread.sleep(500);
	 
			// Click the weekendTab
			try {
				weekendTab.click();
			} catch (ElementClickInterceptedException e) {
				// Retry clicking using Actions class with an offset
				Actions actions = new Actions(driver);
				actions.moveToElement(weekendTab, 5, 5).click().perform();
			}
	 
			// Wait for downArrowweekend to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(downArrowweekend));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downArrowweekend);
			Thread.sleep(2000);
			downArrowweekend.click();
			Thread.sleep(5000);
	 
			// Verify that the Weekend tab is selected
			Assert.assertFalse(isWeekendTabSelected(), "Weekend tab is not selected");
		}
	 
		public boolean isWeekendTabSelected() {
			return weekendTab.getAttribute("class").contains("Selected");
		}
	 
		// Monthly Tab
		@FindBy(xpath = "//a[5]/span")
		private WebElement monthTab;
		@FindBy(xpath = "//span[contains(.,'Mar')]")
		private WebElement previousMonth;
		@FindBy(xpath = "//button[11]")
		private WebElement monthDate;
	 
		public void clickMonthlyTab() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(monthTab));
			Thread.sleep(3000);
	 
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", monthTab);
			Thread.sleep(2000);
	 
			monthTab.click();
			Thread.sleep(3000);
	 
			wait.until(ExpectedConditions.elementToBeClickable(previousMonth));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", previousMonth);
			Thread.sleep(2000);
	 
			previousMonth.click();
			Thread.sleep(5000);
	 
			monthDate.click();
			Thread.sleep(5000);
	 
			// Verify that the Weekend tab is selected
			Assert.assertFalse(isMonthlyTabSelected(), "Monthly tab is not selected");
		}
	 
		public boolean isMonthlyTabSelected() {
			return monthTab.getAttribute("class").contains("Selected");
		}
	 
		// Region Selection
		@FindBy(xpath = "//*[@id=\"WxuHeaderLargeScreen-header-9944ec87-e4d4-4f18-b23e-ce4a3fd8a3ba\"]/header/div/div[2]/div[2]")
		private WebElement selDrop;
		@FindBy(xpath = "//*[@id=\"WxuHeaderLargeScreen-header-9944ec87-e4d4-4f18-b23e-ce4a3fd8a3ba\"]/header/div/div[2]/div[2]/nav/div/div/div/details[3]/summary/div")
		private WebElement selRegion;
		@FindBy(xpath = "//*[@id=\"WxuHeaderLargeScreen-header-9944ec87-e4d4-4f18-b23e-ce4a3fd8a3ba\"]/header/div/div[2]/div[2]/nav/div/div/div/details[3]/div/div/a[8]")
		private WebElement regionName;
	 
		public void selectRegion() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 
			// Click on selDrop
			WebElement dropElement = wait.until(ExpectedConditions.elementToBeClickable(selDrop));
			// dropElement.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", selDrop);
	 
			// Move to selRegion and click
			Actions actions = new Actions(driver);
			actions.moveToElement(selRegion).click().perform();
	 
			// Scroll to regionName and click
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", regionName);
			Thread.sleep(500);
			WebElement regionNameElement = wait.until(ExpectedConditions.elementToBeClickable(regionName));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", regionName);
	 
			Thread.sleep(2000);
		}
	 
		// Unit Selection
		@FindBy(xpath = "//*[@id=\"WxuHeaderLargeScreen-header-9944ec87-e4d4-4f18-b23e-ce4a3fd8a3ba\"]/header/div/div[2]/div[2]")
		private WebElement selDrop1;
		@FindBy(xpath = "//li[contains(.,'°F')]")
		private WebElement selUnit1;
	 
		public void selectUnit() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(selDrop1));
			selDrop1.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(selUnit1));
			selUnit1.click();
			Thread.sleep(2000);
	 
		}
	 
		// Radar Tab
		@FindBy(linkText = "Radar")
		private WebElement radarTab;
		@FindBy(xpath = "//button[@class='Button--default--2gfm1 Button--iconOnly--1oVrZ Radar--actionIconContainer--15s_W Radar--zoomPlusIconContainer--1WQ-3']")
		private WebElement zoomIn;
		@FindBy(xpath = "//button[@class='Button--default--2gfm1 Button--iconOnly--1oVrZ Radar--actionIconContainer--15s_W Radar--zoomMinusIconContainer--3iRC6']")
		private WebElement zoomOut;
		@FindBy(xpath = "//*[@id=\"WXU-RADAR-CONTAINER\"]/div/div[3]/div/section[2]/div[2]/div[1]/div[2]/button/div/div[1]/div/div/div/img")
		private WebElement cloudTab;
	 
		public void selectRadar() throws InterruptedException {
	 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(radarTab));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", radarTab);
	 
			Thread.sleep(2000);
	 
			wait.until(ExpectedConditions.elementToBeClickable(zoomIn));
			zoomIn.click();
			Thread.sleep(2000);
	 
			wait.until(ExpectedConditions.elementToBeClickable(zoomOut));
			zoomOut.click();
			Thread.sleep(2000);
	 
			wait.until(ExpectedConditions.elementToBeClickable(cloudTab));
			cloudTab.click();
			Thread.sleep(2000);
	 
		}
	 
		public boolean isRadarTabSelected() {
			String tabClass = radarTab.getAttribute("class");
			System.out.println("Class name of Radar tab: " + tabClass);
			return tabClass.contains("selected");
		}
	 
		// AllergyTracker Tab
		@FindBy(xpath = "//span[@class='styles--fullText--jVRPZ']")
		private WebElement forecastTab;
		@FindBy(xpath = "//*[@id=\"WxuLocalsuiteNav-header-71dadf79-621d-43ff-9a1a-d99a39f16abe\"]/div/nav/div/div[2]/nav/div/div/nav/div/a[1]/span")
		private WebElement allergyTrackerTab;
		@FindBy(xpath = "//*[@id=\"WxuPollenBreakdown-main-c1dadebb-ed45-4199-a7ab-4a3ca6163a2c\"]/section/footer/button/span")
		private WebElement aboutTab;
	 
		public void selectAllergyTracker() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(forecastTab));
	 
			forecastTab.click();
			Thread.sleep(5000);
	 
			wait.until(ExpectedConditions.elementToBeClickable(allergyTrackerTab));
			allergyTrackerTab.click();
			Thread.sleep(2000);
	 
			// Scroll to regionName and click
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutTab);
	 
			Thread.sleep(2000);
	 
			wait.until(ExpectedConditions.elementToBeClickable(aboutTab));
			aboutTab.click();
			Thread.sleep(2000);
	 
		}
	 
		public By clickedForecast() {
			return By.linkText("More Forecasts");
		}
	 
		// AirQualityForecast
		// @FindBy(xpath = "//span[@class='styles--fullText--jVRPZ']")
		// private WebElement forecastTab;
		@FindBy(xpath = "//*[@id=\"WxuLocalsuiteNav-header-71dadf79-621d-43ff-9a1a-d99a39f16abe\"]/div/nav/div/div[2]/nav/div/div/nav/div/a[2]/span")
		private WebElement AirQualityTab;
		@FindBy(xpath = "//*[@id=\"allPollutantsFooter\"]/button/span")
		private WebElement aboutTab1;
	 
		public void selectAirQualityForecast() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(forecastTab));
	 
			forecastTab.click();
			Thread.sleep(5000);
	 
			wait.until(ExpectedConditions.elementToBeClickable(AirQualityTab));
			AirQualityTab.click();
			Thread.sleep(2000);
	 
			// Scroll to regionName and click
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutTab1);
	 
			Thread.sleep(2000);
	 
			wait.until(ExpectedConditions.elementToBeClickable(aboutTab1));
			aboutTab1.click();
			Thread.sleep(2000);
	 
		}
	 
		// Stay Safe Tab
		@FindBy(xpath = "//*[@id=\"WxuPromoDriver-sidebar-721f1a1a-460a-422c-a0db-db83a582b227\"]/section/div/section/div/div[1]/a/div/div/img")
		private WebElement staySafeTab;
		@FindBy(xpath = "//*[@id=\"WxuCollectionMediaList-main-9842d2c3-5955-4e5e-8ebd-8da9202069ef\"]/section/div[1]/div/ul/li[1]/a")
		private WebElement vidioTab;
		@FindBy(xpath = "//*[@id=\"WxuCollectionMediaList-main-9842d2c3-5955-4e5e-8ebd-8da9202069ef\"]/section/div[2]/a")
		private WebElement nextTab;
		@FindBy(xpath = "//*[@id=\"WxuCollectionMediaList-main-9842d2c3-5955-4e5e-8ebd-8da9202069ef\"]/section/div[2]/a[1]")
		private WebElement previousTab;
	 
		public void selectStaySafe() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(staySafeTab));
	 
			// Scroll to and click
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", staySafeTab);
			Thread.sleep(2000);
			staySafeTab.click();
			Thread.sleep(3000);
	 
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vidioTab);
			wait.until(ExpectedConditions.elementToBeClickable(vidioTab));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", vidioTab);
			Thread.sleep(3000);
	 
			driver.navigate().back();
	 
			Thread.sleep(3000);
	 
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextTab);
			wait.until(ExpectedConditions.elementToBeClickable(nextTab));
			nextTab.click();
			Thread.sleep(3000);
	 
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", previousTab);
			wait.until(ExpectedConditions.elementToBeClickable(previousTab));
			previousTab.click();
			Thread.sleep(3000);
	 
		}	
 
} 