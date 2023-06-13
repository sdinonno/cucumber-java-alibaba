package com.pages;

import com.pages.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "search-key")
    private WebElement searchBox;
    @FindBy(className = "search-button")
    private WebElement searchButton;
    @FindBy(className = "cl-item")
    private List<WebElement> categories;

    @FindBy(className = "pagination--paginationLink")
    private List<WebElement> paginationButtons;

    @FindBy(className = "search-card-item")
    private List<WebElement>  searchItems;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void performSearch(String keyword){
        inputText(searchBox, keyword);
        clickElement(searchButton);
    }

    public void clickCategory(String category){
        clickElement(getElementFromList(categories, category));
    }

    public void goToSearchResultsPage(String pageNumber){
        clickElement(getElementFromList(paginationButtons, pageNumber));
    }

    public void openItemByOrder(String number){
        clickElement(getElementFromList(searchItems, number));
    }

}
