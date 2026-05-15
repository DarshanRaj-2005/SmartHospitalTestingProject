Feature: Donor Management Functionality

  Background:
    Given the user is on the login page
    When the user clicks Super Admin button
    And the user clicks the Sign in button
    Then the user should be redirected to super admin dashboard
    When the user clicks on the Blood Bank menu
    And the user clicks on Donor Details
    Then the donor details page should be displayed
    And the user should be able to view all donor records

  @AddDonorValid
  Scenario Outline: Add donor with valid details

    When the user clicks on Add Blood Donor
    Then the Add Donor Details popup should be displayed
    When the user enters donor name "<DonorName>" and date of birth "<DateOfBirth>" and blood group "<BloodGroup>" and gender "<Gender>" and father name "<FatherName>" and contact number "<ContactNumber>" and address "<Address>"
    And the user clicks on Save button
    Then the newly added donor record should be visible in donor details list

    Examples:
      | DonorName | DateOfBirth | BloodGroup | Gender | FatherName | ContactNumber | Address |
      | Rahul     | 12/05/1998  | B+         | Male   | Ramesh     | 9876543210    | Chennai |

  @AddDonorMandatory
  Scenario Outline: Add donor with mandatory fields

    When the user clicks on Add Blood Donor
    Then the Add Donor Details popup should be displayed
    When the user enters donor name "<DonorName>" and date of birth "<DateOfBirth>" and blood group "<BloodGroup>" and gender "<Gender>"
    And the user clicks on Save button
    Then the newly added donor record should be visible in donor details list

    Examples:
      | DonorName | DateOfBirth | BloodGroup | Gender |
      | Rahul     | 12/05/1998  | B+         | Male   |