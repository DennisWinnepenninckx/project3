Feature: filter on tags or names
  As a user
  I can filter using tags or names
  so that I can see who got a star for what

  Scenario Outline: filter on tags
    Given Karel wants to see the stars with tag "<tagname>"
    When Karel searches for "<tagname>"
    Then he gets to see al the stars with that tag

    Examples:
      | tagname       |
      | Integrity     |
      | Curiosity     |
      | Collaboration |

  Scenario Outline: filter on names
    Given Karel wants to see the stars from "<name>"
    When Karel searches for "<name>"
    Then he gets to see al the stars from "<name>"

    Examples:
      | name    |
      | Karel   |
      | Andreas |
      | Arne    |