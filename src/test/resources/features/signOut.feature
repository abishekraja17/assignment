@SignOut
Feature: User SignOut

  Background:
    Given the user is signedIn using the email "user6@example.com" and password "Password1!"

  Scenario: Successful signOut
    Then the user should be logged in and "SIGN OUT" button is visible in header
    When the user clicks signout button
    Then the user should be logged out and "SIGN IN" button is visible in header
