package pageObjects.xaltsocnportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BaseActions;

public class SignInPage extends BaseActions {
    WebDriver driver;

    //locators
    @FindBy(css = "main div:last-child div:nth-child(2) input")
    public WebElement email;

    @FindBy(css = "main div:last-child div:nth-child(4) input")
    public WebElement password;

    @FindBy(css = "main div:last-child button:nth-child(6)")
    public WebElement signInButton;

    @FindBy(css = "main div:last-child button:nth-child(8)")
    WebElement signUpButton;


    //constructor
    public SignInPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String emailId){
        sendKeys(email, emailId);
    }
    public void enterPass(String pass){
        sendKeys(password, pass);
    }
    public void clickSignIn(){
        click(signInButton);
    }
}
