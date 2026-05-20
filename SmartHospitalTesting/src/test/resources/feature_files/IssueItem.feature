
@issueitem   @Tamilarasu
Feature: Tamilarsu K 14-4-2026 Issue An Item


Background:
	Given the user is on the login page
	When the user clicks Super Admin button
	And the user clicks the Sign in button
	Then the user should be redirected to super admin dashboard
	When the user clicks on Inventory
@validScenario
	Scenario: User adds issue item successfully

	When the user clicks the Issue Item button and the Issue New Item button

	And the user select the usertype issuedate and retrundate and itemcategory and item
	| Admin | 04/29/2026 | 05/10/2026 | Syringe Packs | Syringe |

	And the user Enters the quality and note
	| 5 | Test |

	Then the issue item should be added successfully


@invalidScenario
Scenario: User adds issue item with missing fields shows validation messages

	When the user clicks the Issue Item button and the Issue New Item button

	And the user skips entering mandatory issue item details

	And the user Enters the quality and note
	| 5 | Test |

	Then the issue item should not be added and show missing field details