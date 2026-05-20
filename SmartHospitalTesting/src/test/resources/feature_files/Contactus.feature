@Contactus  @Tamilarasu
Feature: Tamilarasu K 17-05-2026 ContactUs Page feature

Background:
  Given the user is on the home page
@validScenario
Scenario: Submit contact form using CSV data

  When the user enters contact details from csv file
  And the user clicks submit button in the contact us
  Then the contact us should be submitted successfully