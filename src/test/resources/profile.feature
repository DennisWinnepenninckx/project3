Feature: View profiles
  As a user
  I can view profiles
  So that I can see personal information

  Scenario:  A user looks at their own profile
    Given Karel is logged in
    When Karel goes to his profile
    Then Karel can see his profile

  Scenario: A user looks at the profile of someone else
    Given Karel is logged in
    When Karel tries to go to a profiel of someone else
    Then Karel doesn't get the see their profile

  Scenario: A user tries to look at a non existing profile
    Given Karel is logged in
    When Karel goes to a bookmarked profile of a user that doesn't exist anymore
    Then Karel sees an error page

  Scenario: A manager can look at the profile of normal users
    Given Andreas is logged in
    When Andres wants to look at the profile of Karel
    Then Andreas will be able to see the profile of Karel

  Scenario: A super user can look at the profile of normal users
    Given Arne is logged in
    When  Arne wants to look at the profile of Karel
    Then Arne will be able to see the profile of Karel