package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaHomePage {

    public WikipediaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "searchInput")
    public WebElement searchBox;

    @FindBy (xpath = "//i[.='Search']")
    public WebElement searchButton;

}
