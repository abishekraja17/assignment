package pageObjects.xaltsocnportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BaseActions;

import java.util.List;

public class SignUpPage extends BaseActions {
    WebDriver driver;

    //Locators
    @FindBy(css = "main div:last-child div input")
    public WebElement email;

    @FindBy(css = "main div:last-child div:nth-child(4) input")
    public WebElement password;

    @FindBy(css = "main div:last-child div:nth-child(6) input")
    public WebElement confirmPassword;

    @FindBy(css = "main div:last-child button.css-1hw9j7s")
    public WebElement signUpButton;

    @FindBy(css="main div:last-child button.css-1ujsas3")
    public WebElement signInButton;

    @FindBy(css="main div:nth-child(2) div:nth-child(4) p")
    public WebElement passError;


    @FindBy(css="main div:nth-child(2) label")
    public WebElement labelEmail;

    @FindBy(css="main div:nth-child(6) p")
    public WebElement confirmPassError;

//    @FindBy(css="main button:last-child")
//    public WebElement signInButton;

    //constructor
    public SignUpPage(WebDriver driver){
    super(driver);
    this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //methods
    public void enterEmail(String emailId){
        sendKeys(email, emailId);
    }
    public void enterPass(String pass){
        sendKeys(password, pass);
    }
    public void enterConfirmPass(String confirmPass){
        sendKeys(confirmPassword, confirmPass);
    }
    public void clickSignUp(){
        click(signUpButton);
    }
    public void clickSignIn(){
        click(signInButton);
    }

}
