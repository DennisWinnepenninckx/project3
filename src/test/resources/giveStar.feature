Feature: giving another user stars
  as a user i want to be able to give a star to another user,
  so that i can make him/her happy

  #Happy Scenario
  Scenario: A user who has not given 3 stars this month can give another user a star
    Given Karel has not given 3 stars this month
    When he gives a star to another user
    Then the other user receives a star

  #Unhappy scenario
  Scenario: A user who has given 3 stars this month can't give a star to another user
    Given Karel has already given 3 stars this month
    When Karel wants to give another user a star
    Then Karel receives an error


  Scenario: A user doesn't add a description to the star
     Given Karel wants to send a star without description
     When Karel tries to send the star
     Then Karel receives an error message

  Scenario: A user doesn't add a tag to the star
     Given A user doesn't add a tag to the star
     When Karel tries to send the star
     Then Karel receives an error message

  Scenario: A user tries to add a fifth tag to a star
     Given Karel has given 4 tags to a star
     When Karel tries to add another tag to the star
     Then Karel gets an error message

  Scenario: A user can't give himself a star
     Given Karel wants to send a star to himself
     When Karel tries to send the star
     Then Karel gets an error message
