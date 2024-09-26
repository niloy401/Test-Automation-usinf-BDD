Feature: Checking The Weather Temperature of any Specific City from Recent Location Tab
  I am a user
  I want to check the current temperature of any specific city
  To be able to check the weather temperature from the recent city tab

  Scenario: Testing the Recent Location
    When I accept the cookie policy
    And  I enter "London" in the search bar
    And  I click on the first search Result
    And  I Go back to Main Page
    Then I will validate the main page is opened or not
    When I Choose the first City in Recent Location
    Then I should see page header contains "London" city from the search result


