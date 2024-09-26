Feature: Checking the Current Location Label
  I am a user
  I want to check the whether the current location label in the application is displayed or not

  Scenario: Testing the Current Location Label
    When I accept the cookie policy
    And I click the search field
    Then I should see the current location label is displayed