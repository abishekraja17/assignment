package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseActions {
    WebDriver driver;

    public BaseActions(WebDriver driver){
        this.driver = driver;
    }
    public void click(WebElement element){
        try {
        waitForVisibility(element);
        element.click();
        }catch(Exception e){
            throw new RuntimeException("Failed to click on element"+element, e);
        }
    }
    public void waitForVisibility(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(Exception e){
            throw new RuntimeException("Element is not visible" + element, e);
        }
    }

    public void sendKeys(WebElement element, String value){
        try{
            element.clear();
            element.sendKeys(value);
        }catch(Exception e){
            throw new RuntimeException("Error while sending keys to the element"+ element, e);
        }
    }


}
