package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.BaseTest;

public class Hooks {
    WebDriver driver;
    @Before
    public void setup(){
        BaseTest.getDriver();
    }
    @After
    public void tearDown(){
        BaseTest.quitDriver();
    }
}
