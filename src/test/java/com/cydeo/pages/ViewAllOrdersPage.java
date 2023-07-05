package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllOrdersPage extends WTBasePage{

    public ViewAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//table[@class='table is-fullwidth']/tbody//td)[1]")
    public WebElement firstListedCell;
}
