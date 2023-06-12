package com.pages;

import com.pages.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = ".next-input.next-medium")
    private WebElement quantity;
    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public int getDefaultQuantity(){
        return Integer.parseInt(quantity.getAttribute("value"));
    }
}
