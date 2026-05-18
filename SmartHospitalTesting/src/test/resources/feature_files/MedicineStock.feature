Feature: Add and manage medicines in the medicine stock page
    Background:
    Given the user is on the Pharmacy Bill page
    When the user clicks the Medicines button
    
    Scenario:Verify whether searched medicine displayed in the table
    Given the user is on the medicine stock page
    When the user searches for a medicine by name
    Then the searched medicine should be displayed in the table
    
    Scenario:Delete a particular selected medicine
    Given the user is on the medicine stock page
    When the user selects a medicine from the medicine stock list
    And clicks the delete Selected button
    And the pop up appears for the deleting the medicine for confirmation
    And the user clicks ok 
    Then the message appears as medicine deleted successfully
    