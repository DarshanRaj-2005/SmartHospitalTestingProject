@Darshanraj
Feature: DarshanRaj_17-05-2026_Add Payment 

Background: 
Given the user is on the login page
When the user clicks Super Admin button
And the user clicks the Sign in button
Then the user should be redirected to super admin dashboard
When the user clicks Ambulance link
Then the user redirected to ambulance page
And the user clicks the add payment link
Then the user redirected to add payment page


@ValidCredentials
Scenario: Add Payment with valid detials

And the user enters the add payment detials
And the user clicks on the save button
Then the payment transaction should be added successfully


@ValidCredentials
Scenario: Delete the payment successfully
And the user clicks the delete button
Then the payment transaction should be deleted successfully

@InvalidCredentials
Scenario: Add Payment with empty fields

And the user clicks on the save button
Then the system should show error message

