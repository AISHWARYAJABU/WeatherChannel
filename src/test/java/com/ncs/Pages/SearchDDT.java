package com.ncs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchDDT {
	private WebDriver driver;
	public static final String BaseURL = "https://weather.com/";
 
	@FindBy(xpath = "//input[@class='SearchInput--InputField--1UoCv Search--inputClass--1FEhl']")
	private WebElement searchCityInput;

   @FindBy(css = "#LocationSearch_listbox-b72e8333c8558f6c914080a4a55a730f4744fd5c540d76d48c49a0e3f204c145")
	private WebElement searchButton;

	public SearchDDT(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getweatherlink() {
		driver.navigate().to(BaseURL);
	}

	public void searchForCity(String searchCity) throws InterruptedException {
		
		try {
	        searchCityInput.sendKeys(searchCity);
	        Thread.sleep(2000);
	        searchCityInput.sendKeys(Keys.ARROW_DOWN);
	        Thread.sleep(3000);
	        searchCityInput.sendKeys(Keys.ENTER);
	        Thread.sleep(3000);
	    } catch (StaleElementReferenceException e) {
	        // Element is stale, re-locate the element
	        searchCityInput = driver.findElement(By.xpath("//input[@class='SearchInput--InputField--1UoCv Search--inputClass--1FEhl']"));
	        // Retry the action
	        searchCityInput.sendKeys(searchCity);
	        Thread.sleep(2000);
	        searchCityInput.sendKeys(Keys.ARROW_DOWN);
	        Thread.sleep(3000);
	        searchCityInput.sendKeys(Keys.ENTER);
	        Thread.sleep(3000);
	    }
		
	
	}
	
	public String getCityName() {
		  WebElement cityNameElement = driver.findElement(By.xpath("//h1[@class='CurrentConditions--location--1YWj_']"));
	        return cityNameElement.getText();
    }

}
