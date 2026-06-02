@Darshanraj
Feature: DarshanRaj_02-06-2026_Search Ambulance Record 

Background: 
Given the user is on the login page
When the user clicks Super Admin button
And the user clicks the Sign in button
Then the user should be redirected to super admin dashboard
When the user clicks Ambulance link
Then the user redirected to ambulance page

@ValidCredentials
Scenario Outline: Add Ambulance with valid Details

And the user enters "<datas>" in the search field 
Then the system should show the "<datas>"

Examples:
| datas |
| 7490 |
| 7647 |

@InvalidCredentials
Scenario Outline: Add Ambulance with invalid Details

And the user enters "<data>" in the search field 
Then the system should show the no data available error message

Examples:
| data |
| 7409 |
| 74$% |

