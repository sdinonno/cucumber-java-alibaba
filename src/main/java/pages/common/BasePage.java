package common;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class BaseClass {

        protected WebDriver driver;
        public String baseURL = "https://aliexpress.com/";

        public BaseClass(WebDriver driver) {
                this.driver = driver;
        }

        public void navigate(String url){
                driver.navigate().to(url);
        }

        public void clickElement(WebElement element){
                element.click();
        }

        public void inputText(WebElement element, String text){
                element.sendKeys(text);
        }

        public boolean elementIsVisible(WebElement element){
                return element.isDisplayed();
        }

        public WebElement getElementWithValue(List<WebElement> elements, String valueToBeContained){
                for (WebElement element : elements) {
                        if (element.getText().toLowerCase().contains(valueToBeContained.toLowerCase())) {
                                return element;
                        }
                }
        }

        public void switchTo(String window){
                driver.switchTo().window(window);
        }

        public String getWindowHandle(){
                return driver.getWindowHandle();
        }

        public Set<String> getWindowHandles(){
                return driver.getWindowHandles();
        }

        public String getCurrentUrl(){
                return driver.getCurrentUrl();
        }

        public void close(){
                driver.close();
        }
}



