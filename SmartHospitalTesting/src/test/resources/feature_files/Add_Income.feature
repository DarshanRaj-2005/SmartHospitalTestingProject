Feature: Janani_27May2026_Smart_Hospital_Project

  Background:
    Given Admin is on the Dashboard page

  # Scenario 1: Add multiple income records from Excel
  @Jananisri @Income
  Scenario: Successfully add income records from Excel
    Then Admin clicks a Finance Category
    And Admin clicks Income Category
    And Admin clicks Add Income button
    When Admin adds all income records from Excel
    Then income record should be created successfully

  # Scenario 2: Save without filling mandatory fields — validation errors must appear
  @Jananisri @IncomeMandatory
  Scenario: Verify validation errors when mandatory fields are empty
    Then Admin clicks a Finance Category
    And Admin clicks Income Category
    And Admin clicks Add Income button
    When Admin clicks Save without filling mandatory fields
    Then income validation errors should be displayed

  # Scenario 3: Add single income with inline data — success toast must appear
  @Jananisri @IncomeSingle
  Scenario: Successfully add a single income record with valid data
    Then Admin clicks a Finance Category
    And Admin clicks Income Category
    And Admin clicks Add Income button
    When Admin fills income details with Head "Hospital charges" Name "Lab Test Income" Amount "1500"
    And clicks on Income Save button
    Then income record should be created successfully

  # Scenario 4: Add income filling only mandatory fields (Invoice + Description left empty)
  @Jananisri @IncomeMandatoryOnly
  Scenario: Add income record filling only mandatory fields
    Then Admin clicks a Finance Category
    And Admin clicks Income Category
    And Admin clicks Add Income button
    When Admin fills only mandatory income fields with Head "Canteen Rent" Name "Rent Payment" Amount "4000"
    And clicks on Income Save button
    Then income record should be created successfully