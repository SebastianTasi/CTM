package com.CTM_TASK.Pages;

import com.CTM_TASK.Utilities.BrowserUtils;
import com.CTM_TASK.Utilities.Driver;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class YourEnergy {


    public YourEnergy() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//fieldset[@id='prepay-yes-no']//span[@class='radio-button-text'][contains(text(),'Yes')]")
    public WebElement usingPasAsYouGoMeter;

    @FindBy(xpath = "//fieldset[@id='prepay-yes-no']//span[@class='radio-button-text'][contains(text(),'No')]")
    public WebElement notUsingPasAsYouGoMeter;

    @FindBy(xpath = "//fieldset[@id='economy-7-question']//span[@class='radio-button-text'][contains(text(),'Yes')]")
    public WebElement usingEconomy7Meter;

    @FindBy(xpath = "//label[@class='checked']//span[@class='radio-button-text'][contains(text(),'No')]")
    public WebElement notUsingEconomy7Meter;

    @FindBy(xpath = "//input[@id='electricity-current-spend']")
    public WebElement howMuchElectricityUsed;

    @FindBy(xpath = "//fieldset[@id='elec-current-spend-question']//option[1]")
    public WebElement dropDownTimeSpendings;

    @FindBy(xpath = "//fieldset[@id='electricity-main-heating-source-question']//label[@class='checked']")
    public WebElement isElectricityMainSource;

    @FindBy(xpath = "//fieldset[@id='electricity-main-heating-source-question']//label[@class='checked']")
    public WebElement isElectricityNotMainSource;

    @FindBy (xpath = "//fieldset[@id='electricity-usage-question']//span[@class='radio-button-text'][contains(text(),'kWh')]")
    public WebElement yourCurrentUsageInkWh;

    @FindBy (xpath = "//fieldset[@id='electricity-usage-question']//span[@class='radio-button-text'][contains(text(),'£')]")
    public WebElement yourCurrentUsageIn£;

    @FindBy (xpath = "//input[@id='electricity-usage']")
    public WebElement yourCurrentUsageInkWhInput;

    @FindBy (xpath = "//fieldset[@id='electricity-usage-question']//select[@id='usage-dropdown']")
    public WebElement YourCurrentUsageInkWhPerPeriod;

    @FindBy (xpath = "//button[@id='goto-your-energy']")
    public WebElement goToYourDetails;



    public void setTheTariffAreYouUsing(String electricityTariff) {

        WebElement dropDownElectricityTariffList = Driver.get().findElement(By.xpath("//select[@id='electricity-tariff-additional-info']"));
        dropDownElectricityTariffList.click();


        for (int i = 0; i <= electricityTariff.length()-1; i++) {
            List<WebElement> electricityTariffList = Driver.get().findElements(By.xpath("//select[@id='electricity-tariff-additional-info']"));
            WebElement check = electricityTariffList.get(i);

            if (check.getText().contains(electricityTariff)) {
                Driver.get().findElement(By.xpath("//select[@id='electricity-tariff-additional-info']//option[contains(text(),'" + electricityTariff + "')]")).click();
                break;
            } else {
                System.out.println("Please enter a valid electricity tariff !");
            }


        }

    }

    public void howDoYouPayYourElectricity(String electricityTariffWayOfPay) {

        WebElement dropDownElectricityTariffTypeOfPay = Driver.get().findElement(By.xpath("//select[@id='electricity-payment-method-dropdown-link']"));
        dropDownElectricityTariffTypeOfPay.click();


        for (int i = 0; i <= electricityTariffWayOfPay.length()-1; i++) {
            List<WebElement> electricityTariffList = Driver.get().findElements(By.xpath("//select[@id='electricity-payment-method-dropdown-link']"));
            WebElement checkWayOfPay = electricityTariffList.get(i);

            if (checkWayOfPay.getText().contains(electricityTariffWayOfPay)) {
                Driver.get().findElement(By.xpath("//option[contains(text(),'"+electricityTariffWayOfPay+"')]")).click();
                break;
            } else {
                System.out.println("Please enter a valid way of pay !");
            }


        }

    }

    public void setYourCurrentUsageInkWhPerPeriod(String yourCurrentUsageInkWhPerPeriod) {

        WebElement dropDownElectricityTariffTypeOfPay = Driver.get().findElement(By.xpath("//section[@class='section content-right']//div[@class='question-wrapper']//div[@class='flexbox']//div[2]"));
        dropDownElectricityTariffTypeOfPay.click();


        for (int i = 0; i <= yourCurrentUsageInkWhPerPeriod.length()-1; i++) {
            List<WebElement> electricityUsageinkWhPerPeriod = Driver.get().findElements(By.xpath("//section[@class='section content-right']//div[@class='question-wrapper']//div[@class='flexbox']//div[2]"));
            WebElement checkkWhUsagePeriod = electricityUsageinkWhPerPeriod.get(i);

            if (checkkWhUsagePeriod.getText().contains(yourCurrentUsageInkWhPerPeriod)) {
                Driver.get().findElement(By.xpath("//fieldset[@id='electricity-usage-question']//div[@class='question-wrapper']//div[@class='flexbox']//option[contains(text(),'"+yourCurrentUsageInkWhPerPeriod+"')]")).click();
                break;
            } else {
                System.out.println("Please enter a valid period of pay of kWh !");
            }


        }

    }

    public void pickYourDateOnYourElectricityBill (String dayOfMonth) throws ParseException {

        Driver.get().findElement(By.xpath("//span[@class='date-picker-icon datepicker-elec-icon']")).click();

        //String setDateStr = dayOfMonth; // dd//MM/yyyy

        String currentDate =  Driver.get().findElement(By.xpath("//div[@id='electricity-bill-day_root']//div[@class='picker__header']")).getText(); // MMMM yyyy

        Date setDate = new SimpleDateFormat("DD-MMM-YYYY").parse(dayOfMonth);
        Date currDate = new SimpleDateFormat("MMMyyyy").parse(currentDate);


        int monthdiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();

        boolean isFuture = true;

        if(monthdiff<0){
            isFuture=false;
            monthdiff=-1*monthdiff;
        }

        for(int i = 0 ; i<monthdiff; i++){
            if(isFuture)
                Driver.get().findElement(By.xpath("//div[@id='electricity-bill-day_root']//div[@class='picker__nav--next picker__nav--disabled']")).click();
            else
            Driver.get().findElement(By.xpath("//div[@id='electricity-bill-day_root']//div[@class='picker__nav--prev']")).click();
        }

        String day;

        day = new SimpleDateFormat("DD").format(setDate);

        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//section[@class='section content-right']//tr[1]//td[4]//div[1]")).click();




//
    }



}

