@SignUp
Feature: User Signup

Background:
Given the user is on the signup page

  Scenario: Invalid email format
    When the user enters an invalid email "userexample.com"
    Then the "email" label color should be "rgba(211, 47, 47, 1)"
    And the signup button should be disabled


  Scenario Outline: Weak password
    When the user enters a valid email "user@example.com"
    And the user enters an invalid password "<password>"
    Then the "password" field shows error, "Password must contain atelast one lowercase letter, uppercase letter, number and special character and be a minimum of 8 characters in length"
    And the signup button should be disabled

    Examples:
      | password   |
      | password1! |
      | PASSWORD1! |
      | Password!  |
      | Password1  |
      | Pass1!     |

  Scenario: Passwords do not match
    When the user enters a valid email "user@example.com"
    And the user enters a valid password "Password1!"
    And the user enters a different password in the confirm password field "Password2!"
    Then the "confirm password" field shows error, "Passwords do not match"
    And the signup button should be disabled

  Scenario: Email already in use
    When the user enters a valid email "user@example.com"
    And the user enters a valid password "Password1!"
    And the user enters the same password in the confirm password field "Password1!"
    And the user clicks the "signup" button
    Then a popup should be displayed with the message "Provided E-Mail is already in use"

  Scenario: Empty email field
    When the user leaves the "email" field empty
    And the user enters a valid password "Password1!"
    And the user enters the same password in the confirm password field "Password1!"
    Then the signup button should be disabled

  Scenario: Empty password field
    When the user enters a valid email "user@example.com"
    And the user leaves the "password" field empty
    And the user enters the same password in the confirm password field "Password1!"
    Then the "password" field shows error, "Password must contain atelast one lowercase letter, uppercase letter, number and special character and be a minimum of 8 characters in length"
    And the signup button should be disabled

  Scenario: Empty confirm password field
    When the user enters a valid email "user@example.com"
    And the user enters a valid password "Password1!"
    And the user leaves the "confirm password" field empty
    Then the signup button should be disabled

  Scenario: Successful signup
When the user enters a valid email "user8@example.com"
And the user enters a valid password "Password1!"
And the user enters the same password in the confirm password field "Password1!"
And the user clicks the "signup" button
Then the user should be logged in and "SIGN OUT" button is visible in header
