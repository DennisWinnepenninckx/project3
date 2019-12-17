Feature: Ability to see all gotten stars
  As a user
  I can see all stars I got
  So that I know for what I got a star

  Scenario: A user can see all the stars they received
    Given Karel wants to see all his stars
    When Karel goes to his profile
    Then Karel will see all the stars he has received

  Scenario: A user tries to see all the stars someone else has received
    Given Karel wants to see Andreas his stars
    When Karel goes to the profile of Andreas
    Then Karel will see all the stars Andreas received