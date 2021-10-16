package framework;

import org.omg.CORBA.SystemException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonMethods {

    WebDriver driver;

    public CommonMethods(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(String url){
        driver.navigate().to(url);
    }

    public WebElement findElement(By locator){
        try {
            WebElement element = driver.findElement(locator);
            return element;
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found: " + locator);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public List<WebElement> findElements(By locator){
        try {
            List<WebElement> element = driver.findElements(locator);
            return element;
        }
        catch (NoSuchElementException e){
            System.out.println("Elements not found: " + locator);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public void clickOnContainingValue(List<WebElement> elements, String valueToBeContained){
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains(valueToBeContained.toLowerCase())) {
                element.click();
                return;
            }
        }
    }

    public void inputText(By locator, String text){
        try {
            driver.findElement(locator).sendKeys(text);
        }
        catch (Exception e) {
            System.out.println("Error trying to enter text.");
            throw new NoSuchElementException(e.getMessage());
        }
    }


}
