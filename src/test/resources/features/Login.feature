@smoke

  Feature: Login Functionality

    Scenario: Verify that the user would be able to sign in for a previous energy quote
      Given the user  should open the login CTM url
      When the user is inserting valid credentials
      Then the dashboard page should be display for starting a new quote