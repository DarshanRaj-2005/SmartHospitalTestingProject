@bala
Feature: Balamurugan S 18-05-2026 Generate the Pharmacy Bill

  Background:
    Given the user is on the login page
    When the user clicks Super Admin button
    And the user clicks the Sign in button
    Then the user should be redirected to super admin dashboard
    When the user clicks the Pharmacy
    Then it should move to the Pharmacy Bill page successfully
    And user clicks Generate Bill button


  Scenario: Verify error when mandatory fields are missing
    And the user enters pharmacy bill details
      | category |  |
      | medicine |  |
    And user clicks the Save button
    Then the error message should be displayed
