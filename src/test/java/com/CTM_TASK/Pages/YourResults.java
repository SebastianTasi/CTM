package com.CTM_TASK.Pages;

import com.CTM_TASK.Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourResults {

    public YourResults() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//label[@id='filters-tariff-type-fixed']//span[@class='button-ticks']")
    public WebElement tariffTypeFixed;

    @FindBy(xpath = "//label[@id='filters-tariff-type-variable']//span[@class='button-ticks']")
    public WebElement tariffTypeVariable;

    @FindBy(xpath = "//label[@id='filters-payment-type-monthly']//span[@class='button-ticks']")
    public WebElement paymentTypeMonthly;

    @FindBy(xpath = "//label[@id='filters-payment-type-quarterly']//span[@class='button-ticks']")
    public WebElement paymentTypeQuarterly;

    @FindBy(xpath = "//label[@id='filters-payment-type-bill-receipt']//span[@class='button-ticks']")
    public WebElement paymentTypePayOnReceiptOfBill;

    @FindBy(xpath = "//label[@id='filters-supplier-rating-five-star']//span[@class='button-ticks']")
    public WebElement supplierRating5Stars;

    @FindBy(xpath = "//label[@id='filters-supplier-rating-four-star-and-up']//span[@class='button-ticks']")
    public WebElement supplierRating4Stars;

    @FindBy(xpath = "//label[@id='filters-supplier-rating-three-star-and-up']//span[@class='button-ticks']")
    public WebElement supplierRating3Stars;

    @FindBy(xpath = "//span[@class='checkbox-confirm']")
    public WebElement iDontKnowTariffExpiryDate;

    @FindBy(xpath = "//button[@id='tariff-end-date-update-results-button']")
    public WebElement okayIGotItUpdateResults;

    @FindBy(xpath = "//table[@class='price-table ng-scope']")
    public WebElement allTariffTable;

    @FindBy(xpath = "//span[contains(text(),'More tariffs')]")
    public WebElement showMoreTariffs;


    public void getTheResultsTariffInfo() {


        List<WebElement> getTheHeaderInfoTable = Driver.get().findElements(By.xpath("//tr[@class='thead-headings']"));
        for (int i = 0; i <= getTheHeaderInfoTable.size() - 1; i++) {
            WebElement infoHeader = getTheHeaderInfoTable.get(i);

            Assert.assertTrue("Verify if the Header of the results table is visible ", infoHeader.isDisplayed());
        }

//        List<WebElement> getRowDetails = Driver.get().findElements(By.xpath("//tbody"));
//        for (int j = 0; j <= getRowDetails.size() - 1; j++) {
//            WebElement infoSupplier = getRowDetails.get(j);
//
//            System.out.print(infoSupplier.getText());
//        }

    }

}





