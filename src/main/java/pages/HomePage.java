package pages;

import common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {

    public String mainWindow;
    public  By searchBox = By.id("search-key");
    public  By searchButton = By.className("search-button");
    public By closeSuscriptionButton = By.className("_24EHh");
    public  By numberPagesButtons = By.xpath("//button[contains(@class, \"next-pagination-item\")]");
    public  By secondProduct = By.xpath("//div[@class=\"top-container\"]/following-sibling::div[1]/div[2]");
    public  By quantityItems = By.xpath("//div[@class=\"product-quantity-title\"]/following::span//input");
    public  By dontAllowNotificationsButton = By.xpath("//div[contains(text(), \"Don't allow\")]");
    public  By closeDiscountButton = By.xpath("//img[@class=\"btn-close\"]");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickDoNotAllow

}
