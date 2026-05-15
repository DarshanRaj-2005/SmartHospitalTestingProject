Feature: Janani_14May2026_Smart_Hospital_Project

  Scenario: Successfully add a patient with valid details
    Given Admin is on the Dashboard page
    Then admin clicks the patient category
    And Admin Clicks the Add new Patient
    When Admin enters patient details
      | PatientName | GuardianName | Gender | DOB        | BloodGroup | Phone      | Email                | Address |
      | Dravid | David Samuel | Male   | 12-05-2000 | B+         | 9876565630 | dravid68@gmail.com | Chennai |
    And clicks on Save button
    Then patient record should be created successfully
