package com.CTM_TASK.Step_Definitions;

import com.CTM_TASK.Pages.*;
import com.CTM_TASK.Utilities.BrowserUtils;
import com.CTM_TASK.Utilities.ConfigurationReader;
import com.CTM_TASK.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.text.ParseException;


public class EnergyQuoteResultsHavingOldBill_StepDef {

    private static final Logger logger = LogManager.getLogger(EnergyQuoteResultsHavingOldBill_StepDef.class);
    YourSupplier yourSupplier = new YourSupplier();
    YourEnergy yourEnergy = new YourEnergy();
    YourDetails yourDetails = new YourDetails();
    YourResults yourResults = new YourResults();

    @Given("As a non valid user I should be able to open the browser and select my postcode {string}")
    public void as_a_non_valid_user_i_should_be_able_to_open_the_browser_and_select_my(String postCode) {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        try {

            BrowserUtils.waitForClickablility(By.xpath("//button[@id='find-postcode']"), 20);
        } catch (TimeoutException e) {

            e.printStackTrace();
            logger.error("We might have a serious problem with 'Find postcode' locator !!!");
        }
        yourSupplier.PostCodeInput.sendKeys(postCode);
        yourSupplier.FindThePostCode.click();


    }

    @Given("If I have a energy bill What I would like to compare {string} and choosing the supplier {string}")
    public void if_i_have_a_energy_bill_What_i_would_like_to_compare_and_choosing_the(String chooseWhichToCompare, String chooseSupplier) {



        yourSupplier.CurrentSupplierBill.click();

        if (chooseWhichToCompare.equalsIgnoreCase("gas_and_electricity")) {
            yourSupplier.CompareGasAndElectricity.click();
            yourSupplier.getYourCurrentElectricitySupplier(chooseSupplier).click();
        } else if (chooseWhichToCompare.equalsIgnoreCase("electricity")) {
            yourSupplier.CompareElectricity.click();
            yourSupplier.getYourCurrentElectricitySupplier(chooseSupplier).click();
        } else if (chooseWhichToCompare.equalsIgnoreCase("gas")) {
            yourSupplier.CompareGas.click();
            yourSupplier.getYourCurrentGasSupplier(chooseSupplier).click();
        }


        yourSupplier.nextPageToYourEnergy.click();

    }

    @When("The user is selecting which electricity tarif is using {string} and if using 'Economy7' meter {string}")
    public void the_user_is_selecting_if_using_a_pay_as_you_go_meter_or_Economy_meter(String electricityTariff, String chooseEconomymeter) {

        yourEnergy.setTheTariffAreYouUsing(electricityTariff);


        if (chooseEconomymeter.equalsIgnoreCase("yes")) {
            yourEnergy.usingEconomy7Meter.click();
        } else if (chooseEconomymeter.equalsIgnoreCase("no")) {
            yourEnergy.notUsingEconomy7Meter.click();
        }
    }

    @When("giving the usage for electricity in {string} = {string} {string} and choosing if electricity is the main source of heating {string}")
    public void giving_the_spendings_for_electricity_in_and_choosing_if_electricity_is_the_main_source_of_heating(String electricityUnitsConsumed, String electricityHowManyUnitsConsumed, String electricityPayPeriod, String isElectricityMainSource) throws ParseException {

        //yourEnergy.howDoYouPayYourElectricity(electricityPayPeriod);


        if (isElectricityMainSource.equalsIgnoreCase("yes")) {

            yourEnergy.isElectricityMainSource.click();
        } else if (isElectricityMainSource.equalsIgnoreCase("no")) {
            yourEnergy.isElectricityNotMainSource.click();
        }


        if (electricityUnitsConsumed.equalsIgnoreCase("kWh")) {

            yourEnergy.yourCurrentUsageInkWh.click();
        } else if (electricityHowManyUnitsConsumed.equalsIgnoreCase("£")) {
            yourEnergy.yourCurrentUsageIn£.click();
        }


        yourEnergy.yourCurrentUsageInkWhInput.sendKeys(electricityHowManyUnitsConsumed);

        yourEnergy.setYourCurrentUsageInkWhPerPeriod(electricityPayPeriod);

        yourEnergy.pickYourDateOnYourElectricityBill("02-Mar-2021");

        yourEnergy.goToYourDetails.click();



    }

    @When("Your preferences of selecting What tariff are you interested in {string} and how do you want to pay for your energy {string}")
    public void your_preferences_of_selecting_What_tarrif_are_you_interested_in_and_how_do_you_want_to_pay_for_your_energy(String choosingEnergyTariff, String howDoYouWantToPayEnergy) {


        if (choosingEnergyTariff.equalsIgnoreCase("Fixed tariff")) {
            yourDetails.fixedElectricityTariff.click();
        } else if (choosingEnergyTariff.equalsIgnoreCase("Variable tariff")) {
            yourDetails.variableElectricityTariff.click();
        } else if (choosingEnergyTariff.equalsIgnoreCase("All tariffs")) {
            yourDetails.allElectricityTariff.click();
        }

        if (howDoYouWantToPayEnergy.equalsIgnoreCase("Monthly direct debit")) {
            yourDetails.electricityTypeOfPaymentMonthlyDirectDebit.click();
        } else if (howDoYouWantToPayEnergy.equalsIgnoreCase("Quarterly direct debit")) {
            yourDetails.electricityTypeOfPaymentQuarterlyDirectDebit.click();
        } else if (howDoYouWantToPayEnergy.equalsIgnoreCase("Pay on receipt of bill")) {
            yourDetails.electricityTypeOfPaymentPayOnReceiptOfBill.click();
        } else if (howDoYouWantToPayEnergy.equalsIgnoreCase("All payment types")) {
            yourDetails.allElectricityTariff.click();

        }

    }

    @When("Your contact details are checked, your email address {string} let us keep you up to date \\(optional) {string} i can confirm terms and conditions")
    public void your_contact_details_are_checked_your_email_address_let_us_keep_you_up_to_date_optional_i_can_confirm(String yourEmailAddress, String letUsKeepYouUpdatedOnYourEmail) {

        yourDetails.yourContactDetailsEmailAddress.sendKeys(yourEmailAddress);

        if (letUsKeepYouUpdatedOnYourEmail.equalsIgnoreCase("yes")) {
            yourDetails.optionalLetUsKeepYouUpToDate.click();
        } else if (letUsKeepYouUpdatedOnYourEmail.equalsIgnoreCase("no")) {
            yourDetails.optionalLetUsKeepYouUpToDate.clear();
        }

        yourDetails.confirmingTermsAndConditions.click();
        yourDetails.goToPricesPage.click();

        BrowserUtils.waitFor(2);
        yourResults.iDontKnowTariffExpiryDate.click();
        yourResults.okayIGotItUpdateResults.click();
    }

    @Then("The user should get the results filtered by {string},{string},{string}")
    public void the_user_should_get_the_results_filtered_by(String tariffType, String paymentType, String supplierRating) {


        if (tariffType.equalsIgnoreCase("Fixed")) {

            yourResults.tariffTypeFixed.click();
        } else if (tariffType.equalsIgnoreCase("Variable")) {

            yourResults.tariffTypeVariable.click();
        }


        if (paymentType.equalsIgnoreCase("Monthly")) {

            yourResults.paymentTypeMonthly.click();
        } else if (paymentType.equalsIgnoreCase("Quarterly")) {

            yourResults.paymentTypeQuarterly.click();
        } else if (paymentType.equalsIgnoreCase("Pay on receipt of bill")) {

            yourResults.paymentTypePayOnReceiptOfBill.click();
        }


        if (supplierRating.equalsIgnoreCase("5Stars")) {

            yourResults.supplierRating5Stars.click();
        } else if (supplierRating.equalsIgnoreCase("4Stars")) {

            yourResults.supplierRating4Stars.click();
        } else if (supplierRating.equalsIgnoreCase("3Stars")) {

            yourResults.supplierRating3Stars.click();
        }


    }

    @Then("display the best quote results")
    public void display_the_best_quote_results() {


        yourResults.showMoreTariffs.click();

        yourResults.getTheResultsTariffInfo();


    }


}


