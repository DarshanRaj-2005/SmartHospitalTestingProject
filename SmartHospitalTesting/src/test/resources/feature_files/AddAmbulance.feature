Feature: DarshanRaj_17-05-2026_Add Ambulance 

Background: 
Given the user is on the login page
When the user clicks Super Admin button
And the user clicks the Sign in button
Then the user should be redirected to super admin dashboard
When the user clicks Ambulance link
Then the user redirected to ambulance page
And the user clicks the add ambulance link
Then the user redirected to getcallambulance page

Scenario: Add Ambulance with valid Details


And the user enters ambulance call details
|patient | vehicleModel                    | date       | chargeCategory                  | chargeName       | note        | paymentMode |
|1185    | Force Traveller - MP21 AB 1023  | 17-05-2026 | ERS/Patient Transport Service   | Private Charge   | Test Note   | Cash        |

And the user clicks save button
Then the ambulance call should be added successfully

Scenario: Add Ambulance with empty fields
And the user clicks save button
Then the system should show validation error messages

Scenario: Entering character in charge field
And the user enters ambulance call details from excel "ValidData"
And the user clicks save button
Then the system should show invalid charge name field required message
