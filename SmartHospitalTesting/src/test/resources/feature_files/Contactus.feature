@ContactUs @Tamilarasu
Feature: Tamilarasu K 17-05-2026 ContactUs Page feature

Background:
Given the user is on the home page

@validScenario
Scenario Outline: Submit contact form using valid details

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us should be submitted successfully

Examples:
| name       | email            | subject  | description                     |
| Tamilarasu | acctamil151@gmail.com   | Testing  | Need information about services |
| Karthik    | acctamil151@gmail.com  | Callback | Requesting a callback           |
| Priya      | acctamil151@gmail.com    | Enquiry  | General enquiry                 |


@emptyName
Scenario Outline: Submit contact form without name

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name | email          | subject | description |
|      | acctamil151@gmail.com   | Testing | Test Data   |

@emptyEmail
Scenario Outline: Submit contact form without email

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name       | email | subject | description |
| Tamilarasu |       | Testing | Test Data   |

@emptySubject
Scenario Outline: Submit contact form without subject

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name       | email          | subject | description |
| Tamilarasu | acctamil151@gmail.com   |         | Test Data   |

@emptyDescription
Scenario Outline: Submit contact form without description

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name       | email          | subject | description |
| Tamilarasu | acctamil151@gmail.com  | Testing |             |


@maxLengthValidation
Scenario Outline: Submit contact form with extremely long values

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name                                                                 | email          | subject                                                              | description                                                              |
| VeryLongUserNameVeryLongUserNameVeryLongUserNameVeryLongUserName     | acctamil151@gmail.com    | VeryLongSubjectVeryLongSubjectVeryLongSubjectVeryLongSubject         | VeryLongDescriptionVeryLongDescriptionVeryLongDescriptionVeryLongDescription |
