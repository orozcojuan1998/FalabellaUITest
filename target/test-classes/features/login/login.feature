Feature: Login
  As a user i want to login
  to buy products in the page

  Scenario: Test succesful login
    Given The user is in the Falabella homepage
    And The user clicks the login button
    When The user enters its data
    | email                    | password |
    | testjuanorozco3@gmail.com | test1234 |
    And Clicks the Iniciar sesion button
    Then The user is signed in


  Scenario: Test unsuccesful login password
    Given The user is in the Falabella homepage
    And The user clicks the login button
    When The user enters its data
      | email                     | password   |
      | testjuanorozco3@gmail.com | test12345  |
    And Clicks the Iniciar sesion button
    Then The user stays in the same page and is informed that credentials are wrong

  Scenario: Test unsuccesful login email
    Given The user is in the Falabella homepage
    And The user clicks the login button
    When The user enters its data
      | email                        | password   |
      | testjuanorozco7895@gmail.com | test1234 |
    And Clicks the Iniciar sesion button
    Then The user stays in the same page and is informed that credentials are wrong


