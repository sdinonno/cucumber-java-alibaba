package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonMethods {

    static WebDriver driver;

    public CommonMethods(WebDriver driver){
        CommonMethods.driver = driver;
    }

    public static void navigate(String url){
        driver.navigate().to(url);
    }

    public static WebElement findElement(By locator){
        try {
            WebElement element = driver.findElement(locator);
            return element;
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found: " + locator);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static List<WebElement> findElements(By locator){
        try {
            List<WebElement> element = driver.findElements(locator);
            return element;
        }
        catch (NoSuchElementException e){
            System.out.println("Elements not found: " + locator);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static void clickOnContainingValue(List<WebElement> elements, String valueToBeContained){
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains(valueToBeContained.toLowerCase())) {
                element.click();
                return;
            }
        }
    }

    public static void inputText(By locator, String text){
        try {
            findElement(locator).sendKeys(text);
        }
        catch (Exception e) {
            System.out.println("Error trying to enter text.");
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static void clickElement(By locator){
        try{
                Thread.sleep(5000);
                findElement(locator).click();

        }
        catch (Exception e) {
            System.out.println("Error trying to click element.");
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static boolean elementIsVisible(By locator){
        try {
            findElement(locator).isDisplayed();
            return true;
        }
        catch (Exception e){
            System.out.println("Error trying to find element.");
            throw new NoSuchElementException(e.getMessage());
        }

    }

    public static String getValueOnInput(By locator){
        String valueInput = findElement(locator).getCssValue("value");
        return valueInput;
    }

    public static void switchNewWindow(){
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }


}
