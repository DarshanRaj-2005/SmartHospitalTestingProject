@bala
Feature: Balamurugan S 15-04-2026 View the Pharmacy Bill page

  Background:
    Given the user is on the login page
    When the user clicks Super Admin button
    And the user clicks the Sign in button
    Then the user should be redirected to super admin dashboard

  @billpage
  Scenario: Verify whether the Pharmacy Bill page displays successfully
    When the user clicks the Pharmacy
    Then it should move to the Pharmacy Bill page successfully

  @searchname
  Scenario Outline: Verify patient search functionality
    Given the user is on the Pharmacy bill page
    When the user searches for patient "<patientName>"
    Then the system should display result as "<result>"

    Examples:
      | patientName | result    |
      | Ashok       | present   |
      | praveen raj | not found |

  @exportbill
  Scenario: Verify user can export pharmacy bill list as CSV
    When the user clicks the CSV button on the pharmacy bill page
    Then the CSV file should be downloaded successfully
