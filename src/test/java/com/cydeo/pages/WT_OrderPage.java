package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WT_OrderPage extends WTBasePage{

    public WT_OrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "product")
    public WebElement productDropdown;

    @FindBy (name="card")
    public List<WebElement> paymentOptions;

    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement visaRadioButton;

    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement masterCardRadioButton;

    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement americanExpressRadioButton;

    @FindBy(name = "quantity")
    public WebElement quantityBox;

    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement calculateButton;

    @FindBy(name = "name")
    public WebElement customerName;

    @FindBy(name = "street")
    public WebElement inputStreet;

    @FindBy(name = "city")
    public WebElement inputCity;

    @FindBy(name = "state")
    public WebElement inputState;

    @FindBy(name = "zip")
    public WebElement inputZip;

    @FindBy(name = "cardNo")
    public WebElement inputCardNo;

    @FindBy(name = "cardExp")
    public WebElement inputExpDate;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderButton;

}
