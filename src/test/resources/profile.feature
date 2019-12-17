Feature: :
  As a user
  I can view profiles
  So that I can see personal information

  Background:
    Given Karel is not logged in

  Scenario:  A user looks at their own profile
    When Karel goes to his profile
    Then Karel can see his profile

  Scenario: A user looks at the profile of someone else
    When Karel goes to a profile of someone else
    Then Karel sees their profile except their stars given

  Scenario: A user tries to look at a non existing profile
    When Karel goes to a bookmarked profile of a user that doesn't exist anymore
    Then Karel sees an error page