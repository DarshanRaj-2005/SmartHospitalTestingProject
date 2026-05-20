@Additems @Tamilarasu
Feature: Add New Items in Inventory



Background:
  Given the user is on the login page
  When the user clicks Super Admin button
  And the user clicks the Sign in button
  Then the user should be redirected to super admin dashboard
@validScenario
Scenario Outline: User adds new inventory item successfully

  Given the user clicks on Inventory
  And the user clicks the Add new item button and click add item  
  When the user enters item details "<name>" "<category>" "<unit>" "<description>"
  And the user clicks the save button
  Then the item should be added successfully

Examples:
  | name           | category | unit | description                                                                 |
  | Syringe        | Medical  | 100  | Operating Scissors are general medical scissors used in surgery            |
  | Syringe Packs  | Surgical | 50   | General surgical tools used for various operations                          |