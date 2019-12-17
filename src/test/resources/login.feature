Feature: Login
  As a user
  I want to login
  so that I can give stars

#happy
  Scenario: When somebody enters his correct credentials, he is logged in and gets to see the overview page
    Given Karel is on the login-page
    And Karel is not logged in
    And Karel has an account
    When Karel enters correct credentials
    Then he is logged in and sees the overview page

#unhappy
  Scenario: When somebody tries login with a nonexistent username, he gets an error
    Given Karel is not logged in
    And Karel is on the login-page
    And Karel has no account
    When Karel enters nonexistent credentials
    Then he gets an error :"nonexisting user"

  Scenario:  When somebody tries to login, but forgets a field, he gets an error
    Given Karrel is not logged in
    And Karrel is on the login-page
    And Karrel has an account
    When Karrel forgets a field
    Then he gets an error :"empty field"

  Scenario:  When somebody tries to login to an account but enters the wrong password, he gets an error
    Given Karel is not logged in
    And Karel is on the login-page
    And Karel has an account
    When Karel enters the wrong password
    Then he gets an error :"wrong password"
