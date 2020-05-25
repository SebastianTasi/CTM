package com.CTM_TASK.Step_Definitions;


import com.CTM_TASK.Pages.MyDashboardPage;
import com.CTM_TASK.Pages.SignInPage;
import com.CTM_TASK.Pages.YourSupplier;
import com.CTM_TASK.Utilities.BrowserUtils;
import com.CTM_TASK.Utilities.ConfigurationReader;
import com.CTM_TASK.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Login_StepDef {

    YourSupplier yourSupplier = new YourSupplier();
    SignInPage signInPage = new SignInPage();
    MyDashboardPage myDashboardPage = new MyDashboardPage();


    @Given("the user  should open the login CTM url")
    public void the_user_should_open_the_login_CTM_url() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        yourSupplier.PreviousEnergyQuotes.click();

    }

    @When("the user is inserting valid credentials")
    public void the_user_is_inserting_valid_credentials() {

        String userName = ConfigurationReader.get("YourEmail");
        String passWord = ConfigurationReader.get("YourPassword");

        BrowserUtils.waitFor(1);
        signInPage.login(userName,passWord);

    }

    @Then("the dashboard page should be display for starting a new quote")
    public void the_dashboard_page_should_be_display_for_starting_a_new_quote() {

        myDashboardPage.StartANewQuote.click();

        String expectedUrl = "https://energy.comparethemarket.com/energy/v2/";
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Actual URL" , expectedUrl,Driver.get().getCurrentUrl());

    }



}
