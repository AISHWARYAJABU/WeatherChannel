Feature: Verify Accessibility on weather.com
  As a user
  I want to verify that the weather.com website is accessible
  Scenario: Verify accessibility of the weather.com website
    Given User is on the weather.com homepage
    When User checks the accessibility of the page
    Then Accessibility tests should pass