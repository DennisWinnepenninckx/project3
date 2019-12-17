Feature: Ability to see all given stars
  As a user
  I can see all the stars I have given away

  Scenario: A user tries to see the stars they've given away
    Given Karel wants to see all the stars he has given away
    When Karel goes to his profile
    Then Karel will be able to see all the stars he has given away

  Scenario: A user tries to see the stars someone else has given away
    Given Karel wants to see all the stars Andreas has given away
    When Karel goes to Andreas his profile
    Then Karel won't be able to see all the stars Andreas has given away