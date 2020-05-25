package com.CTM_TASK.Pages;

import com.CTM_TASK.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {

    public MyDashboardPage() {
        PageFactory.initElements(Driver.get(), this);
    }



    @FindBy(xpath = "//a[contains(text(),'Start a new quote')]")
    public WebElement StartANewQuote;
}
