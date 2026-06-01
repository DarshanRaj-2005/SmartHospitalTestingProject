@Harini
@BloodStockValidation
Feature: Harini_18/05/26 Blood Stock Status Validation

  Background:
    Given the user is on the login page
    When the user clicks Super Admin button
    And the user clicks the Sign in button
    Then the user should be redirected to super admin dashboard
    When the user clicks on the Blood Bank menu
    Then the Blood Stock Status page should be displayed

  @BloodGroupSelection
  Scenario Outline: Verify blood stock details for different blood groups
    When the user selects blood group "<BloodGroup>"
    Then the corresponding blood bag details should be displayed and the corresponding blood component details should be displayed

    Examples:
      | BloodGroup |
      | B+         |
      | A+         |
      | O+         |
      | AB-        |

  @AddBloodDonorDetails
  Scenario: Verify user is able to add blood donor details

    When the user clicks on add icon
    Then the Blood Donor Details popup should be displayed
    When the user enters valid blood donor details
      | BloodDonor | DonateDate | Bag | ChargeCategory     | ChargeName   |
      | Riyaz      | 05/18/2026 | 1234 | Packed Blood Cells | Blood Module |
    And the user clicks on donor Save button
    Then the blood donor details should be added successfully
  @BloodIssueNavigation
Scenario: Verify user navigates to Blood Issue page
  When the user clicks issue button for below bag number
    | Bag |
    | 56  |
  Then the Blood Issue page should be displayed
  
 @DonorAllFieldsEmpty
Scenario: Validate donor details with all mandatory fields empty

  When the user clicks on add icon
  Then the Blood Donor Details popup should be displayed
  And the user clicks Save button without entering donor details
  Then the donor details validation messages should be displayed
    | Blood Donor field is required      |
    | Donate Date field is required      |
    | Bag No field is required           |
    | Charge Category field is required  |
    | Charge Name field is required      |
    | Standard Charge field is required  |
    | Payment Amount field is required   |