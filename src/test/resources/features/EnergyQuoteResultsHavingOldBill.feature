@smoke

Feature: Step by Step energy quotation results

  Scenario Outline: Verify as a non valid user I should get energy quote results
    Given As a non valid user I should be able to open the browser and select my postcode "PE2 6YS"
    And If I have a energy bill What I would like to compare "Electricity" and choosing the supplier "eon"

    When The user is selecting which electricity tarif is using "E.ON Smart Saver v8" and if using 'Economy7' meter "no"
    And giving the usage for electricity in "kWh" = "200" "Monthly" and choosing if electricity is the main source of heating "yes"
    And Your preferences of selecting What tariff are you interested in "Fixed tariff" and how do you want to pay for your energy "Monthly direct debit"
    And Your contact details are checked, your email address "tasi.sebastian@gmail.com" let us keep you up to date (optional) "yes" i can confirm terms and conditions

    Then The user should get the results filtered by "<Tariff type>","<Payment Type>","<Supplier rating>"
    And display the best quote results

    Examples: filters

      | Tariff type | Payment Type | Supplier rating |
      | Fixed       | Monthly      | 5Stars          |
      | Variable    | Monthly      | 5Stars          |





