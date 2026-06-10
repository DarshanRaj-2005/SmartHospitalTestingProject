@bala
Feature: Balamurugan S 27/04/2026 Purchasing a Medicine

  Background:
    Given the user is on the login page
    When the user clicks Super Admin button
    And the user clicks the Sign in button
    Then the user should be redirected to super admin dashboard
    When the user clicks the Pharmacy
    And the user clicks the Medicines button
    Then the medicine stock page should be displayed

  @ValidPurchase
  Scenario: Verify user is able to purchase the medicine successfully using csv
    When the user clicks the Purchase Medicine button
    Then the Purchase Medicine page should be displayed
    When the user enters purchase medicine details from csv
    And the user clicks Purchase Save button
    Then the medicine purchase should be successful

  @InvalidPurchase
  Scenario: Verify validation when mandatory fields are empty during purchase
    When the user clicks the Purchase Medicine button
    Then the Purchase Medicine page should be displayed
    When the user clicks Purchase Save button without entering any details
    Then the required field validation messages should be displayed
    
  @exportPurchaseCSV
  Scenario: Verify user can export purchase list as CSV
    When the user clicks the Purchase Medicine button
    Then the Purchase Medicine page should be displayed
    When the user clicks the CSV button on the purchase page
    Then the CSV file should be downloaded successfully
