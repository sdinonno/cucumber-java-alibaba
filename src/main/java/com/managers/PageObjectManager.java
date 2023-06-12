package com.managers;

import com.pages.HomePage;
import com.pages.ProductPage;
import io.cucumber.messages.types.Product;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public ProductPage getProductPage(){
        return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
    }
}
