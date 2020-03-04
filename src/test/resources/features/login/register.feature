Feature: Register
  As a user i want
  Scenario: Test invalid register without cell phone
    Given The user want to register in the page
    When The user clicks the login button
    And The user clicks the registrarse link
    And The user enters the data to register
    And The user clicks the Guardar button
    Then The user stays in the same page and is informed that cellphone is required