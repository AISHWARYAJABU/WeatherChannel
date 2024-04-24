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

public class FeedbackPage extends Base {
    
    @FindBy(xpath = "//div[@id='WxuFooter-footer-5b5ebc4f-6cb5-4bcf-8c09-60524c9ff62d']/div/div/ul[1]")
    private WebElement footerArea;
    
    @FindBy(xpath = "//div[3]/div/div/ul/li/a[text()=\"Feedback\"]")
    private WebElement feedbackLink;
    
    @FindBy(css = "#tab-content-Web .email_us-button-label:nth-child(2)")
    private WebElement emailUsBtn;
    
    @FindBy(xpath = "//div[1]/div/section/div/footer/button[3]")
    private WebElement acceptCookies;

    public FeedbackPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void scrollToFooter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(feedbackLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", feedbackLink);
        Thread.sleep(1000);
    }
    
    public void goToFeedBack() throws InterruptedException {
        feedbackLink.click();
        
        Thread.sleep(5000);
    }
    
    public void feedbackInNewTab() throws InterruptedException {
        
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
                
        WebDriverWait waitPageLoad = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitPageLoad.until(ExpectedConditions.elementToBeClickable(acceptCookies));
        
        acceptCookies.click();
        Thread.sleep(2000);

    }
    

}