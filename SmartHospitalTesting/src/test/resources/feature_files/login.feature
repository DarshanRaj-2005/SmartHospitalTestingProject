@Darshanraj
Feature: DarshanRaj_15-05-2026_Login Functionality

Background:
Given the user is on the login page


@ValidCredentials
Scenario: Login with valid credentials
When the user clicks Super Admin button
And the user clicks the Sign in button
Then the user should be redirected to super admin dashboard


@InvalidCredentials
Scenario: Login with invalid username credentials
When the user clicks Super Admin button
And the user enters invalid username and valid password
And the user clicks the Sign in button
Then the system should show a message "Invalid Username"


@InvalidCredentials
Scenario: Login with empty fields
When the user clicks the Sign in button
Then the system should show username and password required messages


@InvalidCredentials
Scenario: Login with invalid password credentials
When the user clicks Super Admin button
And the user enters valid username and invalid password
And the user clicks the Sign in button
Then the system should show a message "Invalid Password"

@InvalidCredentials
Scenario Outline: Login with invalid username and password
And the user enter invalid "<username>" and "<password>"
And the user clicks the Sign in button
Then the system should show a message "Invalid "

Examples:
|username | password |
|super    | 1234     |
|admin    | 5678     |

