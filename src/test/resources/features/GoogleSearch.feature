Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page I
  should be able to search anything and see relevant results.

  Scenario: Search page default title verification
    When user is on the google search page
    Then user should see the title is Google

  Scenario: Search result title verification
    When user is on the google search page
    And user searches for a keyword
    Then keyword should be included in the title