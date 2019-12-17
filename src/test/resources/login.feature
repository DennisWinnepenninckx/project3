Feature: Login
  As a user
  I want to login
  so that I can give stars

#happy
  Scenario: When somebody enters his correct credentials, he is logged in and gets to see the overview page
    Given Bobbe is on the login-page
    And Bobbe is not logged in
    And Bobbe has an account
    When Bobbe enters correct credentials
    Then he is logged in and sees the overview page

#unhappy
  Scenario Outline:  When somebody tries to login to an account but enters the wrong password, he gets an error
    Given "<name>" is not logged in
    And "<name>" is on the login-page
    And "<name>" has "<valid>" account
    When "<name>" enters "<credentials>"
    Then he gets an error :"<error>"

    Examples:
      | name    | valid   | credentials                          | error            |
      | Dirk    | invalid | nonexisting credentials              | nonexisting user |
      | Andreas | valid   | correct username with wrong password | wrong password   |
      | Karrel  | valid   | empty field                          | empty field      |