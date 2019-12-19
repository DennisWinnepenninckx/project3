Feature: delete User
  As an admin
  I want to be able to remove a user
  Scenario: An admin deletes a user
    Given the admin is on the users page
    When the admin tries to delete a user
    Then the user will be deleted

