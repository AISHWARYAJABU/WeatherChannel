package com.ncs.Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import com.ncs.CapstoneProject_Weather.Base;
 
public class RegionTabPage extends Base{
	public RegionTabPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
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
			    dropElement.click();
 
			    // Move to selRegion and click
			    Actions actions = new Actions(driver);
			    actions.moveToElement(selRegion).click().perform();
 
			    // Scroll to regionName and click
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", regionName);
			    Thread.sleep(500);
			    WebElement regionNameElement = wait.until(ExpectedConditions.elementToBeClickable(regionName));
			    regionNameElement.click();
 
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
}