Feature: Create a user
  As a superuser
  I want to be able to create a user
  So that users can give stars

  Scenario: A superuser can make a new user
    Given Arne is on the create user page
    When Arne makes a user with the following details:
      | lastname | firstname | email    |
      | Vanostet | karrel    | ka@g.com |
    Then a user with the given details is created
      | lastname | firstname | email    |
      | Vanostet | karrel    | ka@g.com |

  Scenario: A superuser can't create an account with an email that already exists
    Given Arne is on the create user page
    And a user with an email exists
      | email                 |
      | arne.walschap@ucll.be |
    When Arne creates a user with this email
    Then Arne sees an error
    And no account is created

  Scenario Outline: A superuser can't create an account without filling in all fields
    Given Arne is on the create user page
    When Arne creates an account with some of the "<details>" missing
    Then Arne sees an error
    And no account is created

    Examples:
      | details   |
      | firstname |
      | lastname  |
      | email     |

  Scenario: A superuser can't make a user his own manager
    Given Arne is on the create user page
    When Arne creates a user with himself as manager
    Then Arne sees an error
    And no account is created

  Scenario: A superuser can't make someone who doesn't exist manager
    Given Arne is on the create user page
    When Arne creates a user with as manager someone who doesn't exist
    Then Arne sees an error
    And no account is created

  Scenario: A superuser can make someone manager of another user
    Given Arne is on the create user page
    When Arne creates a user with a manager
    Then the account is created


