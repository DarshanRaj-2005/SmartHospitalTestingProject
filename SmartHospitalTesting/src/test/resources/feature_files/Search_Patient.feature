Feature: Janani_17May2026_Smart_Hospital_Project

  @Jananisri @SearchPatient
  Scenario Outline: Search patient by name
    Given User is on Patient List page
    When User searches for patient name "<PatientName>"
    And clicks on Search button
    Then "<ResultType>" result should be displayed

    Examples:
      | PatientName          | ResultType |
      | John Marshall        | valid      |
      | XYZ123InvalidPatient | invalid    |
