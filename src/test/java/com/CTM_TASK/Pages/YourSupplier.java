package com.CTM_TASK.Pages;

import com.CTM_TASK.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class YourSupplier {

    public YourSupplier() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//a[@id='sign-in-prompt-link']")
    public WebElement PreviousEnergyQuotes;

    @FindBy (xpath = "//button[@id='change-postcode']")
    public WebElement ChangeThePostCode;
    @FindBy (xpath = "//input[@id='your-postcode']")
    public WebElement PostCodeInput;
    @FindBy (xpath = "//button[@id='find-postcode']")
    public  WebElement FindThePostCode;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/section[3]/div[2]/fieldset[1]/div[1]/div[1]/label[1]/span[1]")
    public WebElement CurrentSupplierBill;
    @FindBy (xpath = "//span[contains(text(),'t have my bill')]")
    public WebElement CurrentSupplierMissingBill;

    @FindBy (xpath = "//span[@class='icon energy-gas-electricity']")
    public WebElement CompareGasAndElectricity;
    @FindBy (xpath = "//span[@class='icon energy-electricity']")
    public WebElement CompareElectricity;
    @FindBy (xpath = "//span[@class='icon energy-gas']")
    public WebElement CompareGas;

    @FindBy (xpath = "//label[@class='electricity-supplier-dont-know']//span[@class='checkbox-confirm'][contains(text(),'t know')]")
    public WebElement IDontKnowElectricitySupplierCheckBox;
    @FindBy (xpath = "//label[@class='gas-supplier-dont-know']//span[@class='checkbox-confirm'][contains(text(),'t know')]")
    public WebElement IDontKnowGasSupplierCheckBox;


    @FindBy (xpath = " //button[@id='goto-your-supplier-details']")
    public WebElement nextPageToYourEnergy;

    @FindBy (xpath = "//div[@class='error ng-binding']")
    public WebElement invalidPostCodeText;








    public WebElement getYourCurrentElectricitySupplier(String electricSupplier){
        String xpathElectricity = "//fieldset[@id='elec-energy-suppliers-question']//span[@class='icon top-6-"+electricSupplier+"']";
        return Driver.get().findElement(By.xpath(xpathElectricity));
    }

    public WebElement getYourCurrentGasSupplier(String gasSupplier){
        String xpathGas = "//fieldset[@id='gas-energy-suppliers-question']//span[@class='icon top-6-"+gasSupplier+"']";
        return Driver.get().findElement(By.xpath(xpathGas));
    }

    public WebElement getYourCurrentElectricitySupplierDropDown(String electricSupplierDropDown){
        String xpathElectricityDropDown = "//select[@id='sel1']//option[contains(text(),'e"+electricSupplierDropDown+"')]";
        return Driver.get().findElement(By.xpath(xpathElectricityDropDown));
    }

    public WebElement getYourCurrentGasSupplierDropDown(String electricSupplierDropDown){
        String xpathGasDropDown = "//select[@id='sel2']//option[contains(text(),'"+electricSupplierDropDown+"')]";
        return Driver.get().findElement(By.xpath(xpathGasDropDown));
    }

}

