Feature: Etsy search functionality

  Agile Story: User should be able to type and search for any information


  Scenario: Etsy Title Verification
    Given user is on the Etsy homepage
    Then user should see title as expected
    #Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for
    #everyone


  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    Given user is on the Etsy homepage
    When user types Wooden Spoon in the search box
    And user clicks the search button
    Then user should see Wooden Spoon in the title


  Scenario: Etsy Search Functionality Title Verification (with parameterization)
    Given user is on the Etsy homepage
    When user types "Wooden Spoon" in the search box
    And user clicks the search button
    Then user should see "Wooden spoon" in the Etsy title