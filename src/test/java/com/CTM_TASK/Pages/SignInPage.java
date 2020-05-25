package com.CTM_TASK.Pages;

import com.CTM_TASK.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class SignInPage {

    public SignInPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//input[@id='emailAddress']")
    public WebElement YourEmail;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement YourPassword;

    @FindBy (xpath = "//button[@id='signin-button-submit']")
    public WebElement SignInButton;


    public void login(String userNameStr, String passwordStr) {
        YourEmail.sendKeys(userNameStr);
        YourPassword.sendKeys(passwordStr);
        SignInButton.click();
    }

}
