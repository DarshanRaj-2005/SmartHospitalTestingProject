@complain  @Tamilarasu
Feature: Tamilarasu  k 17-05-2026 Raise Complaint


Background:
  Given the user is on the home page
@validScenario
Scenario: Raise a complaint with valid details

  When the user clicks on complaint
  And the user enters complaint details 
  And the user clicks submit button
  Then the complaint should be submitted successfully
@invalidScenario
Scenario: Raise a complaint with missing data

  When the user clicks on complaint
  And the user submits the form without entering details
  Then an error message should be displayed