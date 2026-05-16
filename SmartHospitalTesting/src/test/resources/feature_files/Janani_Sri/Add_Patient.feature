Feature: Janani_14May2026_Smart_Hospital_Project

  Scenario: Successfully add a patient with valid details
    Given Admin is on the Dashboard page
    Then admin clicks the patient category
    And Admin Clicks the Add new Patient
    When Admin enters patient details
      | PatientName | GuardianName | Gender | DOB        | BloodGroup | Phone      | Email  | Address |
      | deni | Ram  | Female   | 15-10-1982 | A+     | 6754786857 | deni1584@gmail.com | Kerala |
    And clicks on Save button
    Then patient record should be created successfully
