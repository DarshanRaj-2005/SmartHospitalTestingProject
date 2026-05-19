Feature: Janani_14May2026_Smart_Hospital_Project
   
  @Jananisri
  Scenario: Successfully add a patient with valid details
    Given Admin is on the Dashboard page
    Then admin clicks the patient category
    And Admin Clicks the Add new Patient
    When Admin enters patient details
      | PatientName | GuardianName | Gender | DOB   | BloodGroup | Phone      | Email  | Address |
      | prajanr | sam  | Male   | 19-06-1992 |  A+     | 6734892211 | prajan220@gmail.com | Chennai |
    And clicks on Save button
    Then patient record should be created successfully

@Jananisri
Scenario: Verify mandatory fields while adding patient
    Given Admin is on the Add Patient page
    When Admin leaves mandatory fields empty
    And clicks on Save button
    Then validation message should be displayed