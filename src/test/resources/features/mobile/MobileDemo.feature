Feature: Scroll and open Tabs from Views

  Scenario: User navigates to Tabs section
    When User is on the home screen
    When User clicks on Views
    And User scrolls until Tabs is visible and clicks
    And User reset the app


  Scenario: User navigates to Tabs section and opens ImageView
    When User is on the home screen
    When User clicks on Views
    Then I fetch all list items
    And I print all items
    And I click on "ImageView"