Feature: Janani_17May2026_Smart_Hospital_Project

  @Jananisri @SearchPatient 
  Scenario Outline: Search patient by name
    Given User is on Patient List page
    When User searches for patient name "<SearchName>"
    And clicks on Search button
    Then "<ExpectedResult>" result should be displayed

    Examples:
      | SearchName           | ExpectedResult |
      | John Marshall        | valid          |
      | XYZ123InvalidPatient | invalid        |