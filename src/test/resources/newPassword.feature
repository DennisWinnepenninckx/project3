Feature: New password
  As a user
  I want to reset my password
  so that it is changed when compromised

  Scenario: correct reset
    Given Karel is on the profile page
    When Karel gives two identical password
    Then his password is reset

  Scenario: wrong reset
    Given Karel is on the profile page
    When Karel gives two different password
    Then his password isn't changed and he gets an error