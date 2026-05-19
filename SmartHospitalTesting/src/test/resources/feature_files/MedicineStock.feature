Feature: Balamurugan S 17-5-2026 Add and manage medicines in the medicine stock page

  Background:
    Given the user is on the login page
    When the user clicks Super Admin button
    And the user clicks the Sign in button
    Then the user should be redirected to super admin dashboard
    When the user clicks the Pharmacy
    Then it should move to the Pharmacy Bill page successfully
    When the user clicks the Medicines button

  Scenario: Verify medicine search
    Given the user is on the medicine stock page
    When the user searches medicine "Paracetamol"
    Then the searched medicine should be displayed in the table

  Scenario: Delete a selected medicine
    Given the user is on the medicine stock page
    When the user selects the medicine "Amoxicillin" from the medicine stock list
    And clicks the delete Selected button
    And the user confirms the alert displayed
    Then the message displayed as medicine deleteted successfully
