@SignIn
Feature: User SignIn

  Background:
    Given the user is on the signIn page

  Scenario: Unregistered email
    When the user enters an invalid email "user7@example.com"
    And the user enters a valid password "Password1!"
    Then the user clicks the signin button
    Then a popup should be displayed with the message "User not found"

  Scenario: Invalid email format
    When the user enters an invalid email "userexample.com"
    Then the "email" label color should be "rgba(211, 47, 47, 1)"
    When the user enters a valid password "Password1!"
    Then the signin button should be disabled

  Scenario: Empty email field
    When the user leaves the "email" field empty
    And the user enters a valid password "Password1!"
    Then the signin button should be disabled

  Scenario: Unregistered password
    When the user enters a valid email "user6@example.com"
    And the user enters an invalid password "Password1!!"
    And the user clicks the signin button
    Then a popup should be displayed with the message "Incorrect E-Mail or Password"

  Scenario: Invalid password format
    When the user enters a valid email "user6@example.com"
    And the user enters an invalid password "Password1"
    Then the "password" field shows error, "Password must contain atelast one lowercase letter, uppercase letter, number and special character and be a minimum of 8 characters in length"
    And the signin button should be disabled

  Scenario: Empty password field
    When the user enters a valid email "user6@example.com"
    And the user leaves the "password" field empty
    Then the signin button should be disabled


  Scenario: Successful signin
    When the user enters a valid email "user6@example.com"
    And the user enters a valid password "Password1!"
    And the user clicks the "signin" button
    Then the user should be logged in and "SIGN OUT" button is visible in header
