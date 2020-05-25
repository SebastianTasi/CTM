@smoke
  Feature: Invalid PostCode Scenario
    
    Scenario: The user should choose an invalid UK`s postcode
      Given As a non valid user I should be able to open the browser and select my postcode "PE2 6YSS"
      When Trying to find the postcode again
      Then I should receive an (Warning) message "Please supply a valid UK postcode again!"
      