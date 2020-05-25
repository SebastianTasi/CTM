package com.CTM_TASK.Step_Definitions;

import com.CTM_TASK.Pages.YourSupplier;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NegativePostCode_StepDef {

    YourSupplier yourSupplier = new YourSupplier();

    @When("Trying to find the postcode again")
    public void trying_to_find_the_postcode_again() {

        yourSupplier.FindThePostCode.click();

    }

    @Then("I should receive an \\(Warning) message {string}")
    public void i_should_receive_an_Warning_message(String expectedMessage) {


        String actualMessage = yourSupplier.invalidPostCodeText.getText();
        Assert.assertNotEquals(" Try again with a valid postCode ! ",expectedMessage,actualMessage);

    }


}
