package pageObjects.xaltsocnportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BaseActions;

public class HomePage extends BaseActions {
    WebDriver driver;

    @FindBy(css = "button.css-1ujsas3")
    public WebElement signInButton;

    @FindBy(css = "button.css-1hw9j7s")
    public WebElement getStartedButton;


    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void signInButton(){
        click(signInButton);
    }
    public void getStartedButton(){
        click(getStartedButton);
    }
}
