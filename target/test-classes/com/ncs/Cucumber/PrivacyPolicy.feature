Feature: Verify Privacy Policy Page
  As a user
  I want to verify that the Privacy Policy page loads correctly
  Scenario: User navigates to the Privacy Policy page
    Given User is on the weather.com Privacy Policy homepage
    When User clicks on the Privacy Policy link
    Then User should be on the Privacy Policy page