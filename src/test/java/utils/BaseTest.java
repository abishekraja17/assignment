package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;

public class BaseTest {
    public static WebDriver driver;

    public static WebDriver getDriver() throws IOException {
        String browser = ConfigReader.getProperty("browser");
        if(driver == null){
            if(browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            }
            else if(browser.equalsIgnoreCase("edge")){
                EdgeOptions options = new EdgeOptions();
                options.addArguments("inprivate");
                options.addArguments("start-maximized");
                driver = new EdgeDriver(options);
            }
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver!= null){
            driver.quit();
            driver = null;
        }
    }
    public String getTestURL() throws IOException {
        return ConfigReader.getProperty("testurl");
    }
}
