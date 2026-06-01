Feature: Balamurugan S 17/05/2026 Add and manage medicines in the medicine stock page

  Background:
    Given the user is on the login page
    When the user clicks Super Admin button
    And the user clicks the Sign in button
    Then the user should be redirected to super admin dashboard
    When the user clicks the Pharmacy
    Then it should move to the Pharmacy Bill page successfully
    When the user clicks the Medicines button

  Scenario Outline: Verify medicine search
    Given the user is on the medicine stock page
    When the user searches medicine "<medicineName>"
    Then the medicine "<medicineName>" status be "<status>"

    Examples:
      | medicineName | status      |
      | Cetirizine   | present     |
      | Rifaximin    | not present |

  Scenario Outline: Delete a selected medicine
    Given the user is on the medicine stock page
    When the user selects the medicine "<medicineName>" from the medicine stock list
    And clicks the delete Selected button
    And the user confirms the alert displayed
    Then the message displayed as medicine deleted successfully

    Examples:
      | medicineName |
      | Ferigod XT   |
      | Mometasone   |

  Scenario: Verify user can view medicine details and stock entry using Show button
    Given the user is on the medicine stock page
    When the user clicks the Show button on any available medicine
    Then the medicine details page should be displayed
    And the stock entry details should be visible
