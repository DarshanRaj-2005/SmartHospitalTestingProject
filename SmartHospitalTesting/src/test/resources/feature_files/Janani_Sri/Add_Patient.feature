Feature: Janani_14May2026_Smart_Hospital_Project


  Scenario: Successfully add a patient with valid details
    Given Admin is on the Add Patient page
    When Admin enters patient details
      | PatientName | GuardianName | Gender | DOB        | BloodGroup | Phone      | Email                | Address  |
      | John Samuel | David Samuel | Male   | 12-05-2000 | B+         | 9876543210 | johnsamuel@gmail.com | Chennai  |
    And clicks on Save button
    Then patient record should be created successfully
