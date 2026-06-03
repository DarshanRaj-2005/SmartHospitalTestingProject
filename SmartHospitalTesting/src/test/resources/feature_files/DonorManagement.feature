@Harini @DonorManagement
Feature: Harini_13/05/26 Donor Management Functionality

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
  Scenario: Verify user is able to add donor with valid details
    When the user clicks on Add Blood Donor
    Then the Add Donor Details popup should be displayed
    When the user enters valid donor details
      | DonorName | DateOfBirth | BloodGroup | Gender | FatherName | ContactNumber | Address |
      | Raja      | 12/05/1998  | B+         | Male   | Ramesh     | 9876543210    | Chennai |
    And the user clicks on Save
    Then the newly added donor record should be visible in donor details list

  @AddDonorMandatory
  Scenario: Verify user is able to add donor with mandatory fields
    When the user clicks on Add Blood Donor
    Then the Add Donor Details popup should be displayed
    When the user enters mandatory donor details from csv
    And the user clicks on Save
    Then the newly added donor record should be visible in donor details list

  @AllFieldsEmpty
  Scenario: Validate donor creation with all mandatory fields empty
    When the user clicks on Add Blood Donor
    Then the Add Donor Details popup should be displayed
    And the user clicks on Save
    Then the donor validation messages should be displayed
      | Donor Name field is required    |
      | Date Of Birth field is required |
      | Blood Group field is required   |
      | Gender field is required        |

  @SearchDonor
  Scenario: Verify user is able to search donor name in donor list
    When User searches donor name
      | DonorName |
      | Oliver    |
    Then Donor details should be displayed
