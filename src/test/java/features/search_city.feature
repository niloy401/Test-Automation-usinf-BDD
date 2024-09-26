Feature: Weather Temperature of any Specific City
  I am a user
  I want to check the current temperature
  To be able to check the weather temperature of any specific city

  Scenario: Testing the Search City
    When I accept the cookie policy
    And I enter "New York" in the search bar
    Then I should see the search results
    And  I click on the first search Result
    Then I should see page header contains "New York" city from the search result
