package pages;

import framework.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage extends CommonMethods {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static By searchBox = By.id("search-key");
    public static By searchButton = By.className("search-button");
    public static By numberPagesButtons = By.xpath("//div[@class = \"next-pagination-list\"]/*");
    public static By secondProduct = By.xpath("//div[@class= \"top-container\"]/following-sibling::div[1]/div[2]");
    public static By quantityItems = By.xpath("//div[@class = \"product-quantity-title\"]/following::span//input");

}
