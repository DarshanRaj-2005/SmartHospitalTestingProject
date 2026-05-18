Feature: View the Pharmacy Bill page

Background:
Given the user is on the login page
When the user clicks Super Admin button
And the user clicks the Sign in button
Then the user should be redirected to super admin dashboard

Scenario: Verify whether the Pharmacy Bill page displays successfully
When the user clicks the Pharmacy
Then it should move to the Pharmacy Bill page successfully