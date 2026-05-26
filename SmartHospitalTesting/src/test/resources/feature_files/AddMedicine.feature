@bala @AddMedicineDetails
Feature: Balamurugan S 23-05-2026 Add Medicine Details Management

  Background:
    Given the user is on the login page
    When the user clicks Super Admin button
    And the user clicks the Sign in button
    Then the user should be redirected to super admin dashboard
    When the user clicks the Pharmacy
    And the user clicks the Medicines button
    Then the medicine stock page should be displayed

  @ValidMedicineDetails
  Scenario: Verify user is able to add the medicine details using datatable
    When the user clicks the Add Medicines button
    Then the Add Medicine tab should be displayed
    When the user enters valid add medicine details
      | medicineName        | Azithromycin Plus   |
      | medicineCategory    | Tablet              |
      | medicineCompany     | Alkem Laboratories  |
      | medicineComposition | Azithromycin 500mg  |
      | medicineGroup       | Antibiotics         |
      | unit                | mg                  |
      | minLevel            | 20                  |
      | reorderLevel        | 50                  |
      | tax                 | 12                  |
      | boxPacking          | 10 tablets          |
      | vat                 | VAT250              |
      | rackNumber          | R45                 |
      | note                | Antibiotic medicine |
    And the user clicks on Add Medicine Save button
    Then the medicine details should be added successfully

  @MandatoryFieldValidation
  Scenario: Verify validation message when medicine name field is empty when using excel
    When the user clicks the Add Medicines button
    Then the Add Medicine tab should be displayed
    When the user enters add medicine details from excel
    And the user clicks on Add Medicine Save button
    Then the medicine name required validation message should be displayed
