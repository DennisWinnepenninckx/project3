Feature: List of all given stars
  As a user
  I can see a list of all given stars
  So that I know who got a star

  Scenario: A logged in user can see a list of all given stars
    Given Karel is logged in
    When He goes to the overview page
    Then Karel will be able to see a list of all given stars

    Scenario: A user that's not logged in can't see a list of all given stars
      Given Karel is not logged in
      When He tries to go to the overview page
      Then Karel won't be able to see a list of all given stars
