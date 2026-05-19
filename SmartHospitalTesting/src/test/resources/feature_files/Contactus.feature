@Contactus
Feature: Tamilarasu  K 17-05-2026 ContactUs  Page feature
Background:
  Given the user is on the home page

Scenario Outline: Submit contact form with valid details

  When the user clicks on contactUS
  And the user enters "<name>" "<email>" "<subject>" "<description>"
  And the user clicks submit button
  Then the contatus  should be submitted successfully

Examples:
  | name        | email              | subject        | description            |
  | Tamil      | tamil@gmail.com    | Test Subject   | This is a test message |
 
