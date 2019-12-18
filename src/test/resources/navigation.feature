Feature: Navigation
  As a user
  I want to see which page I am on
  so that I can navigate easier

  Scenario: Navigation from page to page
    Given Karel is on a page
    When Karel hovers over the navigation
    Then the different navigation bars are highlighted when the mouse is above them

  Scenario: Indication current page
    Given Karel is on a page
    When Karel looks at the navigation bar
    Then The current page has another color