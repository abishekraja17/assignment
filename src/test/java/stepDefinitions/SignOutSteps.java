package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObjects.xaltsocnportal.HomePage;
import pageObjects.xaltsocnportal.SignInPage;
import pageObjects.xaltsocnportal.SignUpPage;
import utils.BaseTest;

import java.io.IOException;

public class SignOutSteps extends BaseTest {
    HomePage homePage = new HomePage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    @Given("the user is signedIn using the email {string} and password {string}")
    public void the_user_is_signed_in(String emailId, String password) throws IOException {
        driver.get(getTestURL());
        homePage.signInButton();
        signUpPage.clickSignIn();
        signInPage.enterEmail(emailId);
        signInPage.enterPass(password);
        signInPage.clickSignIn();
    }
    @When("the user clicks signout button")
    public void the_user_clicks_signout_button() {
        homePage.signInButton();
    }
    @Then("the user should be logged out and {string} button is visible in header")
    public void the_user_should_be_logged_out_and_button_is_visible_in_header(String expText) throws InterruptedException {
        Thread.sleep(4000);
        String buttonText= homePage.signInButton.getText();
        Assert.assertEquals(buttonText, expText);
    }
}
