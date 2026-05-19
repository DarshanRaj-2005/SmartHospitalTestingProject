Feature: Janani_17May2026_Smart_Hospital_Project
@Jananisri
Scenario: Search patient by patient name
  Given User is on Patient List page
  When User enters patient name in search box
  And clicks on Search button
  Then matching patient details should be displayed

@Jananisri
Scenario: Search patient with invalid name
  Given User is on Patient List page
  When User enters invalid patient name
  And clicks on Search button
  Then no records found message should be displayed