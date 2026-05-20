@AddNewStock  @Tamilarasu
Feature:  Tamilarsu K 14-4-2026 Add Item Stock


  Background:

	Given the user is on the login page
	When the user clicks Super Admin button
	And the user clicks the Sign in button
	Then the user should be redirected to super admin dashboard

@validScenario
  Scenario Outline: Successfully add stock items

    When the user clicks on Inventory
    And the user clicks the Add Item Stock button
    And the user selects Item Category, Item, Supplier, and Store
    And the user fills the details such as Quantity "<Quantity>" and Purchase Price "<PurchasePrice>" and Description "<Description>"
    And the user clicks the Save button
    Then the item stock should be added successfully

    Examples:
      | Quantity | PurchasePrice | Description      |
      | 10       | 250           | New stock added  |
       | 20       | 2500           | New stock added  |
      
      
@invalidScenario    
      Scenario Outline: New itemstock should not add if any fields are missing

    When the user clicks on Inventory
    And the user clicks the Add Item Stock button
    And the user selects Item Category, Item, Supplier, and Store
    And the user fills the details such as Quantity "<Quantity>" and Purchase Price "<PurchasePrice>" and Description "<Description>"
    And the user clicks the Save button
    Then the item stock should not  be added  successfully

    Examples:
      | Quantity | PurchasePrice | Description      |
      |  123456      |      23456      |       1234567         |
        |  123456      |      23456      |       1234567         |
      
      