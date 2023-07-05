Feature: General functionality verifications


  Scenario: Order place scenario
    Given user is already logged in to the WebTable app
    When user is on the order page
    Then user should see below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |

  #this is incorrect, due to radio button  labels
  Scenario: Payment options scenario with data tables
    Given user is already logged in to the WebTable app
    When user is on the order page
    Then user should see below radio buttons enabled
      | Visa             |
      | MasterCard       |
      | American Express |


  Scenario: Payment options scenario
    Given user is already logged in to the WebTable app
    When user is on the order page
    Then user sees Visa enabled as a payment option
    Then user sees MasterCard enabled as a payment option
    Then user sees American Express enabled as a payment option


  Scenario: Placing order scenario
    Given user is already logged in to the WebTable app
    When user is on the order page
    And user selects "MoneyCog" from the products dropdown
    And user enters "2" as a quantity
    Then user clicks the calculate button
    And user enters customer name "Jane Doe"
    And user enters street address "123 Main St"
    And user enters city "Popville"
    And user enters state "NY"
    And user enters zip "12345"
    And user selects payment option "American Express"
    And user enters card number "1111222233334444"
    And user enters expiration date "12/25"
    And user clicks process order button
    Then user should see "Jane Doe" in the first row of the web table

  @wip
  Scenario Outline: Placing order scenario with scenario outline
    Given user is already logged in to the WebTable app
    When user is on the order page
    And user selects "<product>" from the products dropdown
    And user enters "<quantity>" as a quantity
    Then user clicks the calculate button
    And user enters customer name "<name>"
    And user enters street address "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zip "<zip>>"
    #below was hard
    And user selects payment option "<paymentOption>"
    And user enters card number "<cardNo>"
    And user enters expiration date "<expDate>"
    And user clicks process order button
    Then user should see "<name>" in the first row of the web table

    Examples: Test data we will be using
      | product  | name | quantity | street      | city     | state | zip   | paymentOption    | cardNo           | expDate |
      | MoneyCog | 2    | Jane Doe | 123 Main St | Popville | NY    | 12345 | American Express | 1111222233334444 | 12/28   |
      | MoneyCog | 2    | Jack Doe | 123 Main St | Popville | NY    | 12345 | American Express | 1111222233334444 | 12/28   |
      | MoneyCog | 2    | John Doe | 123 Main St | Popville | NY    | 12345 | American Express | 1111222233334444 | 12/28   |