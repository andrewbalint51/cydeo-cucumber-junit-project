Feature: Cucumber Data Tables implementation practices

  @datatables
  Scenario: List of fruits and veggies I like
    Then user should see below list
    |orange      |
    |apple       |
    |kiwi        |
    |strawberry  |
    |tomato      |