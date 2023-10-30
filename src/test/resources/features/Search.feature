Feature: Product Search

  Scenario: User searches for a valid product
    Given the user is on the search page
    When the user enters the valid product name "Hp"
    And the user clicks the Search button
    Then the search results for product should be displayed

  Scenario: User searches for an invalid product
    Given the user is on the search page
    When the user enters an invalid product name "XYZ123"
    And the user clicks the Search button
    Then the search results should show "There is no product that matches the search criteria."

  Scenario: User searches with an empty field
    Given the user is on the search page
    When the user leaves the search field empty
    And the user clicks the Search button
    Then the search results should show "There is no product that matches the search criteria."