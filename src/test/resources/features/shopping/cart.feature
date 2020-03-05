Feature: Shopping Cart

  Background: Login
    Given The user is in the Falabella homepage
    And The user clicks the login button
    When The user enters its data
      | email                     | password |
      | testjuanorozco5@gmail.com | test1234 |
    And Clicks the Iniciar sesion button
    Then The user is signed in

  Scenario: Test add product to cart
    When The user looks for "crema facial"  in the search bar
    And The user selects any displayed result to add to the shopping cart
    And The user adds the product to its shopping cart
    Then The user should see the product name in the cart
