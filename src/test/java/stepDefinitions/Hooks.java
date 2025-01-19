package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.BaseTest;

import java.io.IOException;

public class Hooks {
    WebDriver driver;
    @Before
    public void setup() throws IOException {
        BaseTest.getDriver();
    }
    @After
    public void tearDown(){
        BaseTest.quitDriver();
    }
}
