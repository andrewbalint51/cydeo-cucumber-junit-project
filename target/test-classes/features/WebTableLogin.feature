Feature: Web table app login functionality


  Scenario: Positive Login Scenario
    Given user is on the WebTable App login page
    When user enters correct username
    And user enters correct password
    And user clicks login button
    Then user should see orders word in the URL


  Scenario: Positive Login Scenario (with parameterization)
    Given user is on the WebTable App login page
    When user enters "Test" as a username and "Tester" as a password
    And user clicks login button
    Then user should see orders word in the URL


  Scenario: Positive Login Scenario (with parameterization)
    Given user is on the WebTable App login page
    When user enters the below credentials
      | username | Test   |
      | password | Tester |
    And user clicks login button
    Then user should see orders word in the URL