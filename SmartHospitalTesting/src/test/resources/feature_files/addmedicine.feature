Feature: Balamurugan S 19-05-2026 Add and manage medicines with inventory tracking

  Background:
    Given the user is on the login page
    When the user clicks Super Admin button
    And the user clicks the Sign in button
    Then the user should be redirected to super admin dashboard
    When the user clicks the Pharmacy
    Then it should move to the Pharmacy Bill page successfully
    When the user clicks the Medicines button
    Then the user is on the medicine stock page


  @addMedicineValid @bala
  Scenario: Verify adding medicine with valid details from Excel
    When the user clicks the Add Medicine button
    And the user enters medicine details from row 1
    And the user clicks the Save button
    Then the medicine should be added successfully
    And the success message should display "Medicine added successfully"
    And the medicine "Paracetamol" should appear in the medicine list

  @addMedicineInvalid @bala
  Scenario: Verify error when expiry date is missing (Excel row 7)
    When the user clicks the Add Medicine button
    And the user enters medicine details from row 7
    And the user clicks the Save button
    Then the error message should display "Expiry Date is required"