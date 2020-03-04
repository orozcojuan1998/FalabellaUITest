Feature: Logout
  As a user i want to logout
  from the web page

  Background: Login
    Given The user is in the Falabella homepage
    And The user clicks the login button
    When The user enters its data
      | email                    | password |
      | testjuanorozco3@gmail.com | test1234 |
    And Clicks the Iniciar sesion button
    Then The user is signed in

    Scenario: Test successful log out
      Given The user is wants to log out
      When The user hover on the account button and clicks the log out button
      Then The user is logout from the web page
