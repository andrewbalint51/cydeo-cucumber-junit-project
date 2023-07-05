package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class R_VytrackLoginPage {

    public R_VytrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "prependedInput")
    public WebElement emailBox;

    @FindBy (id = "prependedInput2")
    public WebElement passwordBox;

    @FindBy (id = "_submit")
    public WebElement loginButton;

    public void login(String username, String password){
        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }
}
