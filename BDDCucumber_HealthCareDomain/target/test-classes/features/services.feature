@services
Feature: Services Menu

  Scenario: Visit all services from the dropdown
    Given user is on the home page
    When user clicks on the Services menu
    Then user should see the list of services and visit each one
    And user closes the browser after navigating
