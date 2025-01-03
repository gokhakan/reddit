@regression
Feature: Login tests

  Scenario: Successful login
    Given user is on home page
    And user clicks on login icon
    When user logs in
    Then user is logged in successfully

  @wip
  Scenario: Topic search
    Given user is on home page
    And user clicks on login icon
    When user logs in
    And user searches for "sport"



