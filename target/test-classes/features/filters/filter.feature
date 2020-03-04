Feature: Filter

  Scenario: Test filter price
    Given The guest user is in the Falabella homepage
    And The guest type "Stan smith" in the search bar
    When The guest apply the price for filter between "290000" and "350000"
    Then The guest should just see products in the given range