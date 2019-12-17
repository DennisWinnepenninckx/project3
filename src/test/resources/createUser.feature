Feature: Create a user
  As a superuser
  I want to be able to create a user
  So that users can give stars

  Scenario: A superuser can make a new user
    Given the superuser is on the create user page
    When the superuser makes a user with the following details:
      | lastname | firstname | email    |
      | Vanostet | karrel    | ka@g.com |
    Then a user with the given details is created

  Scenario: A superuser can't create an account with an email that already exists
    Given the superuser is on the create user page
    And a user with an email exists
      | email                 |
      | arne.walschap@ucll.be |
    When the superuser creates a user with this email
    Then the superuser sees an error
    And no account is created

  Scenario Outline: A superuser can't create an account without filling in all fields
    Given the superuser is on the create user page
    When the superuser creates an account with "<email>", "<fname>", "<lname>" where at least one is empty
    Then the superuser sees an error
    And no account is created

    Examples:
      | email                 | fname | lname |
      |                       | name  | name  |
      | arne.walschap@ucll.be |       | name  |
      | arne.walschap@ucll.be | name  |       |

  Scenario: A superuser can't make a user his own manager
    Given the superuser is on the create user page
    When the superuser creates a user with as manager this user
    Then the superuser sees an error
    And no account is created

  Scenario: A superuser can't make someone who doesn't exist manager
    Given the superuser is on the create user page
    When the superuser creates a user with as manager someone who doesn't exist
    Then the superuser sees an error
    And no account is created

  Scenario: A superuser can make someone manager of another user
    Given the superuser is on the create user page
    When the superuser creates a user with a manager
    Then the account is created


