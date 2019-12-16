Feature: giving another user stars
  as a user i want to be able to give a star to another user,
  so that i can make him/her happy

  #Happy Scenario
  Scenario: A user who has not given 3 stars this month can give another user a star
    Given the user1 has not given 3 stars this month
    When he gives a star to another user
    Then the other user receives a star

  #Unhappy scenario
  Scenario: A user who has given 3 stars this month can't give a star to another user
    Given the user has already given 3 stars this month
    When The user wants to give another user a star
    Then the user receives an error


   Scenario: A user doesn't add a description to the star
     Given The user wants to send a star without description
     When The user tries to send the star
     Then The user receives an error message

   Scenario: A user doesn't add a tag to the star
     Given A user doesn't add a tag to the star
     When the user tries to send the star
     Then the user receives an error message

   Scenario: A user tries to add a fifth tag to a star
     Given The user has given 4 tags to a star
     When The user tries to add another tag to the star
     Then the user gets an error message

     Scenario: A user can't give himself a star
       Given a user wants to send a star to himself
       When the user tries to send the star
       Then He gets an error message
