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
  @mandatoryFields
  Scenario: Verify error when mandatory fields are missing
    And the user enters pharmacy bill details
      | category |  |
      | medicine |  |
    And user clicks the Save button
    Then the error message should be displayed

  @NewPatient
  Scenario: Verify user can add a new patient from the Generate Bill page
    When the user clicks the New Patient button
    Then the Add Patient modal should be displayed
    When the user enters new patient details
      | patientName | Prasath    |
      | ageYear     | 2003       |
      | ageMonth    | 02         |
      | ageDay      | 12         |
      | phone       | 9383888333 |
    And the user clicks the Patient Save button
    Then the record saved successfully message should be displayed
  
