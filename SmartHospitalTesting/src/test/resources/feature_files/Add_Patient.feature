Feature: Janani_14May2026_Smart_Hospital_Project

  Background:
    Given Admin is on the Dashboard page

  # Scenario 1 : Add patient with all valid details using DataTable
  @Jananisri @AddPatientDetails
  Scenario: Successfully add a patient with valid details
    Then admin clicks the patient category
    And Admin Clicks the Add new Patient
    When Admin enters patient details
      | PatientName | GuardianName | Gender | DOB        | BloodGroup | Phone      | Email                | Address |
      | Ramkumar      | Rajasingh          | Male | 19-06-1962 | AB+         | 9876521123 | ramkumar12@gmail.com | Madurai |
    And clicks on Save button
    Then patient record should be created successfully

  # Scenario 2 : Submit form without entering mandatory Name field
  @Jananisri @WithoutFillingMandatory
  Scenario: Verify mandatory fields while adding patient
    Then admin clicks the patient category
    And Admin Clicks the Add new Patient
    When Admin leaves mandatory fields empty
    And clicks on Save button
    Then validation message should be displayed

  # Scenario 3 : Enter DOB and verify Year Month Day are auto-filled by site
  @Jananisri @DOBAutoFill
  Scenario: Verify DOB auto fills age fields
    Then admin clicks the patient category
    And Admin Clicks the Add new Patient
    When Admin enters only DOB as "19-06-1972"
    Then age fields Year Month Day should be auto filled

  # Scenario 4 : Clear DOB field and re-enter a new DOB
  @Jananisri @DOBReEntry
  Scenario: Verify DOB re-entry updates age fields
    Then admin clicks the patient category
    And Admin Clicks the Add new Patient
    When Admin enters only DOB as "19-06-1972"
    And Admin clears DOB and re-enters "01-01-2000"
    Then age fields Year Month Day should be auto filled