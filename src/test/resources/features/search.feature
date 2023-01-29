Feature: Search using selenium
  Scenario: Web search using selenium
    Given the user is on the browser
    When user searches for a text on web
    Then user should be able to see the result