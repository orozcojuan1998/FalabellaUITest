Feature: Login
  As a user i want to login
  to buy products in the page
Background:
  Given The user is in the Falabella homepage
  And The user clicks the login button

  Scenario: Test succesful login
    When The user enters its data
    | email                     | password |
    | testjuanorozco5@gmail.com | test1234 |
    And Clicks the Iniciar sesion button
    Then The user is signed in


  Scenario: Test unsuccesful login password
    Given The user is in the Falabella homepage
    And The user clicks the login button
    When The user enters its data
      | email                     | password   |
      | testjuanorozco4@gmail.com | test12345  |
    And Clicks on the Iniciar sesion button
    Then The user stays in the same page and is informed that credentials are wrong

  Scenario: Test unsuccesful login email
    Given The user is in the Falabella homepage
    And The user clicks the login button
    When The user enters its data
      | email                        | password   |
      | testjuanorozco7895@gmail.com | test1234 |
    And Clicks on the Iniciar sesion button
    Then The user stays in the same page and is informed that credentials are wrong



