Feature: Receive Mail
  As a user
  I and my manager get a mail when I receive a star
  So that we know

  Background:
    Given Karel is an employee
    When Karel gets a star from a colleague

  Scenario: A user receives a mail when he receives a star
    Then Karel receives a mail telling him that he got a star

  Scenario: A manager receives a mail when on of his users receives a star
    Then his manager Andreas receives a mail telling him that Karel got a star