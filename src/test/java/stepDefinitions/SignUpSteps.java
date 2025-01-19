package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.xaltsocnportal.HomePage;
import pageObjects.xaltsocnportal.SignInPage;
import pageObjects.xaltsocnportal.SignUpPage;
import utils.BaseTest;

import java.io.IOException;
import java.time.Duration;

public class SignUpSteps extends BaseTest {
    HomePage homePage = new HomePage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    @Given("the user is on the signup page")
    public void the_user_is_on_the_signup_page() throws IOException {
        driver.get(getTestURL());
        homePage.signInButton();
    }
    @When("the user enters an invalid email {string}")
    public void the_user_enters_an_invalid_email(String emailId) {
        signUpPage.enterEmail(emailId);
    }
    @Then("the {string} label color should be {string}")
    public void the_email_label_color_should_be(String fieldName, String expColor) {
        if(fieldName.equalsIgnoreCase("email")) {
            String labelColor = signUpPage.labelEmail.getCssValue("color");
            Assert.assertEquals(labelColor, expColor);
        }

    }
    @Then("the signup button should be disabled")
    public void the_signup_button_should_be_disabled() {
        Boolean buttonEnabled = signUpPage.signUpButton.isEnabled();
        Assert.assertFalse(buttonEnabled);
    }
    @When("the user enters a valid email {string}")
    public void the_user_enters_a_valid_email(String emailId) {
        signUpPage.enterEmail(emailId);
    }
    @When("the user enters an invalid password {string}")
    public void the_user_enters_an_invalid_password(String password) {
        signUpPage.enterPass(password);
    }
    @Then("the {string} field shows error, {string}")
    public void the_field_shows_error(String fieldName, String expError) {
    if(fieldName.equalsIgnoreCase("password")){
        String error = signUpPage.passError.getText();
        Assert.assertEquals(error, expError);
    }
    else if(fieldName.equalsIgnoreCase("confirm password")){
        String error = signUpPage.confirmPassError.getText();
        Assert.assertEquals(error, expError);
        }
    }

    @When("the user enters a valid password {string}")
    public void the_user_enters_a_valid_password(String password) {
        signUpPage.enterPass(password);
    }
    @When("the user enters a different password in the confirm password field {string}")
    public void the_user_enters_a_different_password_in_the_confirm_password_field(String password) {
        signUpPage.enterConfirmPass(password);
    }

    @When("the user enters the same password in the confirm password field {string}")
    public void the_user_enters_the_same_password_in_the_confirm_password_field(String password) {
        signUpPage.enterConfirmPass(password);
    }
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_signup_button(String buttonName) {
        if(buttonName.equalsIgnoreCase("signUp")) {
            signUpPage.clickSignUp();
        }
        else if(buttonName.equalsIgnoreCase("signIn")){
            signInPage.clickSignIn();
        }
    }
    @Then("a popup should be displayed with the message {string}")
    public void a_popup_should_be_displayed_with_the_message(String expAlert) {
            // Switch to Alert
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, expAlert);
            alert.accept();
    }
    @When("the user leaves the {string} field empty")
    public void the_user_leaves_the_field_empty(String string) {
        // Code not needed
    }

    @Then("the user should be logged in and {string} button is visible in header")
    public void the_user_should_be_logged_in_and_button_is_visible_in_header(String signOut) throws InterruptedException {
        Thread.sleep(4000);
        String buttonText = homePage.signInButton.getText();
        Assert.assertEquals(buttonText, signOut);
    }


}
