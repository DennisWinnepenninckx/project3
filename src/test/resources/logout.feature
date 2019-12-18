Feature: Logout
  As a user
  I can log out
  So that someone else can login on that device

  Background:
    Given Karel wants to logout
    Then an other user can login on that device

  Scenario: A user logs out
    When Karel logs out

  Scenario: A user can't logout when already logged out
    When Karel wants to logout but is already logged out

