package com.pages.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class BasePage {

        protected WebDriver driver;
        public String baseURL = "https://aliexpress.com/";

        public BasePage(WebDriver driver) {
                this.driver = driver;
        }

        public void navigate(String url){
                driver.navigate().to(url);
        }

        public void clickElement(WebElement element){
                waitElementVisibility(element);
                element.click();
        }

        public void inputText(WebElement element, String text){
                waitElementVisibility(element);
                element.sendKeys(text);
        }

        public boolean elementIsVisible(WebElement element){
                return element.isDisplayed();
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

        protected WebElement getElementFromList(List<WebElement> elements, String text){
                for(WebElement e : elements){
                        if(e.getText().equals(text)){
                                return e;
                        }
                }
                throw new NoSuchElementException("Cannot find element.");
        }

        protected void waitElementVisibility(WebElement element){
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class);
                wait.until(t -> element.isDisplayed());
        }
}



