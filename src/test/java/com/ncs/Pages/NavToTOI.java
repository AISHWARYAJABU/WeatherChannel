package com.ncs.Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ncs.CapstoneProject_Weather.Base;

public class NavToTOI extends Base{
	
	@FindBy(xpath = "//div[@id=\"WxuHeaderLargeScreen-header-9944ec87-e4d4-4f18-b23e-ce4a3fd8a3ba\"]/header/div/div[1]/a[4]")
	private WebElement toiBtn;
	
	@FindBy(xpath = "//div[3]/div[3]/a[2]/span")
	private WebElement toiPageElement;

	public NavToTOI(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void switchToTOI() throws InterruptedException {
		
		toiBtn.click();
		Thread.sleep(4000);
		
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(toiPageElement));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toiPageElement);
		Thread.sleep(1000);

		
		
	}
	
}

