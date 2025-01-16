package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObjects.xaltsocnportal.HomePage;
import pageObjects.xaltsocnportal.SignInPage;
import pageObjects.xaltsocnportal.SignUpPage;
import utils.BaseTest;

public class SignInSteps extends BaseTest {
    HomePage homePage = new HomePage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    @Given("the user is on the signIn page")
    public void the_user_is_on_the_sign_in_page() {
        driver.get("https://xaltsocnportal.web.app/");
        homePage.signInButton();
        signUpPage.clickSignIn();
    }
    @Then("the user clicks the signin button")
    public void the_user_clicks_the_signin_button() {
        signInPage.clickSignIn();
    }
    @Then("the signin button should be disabled")
    public void the_signin_button_should_be_disabled() {
        Boolean buttonEnabled = signInPage.signInButton.isEnabled();
        Assert.assertFalse(buttonEnabled);
    }

}
