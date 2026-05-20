
@InventorySerach  @Tamilarasu
Feature: Tamilarsu. K 14-4-2026 Inventory_Search_feature


Background:
  Given the user is on the login page
  When the user clicks Super Admin button
  And the user clicks the Sign in button
  Then the user should be redirected to super admin dashboard
@validScenario
Scenario: Only Search products are listed in the table
  When the user clicks on Inventory
  And the user searches items from excel
  Then the items should display successfully
@invalidScenario
Scenario: Search items using invalid data
  When the user clicks on Inventory
  And the user searches the invalid data
  Then show No data available in table