Feature: DarshanRaj_15-05-2026_Login Functionality

Background:
Given the user is on the login page


Scenario: Login with valid credentials
When the user clicks Super Admin button
And the user clicks the Sign in button
Then the user should be redirected to super admin dashboard


Scenario Outline: Login with invalid credentials
When the user clicks Super Admin button
And the user enters invalid "<username>" and valid password
And the user clicks the Sign in button
Then the system should show a message "Invalid Username or Password"

Examples:
| username  |
| super     |


Scenario: Login with empty fields
When the user clicks the Sign in button
Then the system should show username and password required messages