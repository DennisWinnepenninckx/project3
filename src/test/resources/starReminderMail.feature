Feature: Star reminder mail before losing all the stars at the end of the month
  as a user i recieve an email the day before my stars will be lost
  so that i know i still have stars left

  Scenario: user recieves mail before his stars are lost
    Given Karel still has stars the day before he will lose them
    When the dat before the stars will be deleted has come
    Then the mail will be sent to Karel with a reminder