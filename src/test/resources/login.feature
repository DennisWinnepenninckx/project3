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
  Scenario: When somebody tries login with a nonexistent username, he gets an error
    Given Dirk is not logged in
    And Dirk is on the login-page
    And Dirk has no account
    When Dirk enters nonexistent credentials
    Then he gets an error :"nonexisting user"

  Scenario:  When somebody tries to login, but forgets a field, he gets an error
    Given Karrel is not logged in
    And Karrel is on the login-page
    And Karrel has an account
    When Karrel forgets a field
    Then he gets an error :"empty field"

  Scenario:  When somebody tries to login to an account but enters the wrong password, he gets an error
    Given Andreas is not logged in
    And Andreas is on the login-page
    And Andreas has an account
    When Andreas enters the wrong password
    Then he gets an error :"wrong password"
