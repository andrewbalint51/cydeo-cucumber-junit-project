Feature: Wiki Search Features


  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User should see "Steve Jobs" is in the wiki title


  Scenario: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User should see "Steve Jobs" in the main header

  @andrew-wip
  Scenario: Wikipedia Search Functionality Image Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User should see "Steve Jobs" in the image header

    @ScenarioOutline
  Scenario Outline: Wikipedia Search Functionality With Scenario Outline
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User should see "<expectedTitle>" is in the wiki title
    Then User should see "<expectedMainHeader>" in the main header
    Then User should see "<expectedImageHeader>" in the image header

    Examples: Search values we are going to be using in this scenario outline
      | searchValue | expectedTitle | expectedMainHeader | expectedImageHeader |
      | Steve Jobs  | Steve Jobs    | Steve Jobs         | Steve Jobs          |