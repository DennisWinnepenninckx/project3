Feature: Receive Mail
  As a user
  I get a mail when I receive a star
  So that I know

  Scenario: A user receives a mail when he receives a star
    Given Karel is an employee
    When Karel gets a star from a colleague
    Then Karel receives a mail telling him that he got a star