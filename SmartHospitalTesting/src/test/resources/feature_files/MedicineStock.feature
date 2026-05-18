Feature: Add and manage medicines in the medicine stock page

  Background:
    Given the user is on the Pharmacy Bill page
    When the user clicks the Medicines button

  Scenario: Verify medicine search using DataTable
    Given the user is on the medicine stock page
    When the user searches medicine the following medicine
      | medicineName |
      | Paracetamol  |
    Then the searched medicine should be displayed in the table

  Scenario: Delete a selected medicine
    Given the user is on the medicine stock page
    When the user selects the medicine "Amoxicillin" from the medicine stock list
    And clicks the delete Selected button
    And the pop up appears for deleting the medicine confirmation
    And the user clicks ok
    Then the message displayed as medicine displayed
