Feature: Blood Stock Status Validation

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
      | BloodDonor | DonateDate | Bag  | ChargeCategory     | ChargeName   |
      | Riyaz      | 05/18/2026 | 1234 | Packed Blood Cells | Blood Module |
    And the user clicks on donor Save button
    Then the blood donor details should be added successfully

  @BloodIssueNavigation
  Scenario: Verify user navigates to Blood Issue page
    When the user clicks issue button for bag number "56"
    Then the Blood Issue page should be displayed
