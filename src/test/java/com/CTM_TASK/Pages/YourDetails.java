package com.CTM_TASK.Pages;

import com.CTM_TASK.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourDetails {

    public YourDetails() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//span[contains(text(),'Fixed tariff')]")
    public WebElement fixedElectricityTariff;

    @FindBy (xpath = "//span[contains(text(),'Variable tariff')]")
    public WebElement variableElectricityTariff;

    @FindBy (xpath = "//span[contains(text(),'All tariffs')]")
    public WebElement allElectricityTariff;

    @FindBy (xpath = "//span[@class='icon energy-gas-electricity annual-1']")
    public WebElement electricityTypeOfPaymentMonthlyDirectDebit;

    @FindBy (xpath = "//span[@class='icon energy-gas-electricity quarterly-1']")
    public WebElement electricityTypeOfPaymentQuarterlyDirectDebit;

    @FindBy (xpath = "//span[@class='icon energy-gas-electricity bill-1']")
    public WebElement electricityTypeOfPaymentPayOnReceiptOfBill;

    @FindBy (xpath = "///span[@class='icon energy-gas-electricity payment-all']")
    public WebElement electricityTypeOfPaymentAllPaymentsTypes;

    @FindBy (xpath = "//input[@id='Email']")
    public WebElement yourContactDetailsEmailAddress;

    @FindBy (xpath = "//span[@class='checkbox-text vertical']")
    public WebElement  optionalLetUsKeepYouUpToDate;

    @FindBy (xpath = "//span[@class='checkbox-confirm']")
    public WebElement confirmingTermsAndConditions;

    @FindBy (xpath = "//button[@id='email-submit']")
    public WebElement goToPricesPage;



}
