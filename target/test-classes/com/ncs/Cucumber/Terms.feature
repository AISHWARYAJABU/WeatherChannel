Feature: Verify Terms of Use Link
  As a user
  I want to verify the Terms of Use link
  So that I can navigate to the Terms of Use page
  Scenario: Verify Terms of Use Link
    Given I am on the weather.com homepage
    Then I should see the Terms of Use link
    When I click on the Terms of Use link
    Then I should be on the Terms of Use page