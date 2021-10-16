package pages;

import framework.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage extends CommonMethods {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By searchBox = By.id("search-key");
    public By searchButton = By.className("search-button");
    public By numberPagesButtons = By.xpath("//div[@class = \"next-pagination-list\"]/*");
    public By productsResults = By.xpath("//div[@class=-top-container-]/following-sibling::div[1]/a");
    public By quantityItems = By.xpath("//div[@class = \"product-quantity-title\"]/following::span//input");

}
