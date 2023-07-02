Feature: Bing search functionality
  Agile story: As a user, when I am on the Bing search page I
  should be able to search anything and see relevant results.


  Scenario: Search result title verification
    When user is on the Bing search page
    And user searches Bing for apple
    Then apple should be included in the Bing title


  Scenario: Search result title verification
    When user is on the Bing search page
    And user enters "orange" in the Bing search box
    Then user should see "orange" in the title