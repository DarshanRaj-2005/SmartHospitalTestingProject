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
| Tamilarasu | [tamil@test.com](mailto:tamil@test.com)   | Testing  | Need information about services |
| Karthik    | [karthik@test.com](mailto:karthik@test.com) | Callback | Requesting a callback           |
| Priya      | [priya@test.com](mailto:priya@test.com)   | Enquiry  | General enquiry                 |

@invalidEmail
Scenario Outline: Submit contact form with invalid email format

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name       | email          | subject  | description   |
| Tamilarasu | tamiltest.com  | Testing  | Invalid Email |
| Karthik    | karthik@       | Callback | Invalid Email |
| Priya      | @gmail.com     | Enquiry  | Invalid Email |

@emptyName
Scenario Outline: Submit contact form without name

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name | email          | subject | description |
|      | [tamil@test.com](mailto:tamil@test.com) | Testing | Test Data   |

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
| Tamilarasu | [tamil@test.com](mailto:tamil@test.com) |         | Test Data   |

@emptyDescription
Scenario Outline: Submit contact form without description

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name       | email          | subject | description |
| Tamilarasu | [tamil@test.com](mailto:tamil@test.com) | Testing |             |

@specialCharacters
Scenario Outline: Submit contact form using special characters

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name     | email          | subject | description |
| @@@@     | [tamil@test.com](mailto:tamil@test.com) | ###     | $$$$$       |

@sqlInjection
Scenario Outline: Submit contact form with SQL injection data

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name            | email          | subject           | description         |
| ' OR 1=1 --     | [test@test.com](mailto:test@test.com)  | SQL Test          | SQL Injection Test  |

@xssAttack
Scenario Outline: Submit contact form with script tags

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name                     | email          | subject | description                |
| <script>alert(1)</script>| [test@test.com](mailto:test@test.com)  | XSS     | XSS Attack Attempt         |

@maxLengthValidation
Scenario Outline: Submit contact form with extremely long values

When click on the contactus button
And the user enters valid contacts details "<name>" "<email>" "<subject>" and "<description>"
And the user clicks submit button in the contact us
Then the contact us submission should fail

Examples:
| name                                                                 | email          | subject                                                              | description                                                              |
| VeryLongUserNameVeryLongUserNameVeryLongUserNameVeryLongUserName     | [test@test.com](mailto:test@test.com)  | VeryLongSubjectVeryLongSubjectVeryLongSubjectVeryLongSubject         | VeryLongDescriptionVeryLongDescriptionVeryLongDescriptionVeryLongDescription |
