package pages;

import common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String mainWindow;

    @FindBy(id = "search-key")
    private WebElement searchInput:

    public  By searchBox = By.id("search-key");
    public  By searchButton = By.className("search-button");
    public By closeSuscriptionButton = By.className("_24EHh");
    public  By numberPagesButtons = By.xpath("//button[contains(@class, \"next-pagination-item\")]");
    public  By secondProduct = By.xpath("//div[@class=\"top-container\"]/following-sibling::div[1]/div[2]");
    public  By quantityItems = By.xpath("//div[@class=\"product-quantity-title\"]/following::span//input");
    public  By dontAllowNotificationsButton = By.xpath("//div[contains(text(), \"Don't allow\")]");
    public  By closeDiscountButton = By.xpath("//img[@class=\"btn-close\"]");

    public void clickDoNotAllow

}
